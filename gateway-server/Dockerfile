FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/gateway-server-0.0.1.jar /opt/app
EXPOSE 8880
CMD ["java", "-jar", "/opt/app/gateway-server-0.0.1.jar"]

