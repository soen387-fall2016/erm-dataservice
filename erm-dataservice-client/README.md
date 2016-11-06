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
Collection<Resource<User>> allUsers = client.getUserApi().getAllUsers();

// Get a user by username
String username = "uzah";
Resource<User> user = client.getUserApi().getUserByUsername(username);

// Get a user by its link
String link = "http://localhost:8080/api/users/uzah";
Resource<User> user = client.getUserApi().getByLink(link);

// Access user properties
user.getContent().getFirstName();
user.getContent().getLastName();

// Access link to department
String linkToUserDepartment = user.getLinks("department").getHref();
// Get department instance
Resource<Department> dept = client.getDepartmentApi().getResourceByLink(linkToUserDepartment);

// Access links to user roles
String linkToUserRoles = user.getLinks("roles").getHref();
// Get collection of user role instances
Collection<Resource<UserRole>> roles = client.getUserRoleApi().getCollectionByLink(linkUserRoles);

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
