FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/eureka-server-0.0.1.jar /opt/app
EXPOSE 8761
CMD ["java", "-jar", "/opt/app/eureka-server-0.0.1.jar"]

