FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/service-common-0.0.1.jar /opt/app
CMD ["java", "-jar", "/opt/app/service-common-0.0.1.jar"]

