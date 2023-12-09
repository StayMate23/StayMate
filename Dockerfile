FROM amazoncorretto:21.0.1-alpine3.18

EXPOSE 8080

WORKDIR /opt

COPY target/Stay_Mate-0.0.1-SNAPSHOT.jar /opt/Stay_Mate-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "sh", "-c", "java -jar Stay_Mate-0.0.1-SNAPSHOT.jar" ]
