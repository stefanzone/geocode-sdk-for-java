# GeoCode Routing API SDK for Java
The GeoCode Routing API SDK for Java enables Java developers to easily work with the GeoCode Routing API in Java.

## Installation

#### From Git

Halma can be installed via [Git](https://git-scm.com/downloads). Run this command from your terminal.

```bash
$ git clone https://github.com/stefanzone/geocode-sdk-for-java.git
```

#### Download as ZIP archive

Download the latest version from [here](https://github.com/stefanzone/geocode-sdk-for-java/archive/main.zip).

## Usage

> **Note:** The GeoCode Routing API SDK for Java requires [OpenJDK version 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or higher.

#### Parse the GeoCodeEndpoint for Address MetaData.
```java
final GeoCodeEndpoint geoCodeEndpoint = GeoCode.getAddress(
     "Lothstraße 34"
);

// Information about the address.
System.out.println(geoCodeEndpoint.getAddress().getStreet());
System.out.println(geoCodeEndpoint.getAddress().getNumber());
System.out.println(geoCodeEndpoint.getAddress().getCity());
System.out.println(geoCodeEndpoint.getAddress().getState());
System.out.println(geoCodeEndpoint.getAddress().getPostCode());
System.out.println(geoCodeEndpoint.getAddress().getCountry());
System.out.println(geoCodeEndpoint.getAddress().getCountryCode());
System.out.println(geoCodeEndpoint.getAddress().getFormatted());

// Informationen zur GeoPosition.
System.out.println(geoCodeEndpoint.getPosition().getLat());
System.out.println(geoCodeEndpoint.getPosition().getLon());
```

#### Parse the RoutingEndpoint for Routing MetaData.
```java
final RoutingEndpoint routingEndpoint = GeoCode.getRoute(
     "Lothstraße 34",
     "Lindwurmstraße",
     "transit" // Use of public transport.
);

// Information about the origin and destination address.
System.out.println(routingEndpoint.getSummary().getLocation().getOrigin());
System.out.println(routingEndpoint.getSummary().getLocation().getDestination());

// Textual summary of the route.
System.out.println(routingEndpoint.getSummary().getText()); 
        
// Travel time information.
System.out.println(routingEndpoint.getSummary().getDuration().getSeconds());
System.out.println(routingEndpoint.getSummary().getDuration().getText());
        
// Distance information.
System.out.println(routingEndpoint.getSummary().getDistance().getMeters());
System.out.println(routingEndpoint.getSummary().getDistance().getText());
        
// All steps of the calculated route.
for (Step step : routingEndpoint.getRoute()) {
     System.out.println(step.getInstruction());
}
```

## Contributing

Please see [CONTRIBUTING](https://github.com/stefanzone/geocode-sdk-for-java/blob/main/CONTRIBUTING.md) for details.

## License

&copy; 2020 Stefan Kühnel, All Rights reserved.
