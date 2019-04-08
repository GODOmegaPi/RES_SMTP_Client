FROM java:8
MAINTAINER Simon & Guillaume

#
# When we build the image, we copy the executable jar in the image file system. 
#
COPY MockMock.jar /opt/app/MockMock.jar

EXPOSE 2525 8080

#
# This is the command that is executed when the Docker container starts
#
CMD ["java", "-jar", "/opt/app/MockMock.jar", "-p", "2525", "-h", "8080"]