
# SpringBootSecuringApis

This project is a Spring Boot application focused on securing APIs with role-based access control (RBAC). It demonstrates how to implement security measures such as authentication, authorization, and JWT integration.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- An IDE such as IntelliJ IDEA
- Postman (or any other API testing tool)

### Running the Project
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Open the terminal and run the following Maven command to build and run the application:
   ```bash
   mvn spring-boot:run
   ```
4. The application will start on `http://localhost:8080`.

### Testing the APIs
1. To test the secured API endpoints, use Postman or any API testing tool.
2. Example of testing with Postman:
   - Set the request method (GET/POST/etc.) and the URL (e.g., `http://localhost:8080/api/resource`).
   - For secured endpoints, add the necessary authentication headers (Basic Auth or JWT Token).
   - Send the request and verify the response.
