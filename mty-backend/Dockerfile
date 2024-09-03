FROM openjdk:17-jdk-alpine
MAINTAINER 1096048222@qq.com
RUN mkdir -p /mty/backend
WORKDIR /mty/backend
EXPOSE 8089
ADD ./target/mty-backend-1.0.0.jar ./app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
CMD ["--spring.profiles.active=prod"]
