# Java Spring-boot RESTfull API
This is a spring boot RESTfull API that uses MySQL database for storage.


List of: things regarding this project include:
*  **Java**  
*  **Spring-boot** 
*  **Maven** 
*  **Unit-test** 
*  **JPA** 
*  **MySQL** 
*  **Intellij** 
*  **Apache Tomcat/9.0.56** 
*  **Java** 
*  **Java** 


### Getting Started
The API is configured to run on embedded Tomcat server that will
startup when the project starts runing on localhost at port **8080**,
and expects a running instance of MySQL database server on localhost port
**3306** and a database name called **my_sql_db_test** for storage. 

Sql Database connection configuration is in `application.properties` configuration file.

#####API end-points url:
| Action | Url                                  |HTTP method|
|--------|--------------------------------------|-------------|
| Get all|http://localhost:8080/api/v1/data     |GET        |
| Get 1  |http://localhost:8080/api/v1/data/{id}|GET        |
| Create |http://localhost:8080/api/v1/data     |POST       |
| Update |http://localhost:8080/api/v1/data/{id}|PUT        |
| Delete |http://localhost:8080/api/v1/data/{id}|DEL        |
 
 Create and update requiere JSON payload in the http request body! 
 Example:
 
     {
         "firstName": "John",
         "lastName": "Martin",
         "emailId": "johnmart@example.com"
     }
![Blank diagram](https://user-images.githubusercontent.com/9350798/147575757-5c6cf78e-a1d6-49da-800d-27db690e9ce1.png)
#### Reference Documentation
For further reference for included techs, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

