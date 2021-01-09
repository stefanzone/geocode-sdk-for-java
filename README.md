# Java SDK for the GeoCode Routing API

![Java CI with Maven](https://github.com/stefanzone/geocode-sdk-for-java/workflows/Java%20CI%20with%20Maven/badge.svg)
[![GitHub issues](https://img.shields.io/github/issues/stefanzone/geocode-sdk-for-java)](https://github.com/stefanzone/geocode-sdk-for-java/issues)

The GeoCode Routing API SDK for Java enables Java developers to easily work with the [GeoCode Routing API](https://geocode.dev.stefan.zone) in Java.

## Installation

#### Maven

Since January 8th, 2021 the Java SDK for the GeoCode Routing API can be installed through the Maven Central Repository.

```xml
<dependency>
  <groupId>zone.stefan.dev</groupId>
  <artifactId>geocode</artifactId>
  <version>1.0.1</version>
</dependency>
```

#### From Git

The Java SDK for the GeoCode Routing API can be installed via [Git](https://git-scm.com/downloads). Run this command from your terminal.

```bash
git clone https://github.com/stefanzone/geocode-sdk-for-java.git
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
System.out.println("Street: " + geoCodeEndpoint.getAddress().getStreet());
System.out.println("House Number: " + geoCodeEndpoint.getAddress().getNumber());
System.out.println("City: " + geoCodeEndpoint.getAddress().getCity());
System.out.println("State: " + geoCodeEndpoint.getAddress().getState());
System.out.println("Post Code " + geoCodeEndpoint.getAddress().getPostCode());
System.out.println("Country: " + geoCodeEndpoint.getAddress().getCountry());
System.out.println("Country Code: " + geoCodeEndpoint.getAddress().getCountryCode());
System.out.println("Formatted: " + geoCodeEndpoint.getAddress().getFormatted());

// Informationen zur GeoPosition.
System.out.println("Latitude: " + geoCodeEndpoint.getPosition().getLat());
System.out.println("Longitude: " + geoCodeEndpoint.getPosition().getLon());
```

#### Parse the RoutingEndpoint for Routing MetaData.
```java
final RoutingEndpoint routingEndpoint = GeoCode.getRoute(
      "Lothstraße 34",
      "Lindwurmstraße",
      "transit" // Use of public transport.
);

// Information about the origin and destination address.
System.out.println("Origin Address: " + routingEndpoint.getSummary().getLocation().getOrigin());
System.out.println("Destination Address: " + routingEndpoint.getSummary().getLocation().getDestination());

// Textual summary of the route.
System.out.println("Summary: " + routingEndpoint.getSummary().getText());

// Travel time information.
System.out.println("Duration in Seconds: " + routingEndpoint.getSummary().getDuration().getSeconds());
System.out.println("Duration in Words: " + routingEndpoint.getSummary().getDuration().getText());

// Distance information.
System.out.println("Distance in Meters: " + routingEndpoint.getSummary().getDistance().getMeters());
System.out.println("Distance in Words: " + routingEndpoint.getSummary().getDistance().getText());

// All steps of the calculated route.
for (Step step : routingEndpoint.getRoute()) {
      System.out.println("Instruction: " + step.getInstruction());
}
```

## Contributing

Please see [CONTRIBUTING](https://github.com/stefanzone/geocode-sdk-for-java/blob/main/CONTRIBUTING.md) for details.

## License

&copy; 2021 [Stefan Kühnel](https://stefan.zone), All Rights reserved.
