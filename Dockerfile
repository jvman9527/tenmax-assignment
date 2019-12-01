FROM openjdk:8-jre-alpine

ARG ARTIFACT=build/libs/*.jar

RUN apk add tzdata && \
    cp /usr/share/zoneinfo/Asia/Taipei /etc/localtime && \
    echo "Asia/Taipei" > /etc/timezone && \
    apk del tzdata

COPY ${ARTIFACT} /srv/app.jar

ENTRYPOINT ["java", "-jar", "/srv/app.jar"]

