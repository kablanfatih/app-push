FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/hystrix-0.0.1.jar /opt/app
EXPOSE 8884
CMD ["java", "-jar", "/opt/app/hystrix-0.0.1.jar"]

