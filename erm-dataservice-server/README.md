# erm-dataservice-server

##### Provides data storage & retrieval services to the SOEN 387 Fall 2016 Group Project

[ ![Bintray](https://api.bintray.com/packages/soen387-fall2016/erm-maven/erm-dataservice-client/images/download.svg) ](https://bintray.com/soen387-fall2016/erm-maven/erm-dataservice-server/_latestVersion)

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
When the project is built as a JAR, it can be run with the CLI flags ```--spring.profiles.active=prod --spring.datasource.password=<mysql-password> --spring.datasource.url=<mysql-url> --spring.datasource.username=<mysql-user>``` to run using an existing MySQL/MariaDB database.

### API
Spring Boot is also set up to expose all of the entites as REST API endpoints automatically.
Everything is configurable, it just hasn't been done yet.


## How to build

### Standalone Runnable JAR

Build on Linux / macOS: ```./gradlew build```.

Build on Windows: ```gradlew.bat build```.

Set the following environment variables:

 - `MYSQL_HOST` to the host address, port & database path of your DB server
 - `MYSQL_USER` to the username for your DB server
 - `MYSQL_PASSWORD` to the password of your MySQL/MariaDB server

You can then run the JAR with ```java -jar build/libs/erm-dataservice-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --spring.datasource.password=${MYSQL_PASSWORD} --spring.datasource.url=${MYSQL_HOST} --spring.datasource.username=${MYSQL_USER}```.
** Replace ```0.0.1``` with version of the file JAR found in build/libs.

### Docker
Docker builds are pushed to the Docker Hub with every commit passing tests.

Use docker-compose to run both a mariadb instance and the erm-dataservice-server.

From the ```erm-dataservice``` root project folder, run with Docker Compose using: ```docker-compose up```.


## API Interface
Spring automatically generates a HATEOS REST API based on the provided entity classes.

Access the API root at ```http://<server-ip-and-port>/api```.

The responses returned are of type hal+json and contain links to navigate between resources.

When creating a resource, it will be returned in the response to allow validation that it was created successfully. The link to the resource is contained in the `"_links"` dict, under the `"self"` dict in the `"href"` property.

** Note that when you are referencing an entity in another using a link, the referenced entity must be created beforehand, or else it will simply be ignored.

### Swagger UI interface

The API is explorable in a web browser at this URL: ```http://<server-ip-and-port>/swagger-ui.html```.

### Users
Access the users list at ```http://<server-ip-and-port>/api/users```.

Create a new user by POSTing to this URL with content like:

```
{
    "username": "user1",
    "firstName": "John",
    "lastName": "Smith",
    "roles": [
    	"https://localhost:8080/api/userRoles/2",
    	"https://localhost:8080/api/userRoles/2"
    ],
    "department": "http://localhost:8080/api/departments/3"
}
```

### User Roles
Access the user roles list at ```http://<server-ip-and-port>/api/userRoles```.

Create a new user role by POSTing to this URL with content like:

```
{
    "roleName": "admin",
}
```

### Departments
Access the departments list at ```http://<server-ip-and-port>/api/departments```.

Create a new department by POSTing to this URL with content like:

```
{
    "name": "department 1",
}
```

### Reservations
Access the inventory list at ```http://<server-ip-and-port>/api/reservations```.

Create a new reservation by POSTing to this URL with content like:

```
{
	"user": "http://localhost:8080/api/users/johnsmith",
	"resources": [
		"https://localhost:8080/api/resources/3",
		"https://localhost:8080/api/resources/29",
		"https://localhost:8080/api/resources/43"
	],
	"startDateTime": "2016-12-03T12:58:29.102",
	"endDateTime": "2016-12-17T12:58:29.102"
}
```

### Resources
Access the resources list at ```http://<server-ip-and-port>/api/resources```.

** Note that it is necessary to include the "type" value to ensure mapping to the correct resource type.

** To modify existing resources, make a PUT request to the resource's link containing only the data you wish to change.

#### Buildings
Create a new building by POSTing to this URL with content like:

```
{
	"name": "Hall",
	"description": "Henry F. Hall Building",
	"available": true,
	"moveable": false,
	"address": "2100 Bishop St., Montreal, Quebec, Canada",
	"type": "building",
}
```

#### Rooms
Create a new room by POSTing to this URL with content like:

```
{
	"name": "Conference Room #1",
	"description": "Medium-sized room seating 15 people",
	"available": false,
	"moveable": false,
	"roomNumber": "CR1",
	"type": "room",
	"building": "http://localhost:8080/api/resources/4"
}
```

#### Computers
Create a new computer by POSTing to this URL with content like:

```
{
	"name": "main computer",
	"description": "this is the main computer",
	"available": true,
	"moveable": true,
	"hostname": "mshome-1",
	"machineType": "Desktop",
	"operatingSystem": null,
	"manufacturer": "Dell",
	"model": "Inspiron",
	"dviOutput": true,
	"vgaOutput": true,
	"hdmiOutput": false,
	"speakers": true,
	"keyboard": true,
	"mouse": true,
	"wirelessNetworking": false,
	"wiredNetworking": true,
	"type": "computer",
	"room": "http://localhost:8080/api/resources/15"
}
```

#### Projectors
Create a new projector by POSTing to this URL with content like:

```
{
	"name": "Projector 15",
	"description": "DLP projector",
	"available": true,
	"moveable": true,
	"resolution": {
		"width": 1920,
		"height": 1080
	},
	"dviInput": true,
	"vgaInput": true,
	"hdmiInput": false,
	"type": "projector",
	"room": "http://localhost:8080/api/resources/15"
}	
```

#### Whiteboards
Create a new whiteboard by POSTing to this URL with content like:

```
{
	"name": "Whiteboard AXA",
	"description": "Main whiteboard in the conference room",
	"available": true,
	"moveable": false,
	"dimensions": {
		"width": 1000,
		"height": 1000
	},
	"type": "whiteboard",
	"room": "http://localhost:8080/api/resources/15"
}
```


&copy; 2016
