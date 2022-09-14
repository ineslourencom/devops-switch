FROM ubuntu

RUN apt-get update -y
RUN apt-get install -y openjdk-11-jdk-headless

COPY basic_demo-0.1.0.jar basic_demo-0.1.0.jar

EXPOSE 59001

ENTRYPOINT java -cp basic_demo-0.1.0.jar basic_demo.ChatServerApp 59001


