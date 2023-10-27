package util;

import common.Common;
import model.CarCrash;
import model.CarCrashDateAccumulator;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class CarCrashDateAggregator implements AggregateFunction<CarCrash, CarCrashDateAccumulator, Tuple2<CarCrashDateAccumulator, Integer>> {

        @Override
        public CarCrashDateAccumulator createAccumulator() {
            return new CarCrashDateAccumulator();
        }

        @Override
        public CarCrashDateAccumulator add(CarCrash carCrash, CarCrashDateAccumulator carCrashDateAccumulator) {
            carCrashDateAccumulator.setCrashDateEpoch(Common.safeDateToLong(carCrash.getCrashDate()));
            carCrashDateAccumulator.setCrashDate(carCrash.getCrashDate());
            carCrashDateAccumulator.setNumberOfPersonsKilled(carCrashDateAccumulator.getNumberOfPersonsKilled() + Common.safeStringToInt(carCrash.getNumberOfPersonsKilled()));
            carCrashDateAccumulator.setNumberOfPersonsInjured(carCrashDateAccumulator.getNumberOfPersonsInjured() + Common.safeStringToInt(carCrash.getNumberOfPersonsKilled()));
            carCrashDateAccumulator.setNumberOfPedestriansKilled(carCrashDateAccumulator.getNumberOfPedestriansKilled() + Common.safeStringToInt(carCrash.getNumberOfPedestriansKilled()));
            carCrashDateAccumulator.setNumberOfPedestriansInjured(carCrashDateAccumulator.getNumberOfPedestriansInjured() + Common.safeStringToInt(carCrash.getNumberOfPedestriansInjured()));
            carCrashDateAccumulator.setNumberOfCyclistKilled(carCrashDateAccumulator.getNumberOfCyclistKilled() + Common.safeStringToInt(carCrash.getNumberOfCyclistKilled()));
            carCrashDateAccumulator.setNumberOfCyclistInjured(carCrashDateAccumulator.getNumberOfCyclistInjured() + Common.safeStringToInt(carCrash.getNumberOfCyclistInjured()));
            carCrashDateAccumulator.setNumberOfMotoristKilled(carCrashDateAccumulator.getNumberOfMotoristKilled() + Common.safeStringToInt(carCrash.getNumberOfMotoristKilled()));
            carCrashDateAccumulator.setNumberOfMotoristInjured(carCrashDateAccumulator.getNumberOfMotoristInjured() + Common.safeStringToInt(carCrash.getNumberOfMotoristInjured()));
            return carCrashDateAccumulator;
        }

        @Override
        public Tuple2<CarCrashDateAccumulator, Integer> getResult(CarCrashDateAccumulator carCrashDateAccumulator) {
            return new Tuple2<>(carCrashDateAccumulator, carCrashDateAccumulator.getTotalPeopleKilled());
        }

        @Override
        public CarCrashDateAccumulator merge(CarCrashDateAccumulator carCrashDateAccumulator, CarCrashDateAccumulator acc1) {
            carCrashDateAccumulator.setNumberOfPersonsKilled(carCrashDateAccumulator.getNumberOfPersonsKilled() + acc1.getNumberOfPersonsKilled());
            carCrashDateAccumulator.setNumberOfPersonsInjured(carCrashDateAccumulator.getNumberOfPersonsInjured() + acc1.getNumberOfPersonsInjured());
            carCrashDateAccumulator.setNumberOfPedestriansKilled(carCrashDateAccumulator.getNumberOfPedestriansKilled() + acc1.getNumberOfPedestriansKilled());
            carCrashDateAccumulator.setNumberOfPedestriansInjured(carCrashDateAccumulator.getNumberOfPedestriansInjured() + acc1.getNumberOfPedestriansInjured());
            carCrashDateAccumulator.setNumberOfCyclistKilled(carCrashDateAccumulator.getNumberOfCyclistKilled() + acc1.getNumberOfCyclistKilled());
            carCrashDateAccumulator.setNumberOfCyclistInjured(carCrashDateAccumulator.getNumberOfCyclistInjured() + acc1.getNumberOfCyclistInjured());
            carCrashDateAccumulator.setNumberOfMotoristKilled(carCrashDateAccumulator.getNumberOfMotoristKilled() + acc1.getNumberOfMotoristKilled());
            carCrashDateAccumulator.setNumberOfMotoristInjured(carCrashDateAccumulator.getNumberOfMotoristInjured() + acc1.getNumberOfMotoristInjured());
            return carCrashDateAccumulator;
        }
}
