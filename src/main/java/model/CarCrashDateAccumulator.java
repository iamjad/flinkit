package model;

public class CarCrashDateAccumulator {
    private long crashDateEpoch;
    private String crashDate;
    private int numberOfPersonsKilled;
    private int numberOfPersonsInjured;
    private int numberOfPedestriansKilled;
    private int numberOfPedestriansInjured;
    private int numberOfCyclistKilled;
    private int numberOfCyclistInjured;
    private int numberOfMotoristKilled;
    private int numberOfMotoristInjured;

    public CarCrashDateAccumulator(long crashDateEpoch, int numberOfPersonsKilled) {
        this.crashDateEpoch = crashDateEpoch;
        this.numberOfPersonsKilled = numberOfPersonsKilled;
    }

    public String getCrashDate() {
        return crashDate;
    }

    public void setCrashDate(String crashDate) {
        this.crashDate = crashDate;
    }

    public long getCrashDateEpoch() {
        return crashDateEpoch;
    }

    public void setCrashDateEpoch(long crashDateEpoch) {
        this.crashDateEpoch = crashDateEpoch;
    }

    public CarCrashDateAccumulator() {
    }

    public int getNumberOfPersonsKilled() {
        return numberOfPersonsKilled;
    }

    public void setNumberOfPersonsKilled(int numberOfPersonsKilled) {
        this.numberOfPersonsKilled = numberOfPersonsKilled;
    }

    public int getNumberOfPersonsInjured() {
        return numberOfPersonsInjured;
    }

    public void setNumberOfPersonsInjured(int numberOfPersonsInjured) {
        this.numberOfPersonsInjured = numberOfPersonsInjured;
    }

    public int getNumberOfPedestriansKilled() {
        return numberOfPedestriansKilled;
    }

    public void setNumberOfPedestriansKilled(int numberOfPedestriansKilled) {
        this.numberOfPedestriansKilled = numberOfPedestriansKilled;
    }

    public int getNumberOfPedestriansInjured() {
        return numberOfPedestriansInjured;
    }

    public void setNumberOfPedestriansInjured(int numberOfPedestriansInjured) {
        this.numberOfPedestriansInjured = numberOfPedestriansInjured;
    }

    public int getNumberOfCyclistKilled() {
        return numberOfCyclistKilled;
    }

    public void setNumberOfCyclistKilled(int numberOfCyclistKilled) {
        this.numberOfCyclistKilled = numberOfCyclistKilled;
    }

    public int getNumberOfCyclistInjured() {
        return numberOfCyclistInjured;
    }

    public void setNumberOfCyclistInjured(int numberOfCyclistInjured) {
        this.numberOfCyclistInjured = numberOfCyclistInjured;
    }

    public int getNumberOfMotoristKilled() {
        return numberOfMotoristKilled;
    }

    public void setNumberOfMotoristKilled(int numberOfMotoristKilled) {
        this.numberOfMotoristKilled = numberOfMotoristKilled;
    }

    public int getNumberOfMotoristInjured() {
        return numberOfMotoristInjured;
    }

    public void setNumberOfMotoristInjured(int numberOfMotoristInjured) {
        this.numberOfMotoristInjured = numberOfMotoristInjured;
    }

    public int getTotalPeopleKilled() {
        return numberOfPersonsKilled + numberOfPedestriansKilled + numberOfCyclistKilled + numberOfMotoristKilled;
    }

    @Override
    public String toString() {
        return "CarCrashZipCodeAccumulator{" +
                "date='" + crashDateEpoch + '\'' +
                "dateString='" + crashDate + '\'' +
                ", numberOfPersonsKilled=" + numberOfPersonsKilled +
                ", numberOfPersonsInjured=" + numberOfPersonsInjured +
                ", numberOfPedestriansKilled=" + numberOfPedestriansKilled +
                ", numberOfPedestriansInjured=" + numberOfPedestriansInjured +
                ", numberOfCyclistKilled=" + numberOfCyclistKilled +
                ", numberOfCyclistInjured=" + numberOfCyclistInjured +
                ", numberOfMotoristKilled=" + numberOfMotoristKilled +
                ", numberOfMotoristInjured=" + numberOfMotoristInjured +
                '}';
    }
}
