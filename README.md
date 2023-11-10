# Employee Management System

This is a simple Employee Management System built with Spring Boot and MySQL. It allows you to manage employee records, including adding, removing, finding, and listing employees.

## Getting Started

Follow these steps to get started with the Employee Management System:

1. Clone this repository to your local machine:

2. Configure the MySQL Database:
- Open the `src/main/resources/application.properties` file.
- Update the `spring.datasource.username` and `spring.datasource.password` properties with your MySQL database username and password.

3. Run the Application:
- Open your terminal or command prompt and navigate to the project directory:

- Build and run the application using Gradle (or use your IDE's run feature):
  ```
  ./gradlew bootRun
  ```

4. Testing with Postman:
- Open Postman or a similar tool.
- Use HTTP requests to interact with the application:
  - To add an employee, send a POST request with JSON data to: `http://localhost:8888/emp/addEmp`. The JSON format should be structured like this:
    ```json
    {
        "id": 2,
        "name": "Naeem",
        "salary": 50000.0,
        "address": "Kannur",
        "department": "Software Engineering"
    }
    ```
  - To list all employees, send a GET request to: `http://localhost:8888/emp/getAll`.
  - To find an employee by ID, send a GET request to: `http://localhost:8888/emp/findEmp/{id}`.
  - To remove an employee by ID, send a DELETE request to: `http://localhost:8888/emp/removeEmp/{id}`.

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests. Your contributions are welcome!

