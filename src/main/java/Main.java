import zone.stefan.dev.geocode.GeoCode;
import zone.stefan.dev.geocode.model.Step;
import zone.stefan.dev.geocode.model.endpoint.GeoCodeEndpoint;
import zone.stefan.dev.geocode.model.endpoint.RoutingEndpoint;

/*
 * Main.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class Main {
    public static void main(String... args) {
        // Information about the address.
        System.out.println("Information about the address.");
        System.out.println("----");
        getAddress();

        System.out.println();

        // Information about the route.
        System.out.println("Information about the route.");
        System.out.println("----");
        getRoute();
    }

    public static void getAddress() {
        final GeoCodeEndpoint geoCodeEndpoint = GeoCode.getAddress(
                "Lothstraße 34"
        );

        // Information about the address.
        System.out.println("Street: " + geoCodeEndpoint.getAddress().getStreet());
        System.out.println("House Number: " + geoCodeEndpoint.getAddress().getNumber());
        System.out.println("City: " + geoCodeEndpoint.getAddress().getCity());
        System.out.println("State: " + geoCodeEndpoint.getAddress().getState());
        System.out.println("Post Code " + geoCodeEndpoint.getAddress().getPostCode());
        System.out.println("Country: " + geoCodeEndpoint.getAddress().getCountry());
        System.out.println("Country Code: " + geoCodeEndpoint.getAddress().getCountryCode());
        System.out.println("Formatted: " + geoCodeEndpoint.getAddress().getFormatted());

        // Informationen zur GeoPosition.
        System.out.println("Latitude: " + geoCodeEndpoint.getPosition().getLat());
        System.out.println("Longitude: " + geoCodeEndpoint.getPosition().getLon());
    }

    public static void getRoute() {
        final RoutingEndpoint routingEndpoint = GeoCode.getRoute(
                "Lothstraße 34",
                "Lindwurmstraße",
                "transit" // Use of public transport.
        );

        // Information about the origin and destination address.
        System.out.println("Origin Address: " + routingEndpoint.getSummary().getLocation().getOrigin());
        System.out.println("Destination Address: " + routingEndpoint.getSummary().getLocation().getDestination());

        // Textual summary of the route.
        System.out.println("Summary: " + routingEndpoint.getSummary().getText());

        // Travel time information.
        System.out.println("Duration in Seconds: " + routingEndpoint.getSummary().getDuration().getSeconds());
        System.out.println("Duration in Words: " + routingEndpoint.getSummary().getDuration().getText());

        // Distance information.
        System.out.println("Distance in Meters: " + routingEndpoint.getSummary().getDistance().getMeters());
        System.out.println("Distance in Words: " + routingEndpoint.getSummary().getDistance().getText());

        // All steps of the calculated route.
        for (Step step : routingEndpoint.getRoute()) {
            System.out.println("Instruction: " + step.getInstruction());
        }
    }
}
