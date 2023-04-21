package isp.lab8.airways;

import isp.lab8.airways.Waypoint;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String name;
    private List<Waypoint> waypoints;

    public Route(String name) {
        this.name = name;
        this.waypoints = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
    }

    public double getTotalDistance() {
        double totalDistance = 0;

        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint wp1 = waypoints.get(i);
            Waypoint wp2 = waypoints.get(i + 1);
            double distance = HaversineUtil.calculateDistance(
                    wp1.getLatitude(), wp1.getLongitude(),
                    wp2.getLatitude(), wp2.getLongitude());
            totalDistance += distance;
        }

        return totalDistance;
    }


    public void removeWaypoint(Waypoint waypoint) {
        waypoints.remove(waypoint);
    }

    public void removeWaypoint(int index) {
        if (index >= 0 && index < waypoints.size()) {
            waypoints.remove(index);
        }
    }
}
