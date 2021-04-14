FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/company-service-0.0.1.jar /opt/app
EXPOSE 8881
CMD ["java", "-jar", "/opt/app/company-service-0.0.1.jar"]

