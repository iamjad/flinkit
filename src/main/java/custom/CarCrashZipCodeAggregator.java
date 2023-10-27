package custom;

import common.CommonUtil;
import model.CarCrash;
import model.CarCrashZipCodeAccumulator;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class CarCrashZipCodeAggregator implements AggregateFunction<CarCrash, CarCrashZipCodeAccumulator, Tuple2<CarCrashZipCodeAccumulator, Integer>> {

    @Override
    public CarCrashZipCodeAccumulator createAccumulator() {
        return new CarCrashZipCodeAccumulator();
    }

    @Override
    public CarCrashZipCodeAccumulator add(CarCrash carCrash, CarCrashZipCodeAccumulator carCrashZipCodeAccumulator) {
        carCrashZipCodeAccumulator.setZipCode(carCrash.getZipCode().trim());
        carCrashZipCodeAccumulator.setNumberOfPersonsKilled(carCrashZipCodeAccumulator.getNumberOfPersonsKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfPersonsKilled()));
        carCrashZipCodeAccumulator.setNumberOfPersonsInjured(carCrashZipCodeAccumulator.getNumberOfPersonsInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfPersonsKilled()));
        carCrashZipCodeAccumulator.setNumberOfPedestriansKilled(carCrashZipCodeAccumulator.getNumberOfPedestriansKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfPedestriansKilled()));
        carCrashZipCodeAccumulator.setNumberOfPedestriansInjured(carCrashZipCodeAccumulator.getNumberOfPedestriansInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfPedestriansInjured()));
        carCrashZipCodeAccumulator.setNumberOfCyclistKilled(carCrashZipCodeAccumulator.getNumberOfCyclistKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfCyclistKilled()));
        carCrashZipCodeAccumulator.setNumberOfCyclistInjured(carCrashZipCodeAccumulator.getNumberOfCyclistInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfCyclistInjured()));
        carCrashZipCodeAccumulator.setNumberOfMotoristKilled(carCrashZipCodeAccumulator.getNumberOfMotoristKilled() + CommonUtil.safeStringToInt(carCrash.getNumberOfMotoristKilled()));
        carCrashZipCodeAccumulator.setNumberOfMotoristInjured(carCrashZipCodeAccumulator.getNumberOfMotoristInjured() + CommonUtil.safeStringToInt(carCrash.getNumberOfMotoristInjured()));
        return carCrashZipCodeAccumulator;
    }

    @Override
    public Tuple2<CarCrashZipCodeAccumulator, Integer> getResult(CarCrashZipCodeAccumulator carCrashZipCodeAccumulator) {
        return new Tuple2<>(carCrashZipCodeAccumulator, carCrashZipCodeAccumulator.getTotalPeopleKilled());
    }

    @Override
    public CarCrashZipCodeAccumulator merge(CarCrashZipCodeAccumulator carCrashZipCodeAccumulator, CarCrashZipCodeAccumulator acc1) {
        carCrashZipCodeAccumulator.setNumberOfPersonsKilled(carCrashZipCodeAccumulator.getNumberOfPersonsKilled() + acc1.getNumberOfPersonsKilled());
        carCrashZipCodeAccumulator.setNumberOfPersonsInjured(carCrashZipCodeAccumulator.getNumberOfPersonsInjured() + acc1.getNumberOfPersonsInjured());
        carCrashZipCodeAccumulator.setNumberOfPedestriansKilled(carCrashZipCodeAccumulator.getNumberOfPedestriansKilled() + acc1.getNumberOfPedestriansKilled());
        carCrashZipCodeAccumulator.setNumberOfPedestriansInjured(carCrashZipCodeAccumulator.getNumberOfPedestriansInjured() + acc1.getNumberOfPedestriansInjured());
        carCrashZipCodeAccumulator.setNumberOfCyclistKilled(carCrashZipCodeAccumulator.getNumberOfCyclistKilled() + acc1.getNumberOfCyclistKilled());
        carCrashZipCodeAccumulator.setNumberOfCyclistInjured(carCrashZipCodeAccumulator.getNumberOfCyclistInjured() + acc1.getNumberOfCyclistInjured());
        carCrashZipCodeAccumulator.setNumberOfMotoristKilled(carCrashZipCodeAccumulator.getNumberOfMotoristKilled() + acc1.getNumberOfMotoristKilled());
        carCrashZipCodeAccumulator.setNumberOfMotoristInjured(carCrashZipCodeAccumulator.getNumberOfMotoristInjured() + acc1.getNumberOfMotoristInjured());
        return carCrashZipCodeAccumulator;
    }
}
