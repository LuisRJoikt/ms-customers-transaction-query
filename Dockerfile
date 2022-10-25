FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/ms-customers-transaction-query-0.0.1-SNAPSHOT.jar ./ms-customers-transaction-query.jar

EXPOSE 8085

CMD [ "java", "-jar", "ms-customers-transaction-query.jar" ]