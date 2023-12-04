# Practice question 8
This is an Individual project, I have worked on rest API service.

## Entity Relationship Diagram

[![ER Diagram](https://github.com/faterenuka/RestAPI_Question8/blob/main/practice8.jpg?raw=true)](https://github.com/faterenuka/RestAPI_Question8/blob/main/practice8.jpg?raw=true)

## Backend Work
-  Proper Exception Handling
-  Proper Input Validation
-   Data Stored in the database(mySQL)
-   Security

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.

server.port=8099
#db configuration
spring.datasource.url=jdbc:mysql://localhost:3306/user_role
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
#create,update,create-drop,validate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring Boot
-   Hibernate
-   MySQL
-   Spring Security
## Thank You! For your Time : )
