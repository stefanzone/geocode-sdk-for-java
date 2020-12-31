package zone.stefan.dev.geocode.http;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/*
 * Fetch.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class Fetch {
    /**
     * Ruft den Inhalt einer Remote Ressource ab.
     * @param resource URL zur Remote Ressource.
     * @return Den abgerufen Inhalt der Remote Ressource.
     */
    public static String fetch(String resource) {
        // Der Inhalt der abgefragten Ressource.
        StringBuilder inline = new StringBuilder();

        try {
            URL url = new URL(resource);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Abfrage des HTTP Status Codes.
            int responseCode = conn.getResponseCode();

            // TODO: Hinzufügen einer bessereren Fehlerbehandlung.
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }

            Scanner scanner = new Scanner(url.openStream());

            // Nutzung eines Scanners zum Schreiben der erhaltenen Daten.
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }

            // Schließen des Scanners.
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inline.toString();
    }
}
