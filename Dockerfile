FROM openjdk:8
EXPOSE 8081
COPY ./target/outreach-portal.jar ./
WORKDIR ./
ENTRYPOINT ["java", "-jar", "outreach-portal.jar"]