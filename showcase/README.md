# Showcase

* [PT-BR](./README-PT.md)

### The project includes the following features:

* **Normalization and similarity tests:** automated tests to verify if the data is being normalized and if it is similar
  enough to be considered equal.
* **Exception handler:** exception handling to catch and respond to errors consistently.
* **Use of libraries such as Lombok, MapStruct, Jackson:** Java libraries to facilitate code development.
* **MySQL database:** database used to store application data.
* **Lombok and MapStruct configuration:** configuration of the Lombok and MapStruct libraries.
* **Docker:** The project uses Docker to run the application. This means that the application can be run on any
  environment that has Docker installed.

---

## Executing the application

To run the application without Docker, follow these steps:

1. Install Java JDK 17 or higher.
2. Install Maven.
3. Clone the project repository.
4. Access the project directory.
5. Run the command `mvn clean install` to create the JAR file for the application.
6. Run the command `java -jar target/showcase-0.0.1-SNAPSHOT.jar` to start the application.

The application will be available at the address http://localhost:8080.

To run the application using Docker, follow these steps:

1. Install Docker on your computer.
2. Clone the project repository.
3. Access the project directory.
4. Run the command `docker build -t showcase .` to create the Docker image.
5. Run the command `docker run -p 8080:8080 showcase` to start the application.

The application will be available at the address http://localhost:8080.

---

## Executing the tests

To execute the tests of the project, just follow these steps:

1. Install Java JDK 17 or higher.
2. Install Maven.
3. Clone the project repository.
4. Access the project directory.
5. Run the command `mvn clean test`.

The tests will be executed and the results will be displayed in the console.

To execute the tests using Docker, follow these steps:

1. Install Docker on your computer.
2. Clone the project repository.
3. Access the project directory.
4. Run the command `docker build -t showcase .` to create the Docker image.
5. Run the command `docker run -p 8080:8080 showcase` to start the application.
6. Run the command `docker exec showcase mvn clean test` to execute the tests.

The tests will be executed and the results will be displayed in the console.

---

## Recommendations

It is recommended to configure the Tomcat application server to run the application. This will make it easier to run and
manage the application.

* The project is configured to use the MySQL database. To use another database, change the configuration of
  the `application.yaml` file.
* The project is configured to use Lombok and MapStruct. To disable the use of these libraries, change the configuration
  of the `pom.xml` file.
* If you are using an IDE, such as IntelliJ IDEA or Eclipse, you can run the application by clicking the "Run" button.
* If you are using Maven, you can also run the application using the command `mvn spring-boot:run`.

---

## Future Implementations

In addition to the features already implemented, the project aims to implement the following features in the future:

* **Search for data in the external API Via Cep:** This feature will allow the application to search for address data
  from a CEP using the external Via Cep API.
* **Authentication and authorization:** This feature will allow users to authenticate and be authorized to access the
  application.
* **Token generation:** This feature will allow the application to generate tokens for user authentication.
* **Apache Kafka messaging:** This feature will allow the application to send and receive messages through Apache Kafka.
* **Email sending with link and password:** This feature will allow the application to send an email with a link for
  password reset to users.

These implementations will improve the functionality and security of the application.

---

## Error flow

The application has a basic error flow that handles common errors. If an error occurs, the application will log the
error to the console and return an error response to the user.

The application handles errors using the following strategies:

* **Logging:** All errors are logged to the console.
* **Exceptions:** Exceptions are thrown for all errors that cannot be handled gracefully.
* **Error pages:** Error pages are displayed to users for errors that can be handled gracefully. (future implementation)

| Code                                 | Description                                                        |
|:-------------------------------------|:-------------------------------------------------------------------|
| 400 - ARGUMENT NOT VALID             | Invalid request                                                    |
| 400 - EMAIL ALREADY EXISTS           | Email already registered in the system                             |
| 400 - DOCUMENT NUMBER ALREADY EXISTS | Document number already registered in the system                   |
| 400 - CUSTOMER NOT ACTIVE            | User not registered or not active                                  |
| 401 - UNAUTHORIZED                   | User not authenticated. Must register or log in.                   |
| 403 - FORBIDDEN                      | Restricted page. User does not have permission to access the page. |
| 404 - CUSTOMER NOT LOGGED IN         | Must log in to make desired changes.                               |
| 404 - NOT FOUND                      | Unable to find requested data.                                     |
| 404 - CUSTOMER NOT FOUND             | Unable to find the customer!                                       |
| 404 - DOCUMENT NUMBER NOT CHANGEABLE | Document number cannot be changed. Contact support!                |
| 404 - EMAIL NOT CHANGEABLE           | Email cannot be changed. Contact support!                          |
| 500 - SERVER ERROR                   | Internal server error. Please try again later.                     |

---