FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/avaliacao

COPY target/avaliacao*.jar avaliacao_cast.jar

SHELL ["/bin/sh" , "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar avaliacao_cast.jar --spring.profiles.active=${PROFILE}