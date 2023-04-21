package isp.lab8.airways;

public class Waypoint {
    private String name;
    private double latitude;
    private double longitude;
    private double altitude;

    public Waypoint(String name, double latitude, double longitude, double altitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Waypoint() {
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }


    @Override
    public String toString() {
        return "Waypoint{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                '}';
    }
}
