FROM openjdk:17-oracle
MAINTAINER Madi
COPY --from=build/libs/Sales-0.0.1-SNAPSHOT.jar tcg.jar
ENTRYPOINT ["java", "-jar", "tcg.jar"]