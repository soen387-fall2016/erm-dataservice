# erm-dataservice

##### Provides data storage & retrieval services to the SOEN 387 Fall 2016 Group Project

[![Build Status](https://travis-ci.org/soen387-fall2016/erm-dataservice.svg?branch=master)](https://travis-ci.org/soen387-fall2016/erm-dataservice)

[![codecov](https://codecov.io/gh/soen387-fall2016/erm-dataservice/branch/master/graph/badge.svg)](https://codecov.io/gh/soen387-fall2016/erm-dataservice)

## How to run
This is a gradle project which you can run using the included Gradle wrapper. It uses Spring Boot with a Tomcat server.

Run on Linux / macOS: ```./gradlew bootRun```.

Run on Windows: ```gradlew.bat bootRun```.

This will run the server on your machine where you can access it at ```http://localhost:8080```.


## How to build

### Standalone Runnable JAR

Build on Linux / macOS: ```./gradlew build```.

Build on Windows: ```gradlew.bat build```.

You can then run the JAR with ```java -jar build/libs/erm-dataservice-0.0.1-SNAPSHOT.jar```.
** Replace ```0.0.1``` with the current version of the project, which is specified in ```gradle.properties```.

### Deployable WAR
TODO ...

## API Interface
Spring automatically generates a HATEOS REST API based on the provided entity classes.

Access the API root at ```http://<server-ip-and-port>/api```.

The responses returned are of type hal+json and contain links to navigate between resources.

### Inventory Items
Access the inventory list at ```http://<server-ip-and-port>/api/inventoryItems```.

Follow the links returned there to view indivitual inventory items.

To create a new item, simply POST a json body of the form:

```
{
    "name": "itemName",
    "type": "itemType",
    "content": "itemContent"
}
```

Note that the itemType must also be created, which can be done by POSTing to ```http://<server-ip-and-port>/api/inventoryItemTypes```.

```{
    "name": "itemTypeName"
}```

&copy; 2016
