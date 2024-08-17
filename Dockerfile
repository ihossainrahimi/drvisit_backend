## DEPENDENCY
#FROM  art.azki.com/base-image-docker-local/jdk17-alpine3-18-maven3.8.5 as dependency_maven
#COPY pom.xml ./
#COPY .mvn ./.mvn
#RUN mvn -X -B dependency:resolve


## BUILD
#FROM dependency_maven as build_maven
#COPY src ./src
#RUN mvn -B clean package -DskipTests=true

## Run Jar File
#FROM art.azki.com/base-image-docker-local/jdk17-alpine3-18
#ENV TZ=Asia/Tehran
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#COPY --from=build_maven target/*.jar run.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./run.jar"]



FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
