package zone.stefan.dev.geocode.model.endpoint;

import zone.stefan.dev.geocode.model.Address;
import zone.stefan.dev.geocode.model.Position;

/*
 * GeoCodeEndpoint.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class GeoCodeEndpoint {
    Address address;
    Position position;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
