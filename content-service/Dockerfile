FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/content-service-0.0.1.jar /opt/app
EXPOSE 8882
CMD ["java", "-jar", "/opt/app/content-service-0.0.1.jar"]

