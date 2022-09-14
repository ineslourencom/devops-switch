# syntax=docker/dockerfile:1
FROM ubuntu

RUN apt-get update
RUN apt-get install -y apache2
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

RUN apt-get update
RUN apt-get install openjdk-8-jdk-headless -y
RUN apt-get install git -y


RUN git clone https://ineslourencom@bitbucket.org/ineslourencom/devops-21-22-atb-1211767.git
WORKDIR devops-21-22-atb-1211767/CA4/Part1/gradle_basic_demo

RUN chmod u+x gradlew

RUN ./gradlew clean build

EXPOSE 59001

ENTRYPOINT ./gradlew runServer

