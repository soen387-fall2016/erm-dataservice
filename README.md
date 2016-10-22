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

### Docker
Docker builds are pushed to the Docker Hub with every commit passing tests.

Run with Docker using: ```docker run --name erm-dataservice -p 8080:8080 soen387fall2016/erm-dataservice```


## API Interface
Spring automatically generates a HATEOS REST API based on the provided entity classes.

Access the API root at ```http://<server-ip-and-port>/api```.

The responses returned are of type hal+json and contain links to navigate between resources.

### Users
Access the users list at ```http://<server-ip-and-port>/api/users```.

### Resources
Access the resources list at ```http://<server-ip-and-port>/api/resources```.

### Reservations
Access the inventory list at ```http://<server-ip-and-port>/api/reservations```.


&copy; 2016
