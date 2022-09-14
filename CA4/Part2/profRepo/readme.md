# Docker Compose VM Demonstration

This project demonstrates how to run a container with Tomcat and other with H2.

## Requirements

Install Docker in you computer.

## How to build and execute

In the folder of the docker-compose.yml execute

  ```docker-compose build```

The execute

  ```docker-compose up```

### How to use

  In the host you can open the spring web application using the following url:

  - http://localhost:8080/basic-0.0.1-SNAPSHOT/

  You can also open the H2 console using the following url:

  - http://localhost:8080/basic-0.0.1-SNAPSHOT/h2-console

  For the connection string use: jdbc:h2:tcp://192.168.33.11:9092/./jpadb  
