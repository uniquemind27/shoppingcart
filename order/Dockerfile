# This image is based on the official Java 8.
FROM java:8-jre

#working directory is usr/src
WORKDIR usr/src

# Copy our application jar file from the target dir to the container
# If no version has been provided, this statement will fail the build.
ADD target/order-0.0.1-SNAPSHOT.jar /usr/src/order-0.0.1-SNAPSHOT.jar

# Expose our application port. On it's own, this doesn't do much however;
#  - Using -P on the docker run command will publish this port
EXPOSE 9090

# The entrypoint is simply the first command run when the image is started up.
# In this case it is booting up our application.
# Users of the image can add their own statements after the entrypoint, such as arguments or commands.
ENTRYPOINT ["java", "-jar", "/usr/src/order-0.0.1-SNAPSHOT.jar"]