FROM openjdk:11-jdk-slim
EXPOSE 5000
ADD target/project-greeting.jar project-greeting.jar
CMD ["java", "-Dfile.encoding=UTF-8", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/project-greeting.jar"]
