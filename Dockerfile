FROM openjdk:17-oracle
MAINTAINER Madi
COPY Sales-0.0.1-SNAPSHOT.jar tcg.jar
ENTRYPOINT ["java", "-jar", "tcg.jar"]