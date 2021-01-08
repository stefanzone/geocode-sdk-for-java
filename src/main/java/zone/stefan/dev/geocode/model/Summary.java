package zone.stefan.dev.geocode.model;

/**
 * Summary.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class Summary {
    Location location;
    Duration duration;
    Distance distance;
    String text;

    public Location getLocation() {
        return location;
    }

    public Duration getDuration() {
        return duration;
    }

    public Distance getDistance() {
        return distance;
    }

    public String getText() {
        return text;
    }
}
