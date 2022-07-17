FROM maven:3.6.0-jdk-11-slim 
COPY . /
#set the startup command to execute the jar
CMD ["java", "-jar", "Test.jar"]