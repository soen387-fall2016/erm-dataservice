# erm-dataservice-server

##### Provides data storage & retrieval services to the SOEN 387 Fall 2016 Group Project

[![Bintray](https://img.shields.io/bintray/v/soen387-fall2016/erm-maven/erm-dataservice-server.svg)](https://bintray.com/soen387-fall2016/erm-maven/erm-dataservice-server)

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
The service uses an embedded H2 database when running the ```bootRun``` and ```test``` tasks. This is only an in-memory database, so nothing is persisted.
When the project is built as a JAR, it can be run with the CLI flags ```--spring.profiles.active=prod --spring.datasource.password=<mysql-password>``` to run using an existing MySQL/MariaDB database.

### API
Spring Boot is also set up to expose all of the entites as REST API endpoints automatically.
Everything is configurable, it just hasn't been done yet.


## How to build

### Standalone Runnable JAR

Build on Linux / macOS: ```./gradlew build```.

Build on Windows: ```gradlew.bat build```.

Set the environment variable MYSQL_ROOT_PASSWORD to the password of your MySQL/MariaDB server.

You can then run the JAR with ```java -jar build/libs/erm-dataservice-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --spring.datasource.password=${MYSQL_ROOT_PASSWORD}```.
** Replace ```0.0.1``` with version of the file JAR found in build/libs.

### Docker
Docker builds are pushed to the Docker Hub with every commit passing tests.

Use docker-compose to run both a mariadb instance and the erm-dataservice-server.

From the ```erm-dataservice``` root project folder, run with Docker Compose using: ```docker-compose up```.


## API Interface
Spring automatically generates a HATEOS REST API based on the provided entity classes.

Access the API root at ```http://<server-ip-and-port>/api```.

The responses returned are of type hal+json and contain links to navigate between resources.

### Swagger UI interface

The API is explorable in a web browser at this URL: ```http://localhost:8080/swagger-ui.html```.

### Users
Access the users list at ```http://<server-ip-and-port>/api/users```.

Create a new user by POSTing to this URL with content like:
```
{
    "username": "user1",
    "firstName": "John",
    "lastName": "Smith",
    "type": "user"
}
```

### User Roles
Access the user roles list at ```http://<server-ip-and-port>/api/userRoles```.

Create a new user role by POSTing to this URL with content like:
```
{
    "roleName": "admin",
    "type": "userRole"
}
```

### Departments
Access the departments list at ```http://<server-ip-and-port>/api/departments```.

Create a new department by POSTing to this URL with content like:
```
{
    "name": "department 1",
    "type": "department
}
```

### Resources
Access the resources list at ```http://<server-ip-and-port>/api/resources```.

### Reservations
Access the inventory list at ```http://<server-ip-and-port>/api/reservations```.


&copy; 2016
