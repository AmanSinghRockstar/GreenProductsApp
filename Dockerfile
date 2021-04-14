# Fetch the base image to run JDK11
FROM openjdk:11.0.10-jre-slim

# Base folder for deployment
WORKDIR /greenapps/app

# Argument for specifying target folder
ARG PROJECT_BUILD_FOLDER 
COPY ${PROJECT_BUILD_FOLDER}/greenproducts-1.0.0.jar ./greenproducts-1.0.0.jar
RUN sh -c 'touch /greenproducts-1.0.0.jar'

# Retrieve the Java Options for the service
ENV JAVA_OPTS=""

# Base cmd to run service
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /greenapps/app/greenproducts-1.0.0.jar"]

# Port to be exposed
EXPOSE 8093