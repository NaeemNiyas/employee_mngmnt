# Employee Management System

This is a simple Employee Management System built with Spring Boot and MySQL. It allows you to manage employee records, including adding, removing, finding, and listing employees.

## Getting Started

Follow these steps to get started with the Employee Management System:

1. **Clone this repository to your local machine:**
2. Configure the MySQL Database:
 
  Open the src/main/resources/application.properties file.
  Update the spring.datasource.username and spring.datasource.password properties with your MySQL database username and password.

  3. Build and run the application using Maven (or use your IDE's run feature):

  4. Testing with Postman:

Open Postman or a similar tool.

Use HTTP requests to interact with the application:

To add an employee, send a POST request with JSON data to: http://localhost:8080/emp/addEmp. The JSON format should be structured like this:
{
    "id": 2,
    "name": "Naeem",
    "salary": 50000.0,
    "address": "Kannur",
    "department": "Software Engineering"
}

To list all employees, send a GET request to: http://localhost:8080/emp/getAll.

To find an employee by ID, send a GET request to: http://localhost:8080/emp/findEmp/{id}.

To remove an employee by ID, send a DELETE request to: http://localhost:8080/emp/removeEmp/{id}.

5.Run Tests (Optional):

To run tests, use the following Maven command:
mvn test
