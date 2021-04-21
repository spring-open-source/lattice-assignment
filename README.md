## Setup

* Install Java 15
* Install Maven

Recommended way is to use [sdkman](https://sdkman.io/) for installing both maven and java

Run mvn clean install in the core

```
mvn clean install
```

Run docker commands

```
sudo docker-compose build
sudo docker-compose up -d
```

Service port is 9999 and Postgres Port is 6432. They both can be changed in the [docker-compose.yml](docker-compose.yml) file

To stop the container run

```
sudo docker-compose stop
```

### Documentation
Swagger documentation can be found at

```
http://localhost:9090/lattice/swagger-ui.html
```

### Technologies
Below mentioned libraries/frameworks/technologies were used

```
Spring Boot
Hibernate
Hibernate Validator
Flyway
PostgreSQL
Lombok
Swagger-UI
```
