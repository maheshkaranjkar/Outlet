FROM openjdk:8
ADD target/outlet.jar outlet.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "outlet.jar"]