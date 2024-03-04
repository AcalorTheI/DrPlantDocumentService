FROM openjdk:17

COPY ./target/DocumentService.jar DocumentService.jar

CMD ["java", "-jar",  "/DocumentService.jar"]