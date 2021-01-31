package zone.stefan.dev.geocode;

import org.junit.Test;

import zone.stefan.dev.geocode.model.Step;
import zone.stefan.dev.geocode.model.endpoint.GeoCodeEndpoint;
import zone.stefan.dev.geocode.model.endpoint.RoutingEndpoint;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * GeoCodeTest.java
 *
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2021-01-08
 */
public class GeoCodeTest {
    final GeoCodeEndpoint geoCodeEndpoint = GeoCode.getAddress("Lothstraße 34");

    final RoutingEndpoint routingEndpoint = GeoCode.getRoute(
            "Lothstraße 34",
            "Lindwurmstraße 90",
            "transit"
    );

    @Test
    public void testGetAddress_RequireReturn_NonDefaultValuesWhenAddressCanBeFound() {
        final String street = geoCodeEndpoint.getAddress().getStreet();
        final String number = geoCodeEndpoint.getAddress().getNumber();
        final String city = geoCodeEndpoint.getAddress().getCity();
        final String state = geoCodeEndpoint.getAddress().getState();
        final String postCode = geoCodeEndpoint.getAddress().getPostCode();
        final String country = geoCodeEndpoint.getAddress().getCountry();
        final String countryCode = geoCodeEndpoint.getAddress().getCountryCode();
        final String formatted = geoCodeEndpoint.getAddress().getFormatted();

        final Float latitude = geoCodeEndpoint.getPosition().getLat();
        final Float longitude = geoCodeEndpoint.getPosition().getLon();

        assertNotNull(street);
        assertNotNull(number);
        assertNotNull(city);
        assertNotNull(state);
        assertNotNull(postCode);
        assertNotNull(country);
        assertNotNull(countryCode);
        assertNotNull(formatted);

        assertNotEquals(latitude, 0.0);
        assertNotEquals(longitude, 0.0);
    }

    @Test
    public void testAddress_RequireReturn_NullWhenAddressCouldNotBeFound() {
        assertNull(GeoCode.getAddress("Nicht existente Adresse."));
    }

    @Test
    public void testAddress_RequireReturn_NullWhenAddressIsEmpty() {
        assertNull(GeoCode.getAddress(""));
    }

    @Test
    public void testGetRoute_RequireReturn_NonDefaultValuesWhenRouteCanBeFound() {
        final String origin = routingEndpoint.getSummary().getLocation().getOrigin();
        final String destination = routingEndpoint.getSummary().getLocation().getDestination();
        final String summary = routingEndpoint.getSummary().getText();

        final int durationInSeconds = routingEndpoint.getSummary().getDuration().getSeconds();
        final int distanceInMeters = routingEndpoint.getSummary().getDistance().getMeters();
        final String durationInWords = routingEndpoint.getSummary().getDuration().getText();
        final String distanceInWords = routingEndpoint.getSummary().getDistance().getText();

        final Step step = routingEndpoint.getRoute().get(0);

        final String instruction = step.getInstruction();
        final String duration = step.getDuration();
        final String distance = step.getDistance();

        assertNotNull(origin);
        assertNotNull(destination);
        assertNotNull(summary);

        assertNotEquals(durationInSeconds, 0);
        assertNotEquals(distanceInMeters, 0);
        assertNotNull(durationInWords);
        assertNotNull(distanceInWords);

        assertNotNull(instruction);
        assertNotNull(duration);
        assertNotNull(distance);
    }

    @Test
    public void testGetRoute_RequireReturn_NullWhenRouteCouldNotBeFound() {
        assertNull(GeoCode.getRoute(
                "Lothstraße 34",
                "Berliner Platz 1 Hof",
                "transit"
        ));
    }

    @Test
    public void testGetRoute_RequireReturn_NullWhenAtLeastOneAddressIsEmpty() {
        assertNull(GeoCode.getRoute(
                "",
                "Lindwurmstraße 90",
                "walk"
        ));

        assertNull(GeoCode.getRoute(
                "Lothstraße 34",
                "",
                "drive"
        ));
    }

    @Test
    public void testGetRoute_RequireReturn_NullWhenTransportModeIsInvalid() {
        assertNull(GeoCode.getRoute(
                "Lothstraße 34",
                "Lindwurmstraße 90",
                "Falsches Transportmittel"
        ));
    }
}
