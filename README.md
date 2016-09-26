# erm-dataservices

##### Provides data storage & retrieval services to the SOEN 387 Fall 2016 Group Project



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

## Interface

### Inventory
Access the inventory in JSON format at ```http://<server-ip-and-port>/inventory```.

To see only a specific item, go to  ```http://<server-ip-and-port>/inventory/<item-id>```.

&copy; 2016