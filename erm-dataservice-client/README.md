# erm-dataservice-client

##### Java client library for erm-dataservice-server.

[![Bintray](https://img.shields.io/bintray/v/soen387-fall2016/erm-maven/erm-dataservice-client.svg)](https://bintray.com/soen387-fall2016/erm-maven/erm-dataservice-client)

## Structure

The client provides a Java interface to fetch information from the server.


** For now only GET operations are supported, POST to come very soon.

```
// Create a client at a specified address
ClientConfig config = new ClientConfig("http://<my-server-and-port>/api-path");
DataserviceClient client = new DataserviceClient(config);

// Create a client at the default address (http://localhost:8080/api)
DataserviceClient client = new DataserviceClient();

// Get all users in the system
Collection<User> allUsers = client.getUserApi().getAllUsers();

// Get a user by username
String username = "uzah";
User user = client.getUserApi().getUserByUsername(username);

// Get a user by its link
String link = "http://localhost:8080/api/users/uzah";
User user = client.getUserApi().getByLink(link);

// Access user properties
user.getContent().getFirstName();
user.getContent().getLastName();

// Access link to department
String linkToUserDepartment = user.getLink("department").getHref();
// Get department instance
Department dept = client.getDepartmentApi().getResourceByLink(linkToUserDepartment);

// Access links to user roles
String linkToUserRoles = user.getLink("roles").getHref();
// Get collection of user role instances
Collection<UserRole> roles = client.getUserRoleApi().getCollectionByLink(linkUserRoles);

// Create a department
Department d1 = new Department();
d1.setName("Department HEYYO!");
Department createdDepartment = client.getDepartmentApi().createResource(d1);

// Create a user role
UserRole role = new UserRole();
role.setUserRoleHumanReadable("ROLE #2!");
UserRole createdRole = client.getUserRoleApi().createResource(role);

// Assign a department & role to a user
user.setDepartment(createdDepartment.getId().getHref());
user.addRole(createdRole.getId().getHref());
client.getUserApi().createResource(user); // to update existing user (I think)

```

## Including the client in your project
** Replace 'master-31' with the latest or target version you want.
** The latest passing version can be found at the top of this file in the Bintray badge.

### Maven
In your pom.xml file, add the following:

In the ```<repositories>``` tag:
```
<repository>
  <id>erm-maven</id>
  <name>ERM Maven Repository on Bintray</name>
  <url>https://dl.bintray.com/soen387-fall2016/erm-maven</url>
</repository>
```

In the ```<dependencies>``` tag:
```
<dependency>
  <groupId>com.soen387.erm</groupId>
  <artifactId>erm-dataservice-client</artifactId>
  <version>master-31</version>
  <type>pom</type>
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
    compile 'com.soen387.erm:erm-dataservice-client:master-31'
}
```


## To Build the library

From the ```erm-dataservice-client``` folder:

Run on Linux / macOS: ```../gradlew build```.

Run on Windows: ```../gradlew.bat build```.


## Acknowldgements

The design of the client library is based on this example: [https://github.com/locisvv/spring-hateoas-client](https://github.com/locisvv/spring-hateoas-client).
&copy; 2016
