FROM tomcat:8-jdk8-temurin

RUN apt-get update -y

RUN apt-get install sudo nano git nodejs npm -f -y

RUN apt-get clean && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /tmp/build

WORKDIR /tmp/build/

RUN git clone https://ineslourencom@bitbucket.org/ineslourencom/devops-21-22-atb-1211767.git

WORKDIR /tmp/build/devops-21-22-atb-1211767/CA4/Part2/personalRepo/react-and-spring-data-rest-basic

RUN ./gradlew clean build && ./gradlew war && cp build/libs/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ && rm -Rf /tmp/build/

EXPOSE 8080

