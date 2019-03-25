# base image
FROM hirokimatsumoto/alpine-openjdk-11

# Adding a VOLUME at /tmp, because it's the Tomcat default working dir, created by Spring-Boot
VOLUME /tmp

# make port 80 available to the world outside this container
EXPOSE 80

# add application artifact and rename it
COPY target/*.jar app.jar

# Execute the application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]