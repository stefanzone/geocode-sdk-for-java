package zone.stefan.dev.geocode.http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import zone.stefan.dev.geocode.exception.HttpStatusCodeException;

/**
 * Fetch.java
 *
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class Fetch {
  /**
   * Ruft den Inhalt einer entfernten Ressource ab.
   *
   * @param resource URL zur entfernten Ressource.
   * @return Der abgerufene Inhalt der entfernten Ressource.
   */
  public static String fetch(String resource) {
    try {
      URL url = new URL(resource);

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      // Abfrage des HTTP Status Codes.
      int responseCode = conn.getResponseCode();

      // Bei der Bearbeitung der Anfrage ist ein Fehler aufgetreten.
      if (responseCode != 200) {
        throw new HttpStatusCodeException("HttpResponseCode: " + responseCode);
      }

      // Ausgabe der erhaltenen Daten.
      return getContent(url.openStream());
    } catch (Exception exception) {
      // Es ist ein Fehler aufgetreten.
      return null;
    }
  }

  /**
   * Schreibt den Inhalt der entfernten Ressource in eine Zeichenkette.
   *
   * @param inputStream Ein InputStream, der das Lesen von der entfernten Ressource ermöglicht.
   * @return Der Inhalt der entfernten Ressource als Text.
   */
  private static String getContent(InputStream inputStream) {
    // Enthält den Inhalt der entfernten Ressource.
    final StringBuilder content = new StringBuilder();

    try (Scanner scanner = new Scanner(inputStream)) {

      // Liest den Inhalt des InputStreams Zeile für Zeile in den StringBuilder ein.
      while (scanner.hasNext()) {
        content.append(scanner.nextLine());
      }

    }

    // Rückgabe der erhaltenen Daten.
    return content.toString();
  }
}
