FROM openjdk:8
EXPOSE 8080
ADD target/producer-consumer.jar producer-consumer.jar
ENTRYPOINT ["java","-jar","producer-consumer.jar"]

