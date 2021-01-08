package zone.stefan.dev.geocode;

import com.google.gson.Gson;
import org.apache.http.client.utils.URIBuilder;
import zone.stefan.dev.geocode.http.Fetch;
import zone.stefan.dev.geocode.model.endpoint.GeoCodeEndpoint;
import zone.stefan.dev.geocode.model.endpoint.RoutingEndpoint;

/**
 * GeoCode.java
 *
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public final class GeoCode {
  // Initialisierung des Gson Parsers.
  static final Gson gson = new Gson();

  // Privater Konstruktor.
  private GeoCode() {
  }

  /**
   * Rückgabe von Ortsangaben zu einer gegebenen Adresse.
   *
   * @param address Eine Adresse.
   * @return Gefundene Ortsangaben.
   */
  public static GeoCodeEndpoint getAddress(String address) {
    final String url = new URIBuilder()
        .setScheme("https")
        .setHost("geocode.dev.stefan.zone")
        .setPath("/api/geocode/json")
        .addParameter("address", address)
        .toString();

    final String json = Fetch.fetch(url);

    return gson.fromJson(json, GeoCodeEndpoint.class);
  }

  /**
   * Berechnet die Route zwischen zwei gegebenen Adressen.
   *
   * @param origin      Die Ursprungsadresse.
   * @param destination Die Zieladresse.
   * @param mode        Das gewählte Transportmittel.
   * @return Die berechnete Route.
   */
  public static RoutingEndpoint getRoute(String origin, String destination, String mode) {
    final String url = new URIBuilder()
        .setScheme("https")
        .setHost("geocode.dev.stefan.zone")
        .setPath("/api/directions/json")
        .addParameter("origin", origin)
        .addParameter("destination", destination)
        .addParameter("mode", mode)
        .toString();

    final String json = Fetch.fetch(url);

    return gson.fromJson(json, RoutingEndpoint.class);
  }
}
