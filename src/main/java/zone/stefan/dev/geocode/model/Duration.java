package zone.stefan.dev.geocode.model;

/*
 * Duration.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class Duration {
    int seconds;
    String text;

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
