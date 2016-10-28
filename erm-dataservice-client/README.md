# erm-dataservice-client

##### Java client library for erm-dataservice-server.


## Structure
This client is generated automatically by swagger-codegen.
For now when running the ```swagger``` task the server needs to be running.
The URL to the Swagger JSON needed to generate the client library is: ```http://localhost:8080/v2/api-docs```

** TODO: Configuration of the plugin needs to be done in ```build.gradle```.

See ```https://github.com/thebignet/swagger-codegen-gradle-plugin``` for more help.


## Including your project

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
  <version>master-18</version>
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
    compile 'com.soen387.erm:erm-dataservice-client:master-18'
}
```


## To Build the library

From the ```erm-dataservice-client``` folder, run: ```../gradlew swagger```.

&copy; 2016
