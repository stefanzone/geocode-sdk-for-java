package zone.stefan.dev.geocode.model.endpoint;

import zone.stefan.dev.geocode.model.Step;
import zone.stefan.dev.geocode.model.Summary;

import java.util.List;

/*
 * RoutingEndpoint.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class RoutingEndpoint {
    Summary summary;
    List<Step> route;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Step> getRoute() {
        return route;
    }

    public void setRoute(List<Step> route) {
        this.route = route;
    }
}
