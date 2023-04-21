package isp.lab8.airways;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RouteFileManager {
    private static final String ROUTE_BASE_DIR = "routes";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveRoute(Route route) {
        File routeDir = new File(ROUTE_BASE_DIR, route.getName());
        if (!routeDir.exists()) {
            routeDir.mkdirs();
        }

        for (Waypoint waypoint : route.getWaypoints()) {
            File waypointFile = new File(routeDir, waypoint.getName() + ".json");
            try {
                objectMapper.writeValue(waypointFile, waypoint);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Route loadRoute(String routeName) {
        File routeDir = new File(ROUTE_BASE_DIR, routeName);
        if (!routeDir.exists()) {
            return null;
        }

        Route route = new Route(routeName);
        File[] waypointFiles = routeDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        if (waypointFiles != null) {
            for (File waypointFile : waypointFiles) {
                try {
                    Waypoint waypoint = objectMapper.readValue(waypointFile, Waypoint.class);
                    route.addWaypoint(waypoint);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return route;
    }

    public static void deleteRoute(String routeName) {
        File routeDir = new File(ROUTE_BASE_DIR, routeName);
        if (routeDir.exists()) {
            try {
                Files.walk(routeDir.toPath())
                        .sorted((p1, p2) -> p2.compareTo(p1)) // Reverse order to delete files before the directory
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> listRoutes() {
        File baseDir = new File(ROUTE_BASE_DIR);
        if (!baseDir.exists()) {
            return new ArrayList<>();
        }

        return Arrays.stream(baseDir.listFiles(File::isDirectory))
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
