package com.goodenoughapps.missioncomplete.domain;

/**
 * Represents an immutable location which may be attributed to a Task
 * @author Aaron Vontell
 */
public class TaskLocation {

    private double latitude;    // The latitude of this location
    private double longitude;   // The longitude of this location

    public static final String LATITUDE_FIELD = "lat";
    public static final String LONGITUDE_FIELD = "lng";

    /**
     * Creates a location from the given latitude and longitude
     * @param latitude
     * @param longitude
     */
    public TaskLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the latitude of this location
     * @return the latitude of this location
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude of this location
     * @return the longitude of this location
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Returns a JSON representation of this location as defined in the schema
     * @return a JSON representation of this location as defined in the schema
     */
    public String getJSON() {
        return String.format("{%s: %s, %s: %s}",
                LATITUDE_FIELD, this.latitude, LONGITUDE_FIELD, this.longitude);
    }

    /**
     * Returns a string useful for debugging purposes representing this location
     * @return a debugging string for this location
     */
    @Override
    public String toString() {
        return String.format("Location at [%s, %s]", this.latitude, this.longitude);
    }

}
