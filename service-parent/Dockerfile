FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/ /opt/app
EXPOSE 8888
CMD ["java", "-jar", "/opt/app/config-server-0.0.1.jar"]

