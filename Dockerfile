FROM amazoncorretto:17

WORKDIR /usr/local/test
COPY build/libs/test.jar .

ENTRYPOINT ["java", "-jar", "test.jar"]