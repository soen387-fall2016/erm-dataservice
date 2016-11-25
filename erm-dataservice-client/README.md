# erm-dataservice-client

##### Java client library for erm-dataservice-server.

[![Bintray](https://img.shields.io/bintray/v/soen387-fall2016/erm-maven/erm-dataservice-client.svg)](https://bintray.com/soen387-fall2016/erm-maven/erm-dataservice-client)

## Structure

The client provides a Java interface to fetch information from the server.


** For now only GET operations are supported, POST to come very soon.

### User API (Users, Departments, UserRoles)
```
// Create a client at a specified address
ClientConfig config = new ClientConfig("http://<my-server-and-port>/api-path");
DataserviceClient client = new DataserviceClient(config);

// Create a client at the default address (http://localhost:8080/api)
DataserviceClient client = new DataserviceClient();

// Get all users in the system
Collection<User> allUsers = client.getUserApi().getAll();

// Get a user by username
String username = "uzah";
User user = client.getUserApi().getUserByUsername(username);

// Get a user by its link
String link = "http://localhost:8080/api/users/uzah";
User user = client.getUserApi().getByLink(link);

// Access user properties
user.getFirstName();
user.getLastName();

// Access link to department
String linkToUserDepartment = user.getLink("department").getHref();
// Get department instance
Department dept = client.getDepartmentApi().getByLink(linkToUserDepartment);

// Access links to user roles
String linkToUserRoles = user.getLink("roles").getHref();
// Get collection of user role instances
Collection<UserRole> roles = client.getUserRoleApi().getCollectionByLink(linkToUserRoles);

// Create a department
Department d1 = new Department();
d1.setName("Department HEYYO!");
Department createdDepartment = client.getDepartmentApi().create(d1);

// Create a user role
UserRole role = new UserRole();
role.setUserRoleHumanReadable("ROLE #2!");
UserRole createdRole = client.getUserRoleApi().create(role);

// Assign a department & role to a user
user.setDepartment(createdDepartment.getId().getHref());
user.addRole(createdRole.getId().getHref());
client.getUserApi().create(user); // to update existing user

```

### Reservation API (Reservations)
```
// Create a client at a specified address
ClientConfig config = new ClientConfig("http://<my-server-and-port>/api-path");
DataserviceClient client = new DataserviceClient(config);

// Get all reservations in the system
Collection<Reservation> allReservations = client.getReservationApi().getAll();

// Get a reservation by ID
Long reservationId = 2L;
Reservation reservation2 = client.getReservationApi().getReservationById(reservationId);

// Get a reservation by its link
String link = "http://localhost:8080/api/reservations/2";
Reservation reservation2 = client.getReservationApi().getByLink(link);

// Access reservation properties
reservation2.getStartDateTime();
reservation2.getEndDateTime();

// Access link to user
String linkToReservationUser = reservation2.getLink("user").getHref();
// Get user instance
User reservationUser = client.getUserApi().getByLink(linkToReservationUser);

// Access link to resources
// TODO not yet implemented

```

### Resource API (Building, Room, Projector, Computer, Whiteboard)
```
// TODO not yet implemented
```


## Including the client in your project
** Replace 'master-31' with the latest or target version you want.
** The latest passing version can be found at the top of this file in the Bintray badge.

### Maven
In your pom.xml file, add the following:

In the ```<repositories>``` tag:
```
<repository>
    <id>bintray-soen387-fall2016-erm-maven</id>
    <name>ERM Maven Repository on Bintray</name>
    <url>http://dl.bintray.com/soen387-fall2016/erm-maven</url>
</repository>
```

In the ```<dependencies>``` tag:
```
<dependency>
    <groupId>com.soen387.erm.dataservice</groupId>
    <artifactId>erm-dataservice-client</artifactId>
    <version>master-48</version>
</dependency>
```

### Gradle
In your build.gradle file, add the following:

```
repositories {
    maven {
        url 'https://dl.bintray.com/soen387-fall2016/erm-maven'
    }
}    

dependencies {
    compile 'com.soen387.erm.dataservice:erm-dataservice-client:master-48'
}
```


## To Build the library

From the ```erm-dataservice-client``` folder:

Run on Linux / macOS: ```../gradlew build```.

Run on Windows: ```../gradlew.bat build```.


## Acknowldgements

The design of the client library is based on this example: [https://github.com/locisvv/spring-hateoas-client](https://github.com/locisvv/spring-hateoas-client).
&copy; 2016
