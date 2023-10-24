
import model.*;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.formats.json.JsonDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class kafkaTopicConsumer {

    public static void main1(String[] args) throws Exception {
        KafkaSource<Event> source =
                KafkaSource.<Event>builder()
                        .setBootstrapServers("localhost:9092")
                        .setTopics("events-topic-one")
                        .setStartingOffsets(OffsetsInitializer.earliest())
                        .setValueOnlyDeserializer(new EventDeserializationSchema())
                        .build();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<Event> stream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");
        stream.filter(event -> event.id % 2 == 0).map(new MapFunction<Event, String>() {
            @Override
            public String map(Event event) throws Exception {
                return event.data;
            }
        }).print();
        env.execute("Kafka Consumer Example");
    }

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        var  kafkaSource =
                KafkaSource.<CarCrash>builder().setBootstrapServers("localhost:9092")
                        .setGroupId("flink_consumer2")
                        .setTopics("mvvc-topic")
                        .setStartingOffsets(OffsetsInitializer.committedOffsets(OffsetResetStrategy.EARLIEST))
                        .setValueOnlyDeserializer(new CarCrashDeserializationSchema())
                        .build();

        // Add Kafka consumer to the Flink environment
        DataStream<CarCrash> kafkaStream = env.fromSource(kafkaSource, WatermarkStrategy.noWatermarks(), "Kafka Sources");
        kafkaStream.filter(carCrash -> Integer.parseInt(carCrash.getNumberOfMotoristKilled()) >= 1).map(new MapFunction<CarCrash, String>() {
            @Override
            public String map(CarCrash carCrash) throws Exception {
                return carCrash.getNumberOfPersonsKilled();
            }
        }).print();
        env.execute("Kafka Consumer Example");
    }
}
