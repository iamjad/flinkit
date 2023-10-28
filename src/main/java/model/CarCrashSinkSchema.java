package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.kafka.clients.producer.ProducerRecord;

public class CarCrashSinkSchema implements KafkaRecordSerializationSchema<CarCrashDateAccumulator> {
    private static final ObjectMapper objectMapper = JsonMapper.builder().build();

    @Override
    public ProducerRecord<byte[], byte[]> serialize(CarCrashDateAccumulator carCrashDateAccumulator,
                                                    KafkaSinkContext kafkaSinkContext, Long aLong) {
        try {
            return new ProducerRecord<>(
                    "car-crash-date-aggregator",
                    null,
                    carCrashDateAccumulator.getCrashDateEpoch(),
                    Long.toString(carCrashDateAccumulator.getCrashDateEpoch()).getBytes(),
                    objectMapper.writeValueAsBytes(carCrashDateAccumulator));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(
                    "Could not serialize record: " + carCrashDateAccumulator, e);
        }
    }
}
