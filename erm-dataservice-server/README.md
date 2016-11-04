# erm-dataservice-server

##### Provides data storage & retrieval services to the SOEN 387 Fall 2016 Group Project

## How to run
This is a gradle project which you can run using the included Gradle wrapper. It uses Spring Boot with a Tomcat server.

Run on Linux / macOS: ```../gradlew bootRun```.

Run on Windows: ```../gradlew.bat bootRun```.

This will run the server on your machine where you can access it at ```http://localhost:8080```.

## Info

### Architecture
This project uses Spring Boot which makes setup/configuration very easy.

All entities are configured as Java classes, and Hibernate takes care of the database mappings.
I don't believe we even have to write a schema, but it will be possible to export it from the running database if need be.

### Database
Currently the service is running with an embedded H2 database. This is only an in-memory database, nothing is persisted.
So it is great for testing because it requires no external set-up, but we will need to move to MySql soon enough. This shouldn't be very hard though.

### API
Spring Boot is also set up to expose all of the entites as REST API endpoints automatically.
Everything is configurable, it just hasn't been done yet.


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

### Swagger UI interface

The API is explorable in a web browser at this URL: ```http://localhost:8080/swagger-ui.html```.

### Users
Access the users list at ```http://<server-ip-and-port>/api/users```.

### Resources
Access the resources list at ```http://<server-ip-and-port>/api/resources```.

### Reservations
Access the inventory list at ```http://<server-ip-and-port>/api/reservations```.


&copy; 2016
