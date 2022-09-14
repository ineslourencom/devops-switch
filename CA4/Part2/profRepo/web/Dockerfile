FROM tomcat:8-jdk8-temurin

RUN apt-get update -y 

RUN apt-get install sudo nano git nodejs npm -f -y

RUN apt-get clean && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /tmp/build

WORKDIR /tmp/build/

RUN git clone https://atb@bitbucket.org/atb/tut-basic-gradle-docker.git

WORKDIR /tmp/build/tut-basic-gradle-docker

RUN ./gradlew clean build && cp build/libs/basic-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ && rm -Rf /tmp/build/

EXPOSE 8080
