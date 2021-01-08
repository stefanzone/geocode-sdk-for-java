package zone.stefan.dev.geocode.model;

/**
 * Address.java
 * @author Stefan Kühnel, stefan.kuehnel@hm.edu
 * @version 2020-12-31
 */

public class Address {
    String street;
    String number;
    String city;
    String state;
    String postCode;
    String country;
    String countryCode;
    String formatted;

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getFormatted() {
        return formatted;
    }
}
