package custom;

import common.CommonUtil;
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
            carCrashDateAccumulator.setCrashDateEpoch(CommonUtil.safeDateToLong(carCrash.getCrashDate()));
            carCrashDateAccumulator.setCrashDate(carCrash.getCrashDate());
            carCrashDateAccumulator.setNumberOfPersonsKilled(carCrashDateAccumulator.getNumberOfPersonsKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfPersonsKilled()));
            carCrashDateAccumulator.setNumberOfPersonsInjured(carCrashDateAccumulator.getNumberOfPersonsInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfPersonsKilled()));
            carCrashDateAccumulator.setNumberOfPedestriansKilled(carCrashDateAccumulator.getNumberOfPedestriansKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfPedestriansKilled()));
            carCrashDateAccumulator.setNumberOfPedestriansInjured(carCrashDateAccumulator.getNumberOfPedestriansInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfPedestriansInjured()));
            carCrashDateAccumulator.setNumberOfCyclistKilled(carCrashDateAccumulator.getNumberOfCyclistKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfCyclistKilled()));
            carCrashDateAccumulator.setNumberOfCyclistInjured(carCrashDateAccumulator.getNumberOfCyclistInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfCyclistInjured()));
            carCrashDateAccumulator.setNumberOfMotoristKilled(carCrashDateAccumulator.getNumberOfMotoristKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfMotoristKilled()));
            carCrashDateAccumulator.setNumberOfMotoristInjured(carCrashDateAccumulator.getNumberOfMotoristInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfMotoristInjured()));
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
