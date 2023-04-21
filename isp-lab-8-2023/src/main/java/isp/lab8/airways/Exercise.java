package isp.lab8.airways;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean quit = false;

        while (!quit) {
            System.out.println("Choose an option:");
            System.out.println("1. Create route");
            System.out.println("2. Load route");
            System.out.println("3. Delete route");
            System.out.println("4. List routes");
            System.out.println("5. Quit");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter route name: ");
                    String routeName = scanner.nextLine();
                    Route route = new Route(routeName);

                    boolean addWaypoints = true;
                    while (addWaypoints) {
                        System.out.print("Enter waypoint name (or type 'done' to finish): ");
                        String waypointName = scanner.nextLine();
                        if ("done".equalsIgnoreCase(waypointName)) {
                            addWaypoints = false;
                        } else {
                            System.out.print("Enter latitude: ");
                            double latitude = Double.parseDouble(scanner.nextLine());
                            System.out.print("Enter longitude: ");
                            double longitude = Double.parseDouble(scanner.nextLine());
                            System.out.print("Enter altitude: ");
                            double altitude = Double.parseDouble(scanner.nextLine());

                            Waypoint waypoint = new Waypoint(waypointName, latitude, longitude, altitude);
                            route.addWaypoint(waypoint);
                        }
                    }

                    RouteFileManager.saveRoute(route);
                    System.out.println("Route created.");
                    break;
                case "2":
                    System.out.print("Enter route name to load: ");
                    routeName = scanner.nextLine();
                    route = RouteFileManager.loadRoute(routeName);
                    if (route != null) {
                        System.out.println("Route loaded.");
                        System.out.println("Waypoints: ");
                        for (Waypoint waypoint : route.getWaypoints()) {
                            System.out.println(waypoint);
                        }
                        System.out.println("Total distance: " + route.getTotalDistance() + " km");
                    } else {
                        System.out.println("Route not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter route name to delete: ");
                    routeName = scanner.nextLine();
                    RouteFileManager.deleteRoute(routeName);
                    System.out.println("Route deleted.");
                    break;
                case "4":
                    System.out.println("Available routes:");
                    for (String name : RouteFileManager.listRoutes()) {
                        System.out.println(name);
                    }
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
