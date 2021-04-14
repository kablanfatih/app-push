FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/notification-service-0.0.1.jar /opt/app
EXPOSE 8883
CMD ["java", "-jar", "/opt/app/notification-service-0.0.1.jar"]

