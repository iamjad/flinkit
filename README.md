# flinkit
This repository contains custom Flink Aggregation implementation. It aggregates NY car crash data which is publicly available here: https://catalog.data.gov/dataset?q=&amp;sort=views_recent+desc

The car crash data is converted from .csv to JSON format. Here is a sample JSON Object

```json
{"CRASH_DATE":"12/14/2021","CRASH_TIME":"8:17","BOROUGH":"BRONX","ZIP_CODE":"10475","LATITUDE":"40.86816","LONGITUDE":"-73.83148","LOCATION":"(40.86816, -73.83148)","ON_STREET_NAME":"","CROSS_STREET_NAME":"","OFF_STREET_NAME":" BAYCHESTER AVENUE","NUMBER_OF_PERSONS_INJURED":"2","NUMBER_OF_PERSONS_KILLED":"0","NUMBER_OF_PEDESTRIANS_INJURED":"0","NUMBER_OF_PEDESTRIANS_KILLED":"0","NUMBER_OF_CYCLIST_INJURED":"0","NUMBER_OF_CYCLIST_KILLED":"0","NUMBER_OF_MOTORIST_INJURED":"2","NUMBER_OF_MOTORIST_KILLED":"0","CONTRIBUTING_FACTOR_VEHICLE_1":"Unspecified","CONTRIBUTING_FACTOR_VEHICLE_2":"Unspecified","CONTRIBUTING_FACTOR_VEHICLE_3":"","CONTRIBUTING_FACTOR_VEHICLE_4":"","CONTRIBUTING_FACTOR_VEHICLE_5":"","COLLISION_ID":"4486660","VEHICLE_TYPE_CODE_1":"Sedan","VEHICLE_TYPE_CODE_2":"Sedan","VEHICLE_TYPE_CODE_3":"","VEHICLE_TYPE_CODE_4":"","VEHICLE_TYPE_CODE_5":""}
```
# Environment

JDK 21
Flink Version: 1.18.0
Kafka Version: kafka_2.13-3.6.0
Kafka Topic: mvcc-topic

For this exercise, I download and installed latest Apache Kafka version following the quick start guide https://kafka.apache.org/documentation/#quickstart.

# Execution

I can run KafkaSourceExample.java locally or submit the job to the local Flink cluster.
