package isp.lab8.airways;

import java.lang.Math;

/**
 * Example how to calculate distance between 2 geographical points. Reuse part of this code in your application.
 */
public class WaypointDistanceCalculator {

    public static void main(String[] args) {
        // Example coordinates for two waypoints
        //Cluj-Napoca
        double lat1 = 46.7712;
        double lon1 = 23.6236;
        //Bucharest
        double lat2 = 44.4268;
        double lon2 = 26.1025;

        // Calculate the distance between the two waypoints
        double distance = calculateDistance(lat1, lon1, lat2, lon2);

        // Print the result
        System.out.println("The distance between the two waypoints is: " + distance + " kilometers");
    }

    // Method to calculate the distance between two waypoints using the haversine formula
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        int earthRadius = 6371; // Radius of the Earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;
        return distance;
    }
}

