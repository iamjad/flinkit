
import custom.CarCrashDateAggregator;
import model.*;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaSourceExample {
    private static final Logger log = LoggerFactory.getLogger(KafkaSourceExample.class);

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        var  kafkaSource =
                KafkaSource.<CarCrash>builder().setBootstrapServers("localhost:9092")
                        .setGroupId("flink_consumer2")
                        .setTopics("mvvc-topic")
                        .setStartingOffsets(OffsetsInitializer.committedOffsets(OffsetResetStrategy.EARLIEST))
                        .setValueOnlyDeserializer(new CarCrashDeserializationSchema())
                        .setDeserializer(new CarCrashDeserializationSchema()
                        .build();

        // let's run this aggregation. Select count(numberOfPersonsKilled), zipcode from car_crash group by zip_code
        // Add Kafka consumer to the Flink environment
        DataStream<CarCrash> kafkaStream = env.fromSource(kafkaSource, WatermarkStrategy.noWatermarks(), "Kafka Sources");
        // stream keyby zipCode, window by 2 mins, sum the total people killed and return the total sum by zipCode
//        kafkaStream.keyBy(CarCrash::getZipCode)
//                .window(TumblingProcessingTimeWindows.of(Time.minutes(2)))
//                .aggregate(new CarCrashZipCodeAggregator())
//                .print();
        // stream keyby crashDate, window by 2 mins, sum the total people killed and return the total sum by crash date
        kafkaStream.keyBy(CarCrash::getCrashDate)
                .window(TumblingProcessingTimeWindows.of(Time.minutes(2)))
                .aggregate(new CarCrashDateAggregator())
                .addSink(KafkaSink.<Tuple2<CarCrashDateAccumulator, Integer>>builder()
                        .setBootstrapServers("localhost:9092")
                        .setRecordSerializer(new CarCrashSinkSchema("car-crash-date-accumulator"))
                        .build());

        // Add Kafka producer to the Flink environment to write the CarCrashZipCodeAccumulator to Kafka.


        // Execute the Flink environment
        env.execute("Kafka Consumer Example");
    }
    public static void eventProcessor() throws Exception {
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
}
