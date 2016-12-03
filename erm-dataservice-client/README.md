# erm-dataservice-client

##### Java client library for erm-dataservice-server.

[ ![Bintray](https://api.bintray.com/packages/soen387-fall2016/erm-maven/erm-dataservice-client/images/download.svg) ](https://bintray.com/soen387-fall2016/erm-maven/erm-dataservice-client/_latestVersion)

## Structure

The client provides a Java interface to fetch information from the server.

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

// Create a reservation
Reservation r1 = new Reservation();
r1.setUser(dummyUser1.getId().getHref());
LocalDateTime now = LocalDateTime.now();
r1.setStartDateTime(now);
r1.setEndDateTime(now.plusWeeks(2));
Reservation createdReservation = client.getReservationApi().create(r1);

// Access link to resources
List<String> reservationResources = createdReservation.getResources();

```

### Resource API (Building, Room, Projector, Computer, Whiteboard)
```
// Create a client at a specified address
ClientConfig config = new ClientConfig("http://<my-server-and-port>/api-path");
DataserviceClient client = new DataserviceClient(config);

// Get all resources in the system
Collection<AbstractResource> allReservations = client.getResourceApi().getAll();

// Get a resource by ID
Long resourceId = 2L;
AbstractResource resource2 = client.getResourceApi().getByResourceId(resourceId);

// Get a resource by its link
String link = "http://localhost:8080/api/resources/24";
AbstractResource resource24 = client.getResourceApi().getByLink(link);

// Access reservation properties
resource24.getName();
resource24.getDescription();
resource24.getMoveable();
resource24.getAvailable();

// Knowing the type of the resource, you can cast it to its class (Building, Room, Projector, Computer, Whiteboard)
Computer c = (Computer) resource24;
c.getHostname();
c.getMachineType();
c.getOperatingSystem();
c.getModel();
c.getManufacturer();
c.getWirelessNetworking();
// etc.

// Get the room where the resource is located
String linkToResourceRoom = c.getRoomLink();
// Get room instance
Room resourceRoom = (Room) client.getResourceApi().getByLink(linkToResourceRoom);

// Create a building
Building b1 = new Building();
b1.setName("Hall");
b1.setDescription("Henry F. Hall Building");
b1.setAddress("2100 Bishop St., Montreal, Quebec, Canada");
Building createdBuilding = (Building) client.getResourceApi().create(b1);

// Create a room
Room r = new Room();
r.setName("Conference Room #1");
r.setAvailable(false);
r.setMoveable(false);
r.setRoomNumber("CR1");
r.setDescription("Conference room seating between 8 to 10 people, located on the 2nd floor.");
r.setBuildingLink(createdBuilding.getId().getHref());
Room createdRoom = (Room) client.getResourceApi().create(r);

// Similarly for Projector, Computer & Whiteboard

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
