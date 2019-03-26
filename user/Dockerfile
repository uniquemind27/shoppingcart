# This image is based on the official Java 8.
FROM java:8
# Which version of the service should this image use
ARG artifact_version
# Copy our application jar file from the target dir to the container
# If no version has been provided, this statement will fail the build.
ADD target/user-0.0.1-SNAPSHOT.jar /usr/share/app.jar

# Expose our application port. On it's own, this doesn't do much however;
#  - Using -P on the docker run command will publish this port
#  - It serves as documentation to anyone using this image
EXPOSE 9080
# The entrypoint is simply the first command run when the image is started up.
# In this case it is booting up our application.
# Users of the image can add their own statements after the entrypoint, such as arguments or commands.
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]