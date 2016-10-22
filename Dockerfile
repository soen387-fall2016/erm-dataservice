FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp

ADD build/libs/erm-dataservice-0.0.1-SNAPSHOT.jar erm-dataservice.jar

EXPOSE 8080

RUN sh -c 'touch /erm-dataservice.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/erm-dataservice.jar"]
