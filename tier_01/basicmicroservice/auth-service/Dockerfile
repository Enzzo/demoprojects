FROM openjdk:17-slim
MAINTAINER Sergey Vasilev <vasilevnogliki@yandex.ru>
WORKDIR /app
COPY /src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests
ENTRYPOINT ["java", "-jar", "/target/*.jar"]