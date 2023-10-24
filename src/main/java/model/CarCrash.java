package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarCrash implements Serializable {
    @JsonProperty("CRASH_DATE")
    private String crashDate;

    @JsonProperty("CRASH_TIME")
    private String crashTime;

    @JsonProperty("BOROUGH")
    private String borough;

    @JsonProperty("ZIP_CODE")
    private String zipCode;

    @JsonProperty("LATITUDE")
    private String latitude;

    @JsonProperty("LONGITUDE")
    private String longitude;

    @JsonProperty("LOCATION")
    private String location;

    @JsonProperty("ON_STREET_NAME")
    private String onStreetName;

    @JsonProperty("CROSS_STREET_NAME")
    private String crossStreetName;

    @JsonProperty("OFF_STREET_NAME")
    private String offStreetName;

    @JsonProperty("NUMBER_OF_PERSONS_INJURED")
    private String numberOfPersonsInjured;

    @JsonProperty("NUMBER_OF_PERSONS_KILLED")
    private String numberOfPersonsKilled;

    @JsonProperty("NUMBER_OF_PEDESTRIANS_INJURED")
    private String numberOfPedestriansInjured;

    @JsonProperty("NUMBER_OF_PEDESTRIANS_KILLED")
    private String numberOfPedestriansKilled;

    @JsonProperty("NUMBER_OF_CYCLIST_INJURED")
    private String numberOfCyclistInjured;

    @JsonProperty("NUMBER_OF_CYCLIST_KILLED")
    private String numberOfCyclistKilled;

    @JsonProperty("NUMBER_OF_MOTORIST_INJURED")
    private String numberOfMotoristInjured;

    @JsonProperty("NUMBER_OF_MOTORIST_KILLED")
    private String numberOfMotoristKilled;

    @JsonProperty("CONTRIBUTING_FACTOR_VEHICLE_1")
    private String contributingFactor1;

    @JsonProperty("CONTRIBUTING_FACTOR_VEHICLE_2")
    private String contributingFactor2;

    @JsonProperty("CONTRIBUTING_FACTOR_VEHICLE_3")
    private String contributingFactor3;

    @JsonProperty("CONTRIBUTING_FACTOR_VEHICLE_4")
    private String contributingFactor4;

    @JsonProperty("CONTRIBUTING_FACTOR_VEHICLE_5")
    private String contributingFactor5;
    @JsonProperty("COLLISION_ID")
    private String collisionId;

    public String getContributingFactor3() {
        return contributingFactor3;
    }

    public void setContributingFactor3(String contributingFactor3) {
        this.contributingFactor3 = contributingFactor3;
    }

    public String getContributingFactor4() {
        return contributingFactor4;
    }

    public void setContributingFactor4(String contributingFactor4) {
        this.contributingFactor4 = contributingFactor4;
    }

    public String getContributingFactor5() {
        return contributingFactor5;
    }

    public void setContributingFactor5(String contributingFactor5) {
        this.contributingFactor5 = contributingFactor5;
    }

    @JsonProperty("VEHICLE_TYPE_CODE_1")
    private String vehicleTypeCode1;

    @JsonProperty("VEHICLE_TYPE_CODE_2")
    private String vehicleTypeCode2;

    @JsonProperty("VEHICLE_TYPE_CODE_3")
    private String vehicleTypeCode3;

    @JsonProperty("VEHICLE_TYPE_CODE_4")
    private String vehicleTypeCode4;

    @JsonProperty("VEHICLE_TYPE_CODE_5")
    private String vehicleTypeCode5;

    public CarCrash() {
    }


    public String getCrashDate() {
        return crashDate;
    }

    public void setCrashDate(String crashDate) {
        this.crashDate = crashDate;
    }

    public String getCrashTime() {
        return crashTime;
    }

    public void setCrashTime(String crashTime) {
        this.crashTime = crashTime;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOnStreetName() {
        return onStreetName;
    }

    public void setOnStreetName(String onStreetName) {
        this.onStreetName = onStreetName;
    }

    public String getCrossStreetName() {
        return crossStreetName;
    }

    public void setCrossStreetName(String crossStreetName) {
        this.crossStreetName = crossStreetName;
    }

    public String getOffStreetName() {
        return offStreetName;
    }

    public void setOffStreetName(String offStreetName) {
        this.offStreetName = offStreetName;
    }

    public String getNumberOfPersonsInjured() {
        return numberOfPersonsInjured;
    }

    public void setNumberOfPersonsInjured(String numberOfPersonsInjured) {
        this.numberOfPersonsInjured = numberOfPersonsInjured;
    }

    public String getNumberOfPersonsKilled() {
        return numberOfPersonsKilled;
    }

    public void setNumberOfPersonsKilled(String numberOfPersonsKilled) {
        this.numberOfPersonsKilled = numberOfPersonsKilled;
    }

    public String getNumberOfPedestriansInjured() {
        return numberOfPedestriansInjured;
    }

    public void setNumberOfPedestriansInjured(String numberOfPedestriansInjured) {
        this.numberOfPedestriansInjured = numberOfPedestriansInjured;
    }

    public String getNumberOfPedestriansKilled() {
        return numberOfPedestriansKilled;
    }

    public void setNumberOfPedestriansKilled(String numberOfPedestriansKilled) {
        this.numberOfPedestriansKilled = numberOfPedestriansKilled;
    }

    public String getNumberOfCyclistInjured() {
        return numberOfCyclistInjured;
    }

    public void setNumberOfCyclistInjured(String numberOfCyclistInjured) {
        this.numberOfCyclistInjured = numberOfCyclistInjured;
    }

    public String getNumberOfCyclistKilled() {
        return numberOfCyclistKilled;
    }

    public void setNumberOfCyclistKilled(String numberOfCyclistKilled) {
        this.numberOfCyclistKilled = numberOfCyclistKilled;
    }

    public String getNumberOfMotoristInjured() {
        return numberOfMotoristInjured;
    }

    public void setNumberOfMotoristInjured(String numberOfMotoristInjured) {
        this.numberOfMotoristInjured = numberOfMotoristInjured;
    }

    public String getNumberOfMotoristKilled() {
        return numberOfMotoristKilled;
    }

    public void setNumberOfMotoristKilled(String numberOfMotoristKilled) {
        this.numberOfMotoristKilled = numberOfMotoristKilled;
    }

    public String getContributingFactor1() {
        return contributingFactor1;
    }

    public void setContributingFactor1(String contributingFactor1) {
        this.contributingFactor1 = contributingFactor1;
    }

    public String getContributingFactor2() {
        return contributingFactor2;
    }

    public void setContributingFactor2(String contributingFactor2) {
        this.contributingFactor2 = contributingFactor2;
    }

    public String getCollisionId() {
        return collisionId;
    }

    public void setCollisionId(String collisionId) {
        this.collisionId = collisionId;
    }

    public String getVehicleTypeCode1() {
        return vehicleTypeCode1;
    }

    public void setVehicleTypeCode1(String vehicleTypeCode1) {
        this.vehicleTypeCode1 = vehicleTypeCode1;
    }

    public String getVehicleTypeCode2() {
        return vehicleTypeCode2;
    }

    public void setVehicleTypeCode2(String vehicleTypeCode2) {
        this.vehicleTypeCode2 = vehicleTypeCode2;
    }

    public String getVehicleTypeCode3() {
        return vehicleTypeCode3;
    }

    public void setVehicleTypeCode3(String vehicleTypeCode3) {
        this.vehicleTypeCode3 = vehicleTypeCode3;
    }

    public String getVehicleTypeCode4() {
        return vehicleTypeCode4;
    }

    public void setVehicleTypeCode4(String vehicleTypeCode4) {
        this.vehicleTypeCode4 = vehicleTypeCode4;
    }

    public String getVehicleTypeCode5() {
        return vehicleTypeCode5;
    }

    public void setVehicleTypeCode5(String vehicleTypeCode5) {
        this.vehicleTypeCode5 = vehicleTypeCode5;
    }

    public CarCrash(String crashDate, String crashTime, String borough, String zipCode, String latitude, String longitude, String location,
                    String onStreetName, String crossStreetName, String offStreetName, String numberOfPersonsInjured,
                    String numberOfPersonsKilled, String numberOfPedestriansInjured, String numberOfPedestriansKilled,
                    String numberOfCyclistInjured, String numberOfCyclistKilled,
                    String numberOfMotoristInjured, String numberOfMotoristKilled,
                    String contributingFactor1, String contributingFactor2, String contributingFactor3, String contributingFactor4,
                    String contributingFactor5, String collisionId, String vehicleTypeCode1, String vehicleTypeCode2,
                    String vehicleTypeCode3, String vehicleTypeCode4, String vehicleTypeCode5) {
        this.crashDate = crashDate;
        this.crashTime = crashTime;
        this.borough = borough;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.onStreetName = onStreetName;
        this.crossStreetName = crossStreetName;
        this.offStreetName = offStreetName;
        this.numberOfPersonsInjured = numberOfPersonsInjured;
        this.numberOfPersonsKilled = numberOfPersonsKilled;
        this.numberOfPedestriansInjured = numberOfPedestriansInjured;
        this.numberOfPedestriansKilled = numberOfPedestriansKilled;
        this.numberOfCyclistInjured = numberOfCyclistInjured;
        this.numberOfCyclistKilled = numberOfCyclistKilled;
        this.numberOfMotoristInjured = numberOfMotoristInjured;
        this.numberOfMotoristKilled = numberOfMotoristKilled;
        this.contributingFactor1 = contributingFactor1;
        this.contributingFactor2 = contributingFactor2;
        this.contributingFactor3 = contributingFactor3;
        this.contributingFactor4 = contributingFactor4;
        this.contributingFactor5 = contributingFactor5;
        this.collisionId = collisionId;
        this.vehicleTypeCode1 = vehicleTypeCode1;
        this.vehicleTypeCode2 = vehicleTypeCode2;
        this.vehicleTypeCode3 = vehicleTypeCode3;
        this.vehicleTypeCode4 = vehicleTypeCode4;
        this.vehicleTypeCode5 = vehicleTypeCode5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarCrash carCrash = (CarCrash) o;

        if (!crashDate.equals(carCrash.crashDate)) return false;
        if (!crashTime.equals(carCrash.crashTime)) return false;
        if (!Objects.equals(borough, carCrash.borough)) return false;
        if (!Objects.equals(zipCode, carCrash.zipCode)) return false;
        if (!Objects.equals(latitude, carCrash.latitude)) return false;
        if (!Objects.equals(longitude, carCrash.longitude)) return false;
        if (!Objects.equals(location, carCrash.location)) return false;
        if (!Objects.equals(onStreetName, carCrash.onStreetName))
            return false;
        if (!Objects.equals(crossStreetName, carCrash.crossStreetName))
            return false;
        if (!Objects.equals(offStreetName, carCrash.offStreetName))
            return false;
        if (!Objects.equals(numberOfPersonsInjured, carCrash.numberOfPersonsInjured))
            return false;
        if (!Objects.equals(numberOfPersonsKilled, carCrash.numberOfPersonsKilled))
            return false;
        if (!Objects.equals(numberOfPedestriansInjured, carCrash.numberOfPedestriansInjured))
            return false;
        if (!Objects.equals(numberOfPedestriansKilled, carCrash.numberOfPedestriansKilled))
            return false;
        if (!Objects.equals(numberOfCyclistInjured, carCrash.numberOfCyclistInjured))
            return false;
        if (!Objects.equals(numberOfCyclistKilled, carCrash.numberOfCyclistKilled))
            return false;
        if (!Objects.equals(numberOfMotoristInjured, carCrash.numberOfMotoristInjured))
            return false;
        if (!Objects.equals(numberOfMotoristKilled, carCrash.numberOfMotoristKilled))
            return false;
        if (!Objects.equals(contributingFactor1, carCrash.contributingFactor1))
            return false;
        if (!Objects.equals(contributingFactor2, carCrash.contributingFactor2))
            return false;
        if (!Objects.equals(collisionId, carCrash.collisionId))
            return false;
        if (!Objects.equals(vehicleTypeCode1, carCrash.vehicleTypeCode1))
            return false;
        return Objects.equals(vehicleTypeCode2, carCrash.vehicleTypeCode2);
    }

    @Override
    public int hashCode() {
        int result = crashDate.hashCode();
        result = 31 * result + crashTime.hashCode();
        result = 31 * result + (borough != null ? borough.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (onStreetName != null ? onStreetName.hashCode() : 0);
        result = 31 * result + (crossStreetName != null ? crossStreetName.hashCode() : 0);
        result = 31 * result + (offStreetName != null ? offStreetName.hashCode() : 0);
        result = 31 * result + (numberOfPersonsInjured != null ? numberOfPersonsInjured.hashCode() : 0);
        result = 31 * result + (numberOfPersonsKilled != null ? numberOfPersonsKilled.hashCode() : 0);
        result = 31 * result + (numberOfPedestriansInjured != null ? numberOfPedestriansInjured.hashCode() : 0);
        result = 31 * result + (numberOfPedestriansKilled != null ? numberOfPedestriansKilled.hashCode() : 0);
        result = 31 * result + (numberOfCyclistInjured != null ? numberOfCyclistInjured.hashCode() : 0);
        result = 31 * result + (numberOfCyclistKilled != null ? numberOfCyclistKilled.hashCode() : 0);
        result = 31 * result + (numberOfMotoristInjured != null ? numberOfMotoristInjured.hashCode() : 0);
        result = 31 * result + (numberOfMotoristKilled != null ? numberOfMotoristKilled.hashCode() : 0);
        result = 31 * result + (contributingFactor1 != null ? contributingFactor1.hashCode() : 0);
        result = 31 * result + (contributingFactor2 != null ? contributingFactor2.hashCode() : 0);
        result = 31 * result + (collisionId != null ? collisionId.hashCode() : 0);
        result = 31 * result + (vehicleTypeCode1 != null ? vehicleTypeCode1.hashCode() : 0);
        result = 31 * result + (vehicleTypeCode2 != null ? vehicleTypeCode2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarCrash{" +
                "crashDate='" + crashDate + '\'' +
                ", crashTime='" + crashTime + '\'' +
                ", borough='" + borough + '\'' +
                // Add more fields...
                '}';
    }
}