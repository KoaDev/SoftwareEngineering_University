package isp.lab8.airways;

public class HaversineUtil {
    private static final double EARTH_RADIUS = 6371.0; // Earth's radius in km

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitudes and longitudes from decimal degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calculate differences between latitudes and longitudes
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Apply Haversine formula
        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the great-circle distance in kilometers
        return EARTH_RADIUS * c;
    }
}
