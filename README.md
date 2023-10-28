# flinkit
This repository contains custom Flink Aggregation implementation. It aggregates NY car crash data, which is publicly available here: https://catalog.data.gov/dataset?q=&amp;sort=views_recent+desc

The code uses localhost Kafka broker as a source to read JSON objects and perform two custom aggregations using Zipcode and Crash_Date and count all the people killed in the car crashes. 

Here is what this code does:
1. Create a Stream Execution Environment
2. Create KafkaSource, initialize it with Kafka Broker, Kafka consumer name, and kafka topic name, and read from the earliest offset
3. It uses a custom Kafka value deserializer extended from AbstractDeserializationSchema, deserializing incoming JSON objects to JAVA POJO Objects called CarCrash. I could also have used KafkaRecordDeserializationSchema which gives me both the JSON object and topic partition and offset information. For this exercise, I am just focusing on deserializing the JSON and focusing on Aggregations.
5. I'm now ready to perform aggregations on JAVA Object CarCrash. I wrote two different Aggregations, one called CarCrashDateAggregator and CarCrashZipCodeAggregator. Both implement AggregateFunction, taking incoming CarCrash objects, storing intermediate aggregation results in Accumulator objects, and Tuple2 of CarCrashZipCodeAccumulator and final sum. Let's break it down further
6. I want to count all the people killed by crash date in a window of 2 minutes and stream them to some sink source. KafkaStream.keyBy method splits (group by) incoming CarCrash objects by crash date in a small window of 2 mins, and applies CarCrashDateAggregator. CarCrashDateAggregator implements an add method that takes incoming objects and gets people killed in that car crash and adds them to the running accumulator.
7. Now you can either print it to send it to another Sink to store or process it further.
8. This is the last step to run the execute method.

The car crash data is converted from .csv to JSON format and posted to Kafka using a Python3 code not included in this example. 

```json
{"CRASH_DATE":"12/14/2021","CRASH_TIME":"8:17","BOROUGH":"BRONX","ZIP_CODE":"10475",
"LATITUDE":"40.86816","LONGITUDE":"-73.83148","LOCATION":"(40.86816, -73.83148)",
"ON_STREET_NAME":"","CROSS_STREET_NAME":"","OFF_STREET_NAME":" BAYCHESTER AVENUE","NUMBER_OF_PERSONS_INJURED":"2",
"NUMBER_OF_PERSONS_KILLED":"0","NUMBER_OF_PEDESTRIANS_INJURED":"0", "NUMBER_OF_PEDESTRIANS_KILLED":"0","NUMBER_OF_CYCLIST_INJURED":"0",
"NUMBER_OF_CYCLIST_KILLED":"0", "NUMBER_OF_MOTORIST_INJURED":"2","NUMBER_OF_MOTORIST_KILLED":"0",
"CONTRIBUTING_FACTOR_VEHICLE_1": "Unspecified","CONTRIBUTING_FACTOR_VEHICLE_2":"Unspecified","CONTRIBUTING_FACTOR_VEHICLE_3":"",
"CONTRIBUTING_FACTOR_VEHICLE_4":"","CONTRIBUTING_FACTOR_VEHICLE_5":"","COLLISION_ID":"4486660", "VEHICLE_TYPE_CODE_1":"Sedan",
"VEHICLE_TYPE_CODE_2":"Sedan","VEHICLE_TYPE_CODE_3":"","VEHICLE_TYPE_CODE_4":"","VEHICLE_TYPE_CODE_5":""}
```
# Environment

JDK 21
Flink Version: 1.18.0
Kafka Version: kafka_2.13-3.6.0
Kafka Topic: mvcc-topic

For this exercise, I downloaded and installed the latest Apache Kafka version following the quick start guide https://kafka.apache.org/documentation/#quickstart.

# Execution

I can run KafkaSourceExample.java locally or submit the job to the local Flink cluster.


# Resources

https://nightlies.apache.org/flink/flink-docs-release-1.17

https://www.youtube.com/watch?v=xm1X9etMXps

https://jbcodeforce.github.io/flink-studies/