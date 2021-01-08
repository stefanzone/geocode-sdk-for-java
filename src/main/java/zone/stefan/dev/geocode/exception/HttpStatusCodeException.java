package zone.stefan.dev.geocode.exception;

/**
 * HttpStatusCodeException.java
 *
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2021-01-07
 */

public class HttpStatusCodeException extends Exception {
  /**
   * Konstruktor zur Erzeugung einer Instanz von {@link HttpStatusCodeException}
   * mit einer Beschreibung des Fehlers.
   *
   * @param message Beschreibung des Fehlers.
   */
  public HttpStatusCodeException(final String message) {
    super(message);
  }
}
