# Compact Disc Catalog API

## Overview

This project is a RESTful API for managing a catalog of compact discs (CDs). It provides CRUD operations for CDs and their associated tracks. The API is built using **Spring Boot**, with **JPA** for database interactions and **Swagger** for API documentation. The frontend includes several HTML pages demonstrating AJAX and Fetch API usage for interacting with the backend.

### Features
- RESTful endpoints for managing CDs and tracks.
- Integration with MySQL for persistent storage.
- Swagger UI for API documentation and testing.
- Example HTML pages showcasing AJAX and Fetch API usage.
- DataTables integration for dynamic table rendering.

---

## Architecture

The project follows a layered architecture:
1. **Controller Layer**: Handles HTTP requests and responses.
   - `CompactDiscController` provides RESTful endpoints.
2. **Service Layer**: Contains business logic.
   - `CompactDiscService` and its implementation `CompactDiscServiceImpl`.
3. **Repository Layer**: Interacts with the database using Spring Data JPA.
   - `CompactDiscRepository` for CRUD operations.
4. **Entity Layer**: Defines the database schema using JPA annotations.
   - `CompactDisc` and `Track` entities.

---

## Prerequisites

- **Java 11** or higher
- **Maven** for dependency management
- **MySQL** database
- **Node.js** (optional, for frontend development)

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd no-readme
```

### 2. Configure the Database
Update the database credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/conygre
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

### 3. Create the Database Schema
Run the SQL script located at `sql/createTables.sql` to create the necessary tables and seed initial data:
```bash
mysql -u <your-username> -p < sql/createTables.sql
```

### 4. Build the Project
Use Maven to build the project:
```bash
mvn clean install
```

### 5. Run the Application
Start the Spring Boot application:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

---

## Database Schema

### Tables
1. **compact_discs**
   - `id` (Primary Key, Auto Increment)
   - `title` (VARCHAR)
   - `artist` (VARCHAR)
   - `tracks` (INTEGER)
   - `price` (DOUBLE)

2. **tracks**
   - `id` (Primary Key, Auto Increment)
   - `cd_id` (Foreign Key referencing `compact_discs.id`)
   - `title` (VARCHAR)

### Sample Data
The `sql/createTables.sql` script includes sample data for testing purposes.

---

## API Endpoints

### Base URL
`http://localhost:8080/api/compactdiscs`

### Endpoints
| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| GET    | `/`                    | Retrieve all CDs               |
| GET    | `/{id}`                | Retrieve a CD by ID            |
| POST   | `/`                    | Add a new CD                   |
| DELETE | `/{id}`                | Delete a CD by ID              |

For detailed API documentation, visit the Swagger UI at `http://localhost:8080/swagger-ui.html`.

---

## Frontend Usage

### Available Pages
- **`index.html`**: Displays the CD catalog in a table format.
- **`listcds.html`**: Demonstrates AJAX-based dynamic table rendering.
- **`promisefetch.html`**: Uses the Fetch API to retrieve and display CD data.
- **`constructorfunctionajax.html`**: Demonstrates object-oriented JavaScript with AJAX.

### Running the Frontend
The HTML files are located in `src/main/resources/static`. Open them in a browser to interact with the API.

---

## Logging

The application uses **Log4j2** for logging. Logs are written to `myapplication.log` as configured in `log4j2.properties`.

---

## Testing

### Unit Tests
- The project includes unit tests for the service and repository layers.
- Use the following command to run tests:
```bash
mvn test
```

### Postman Collection
- Use the provided REST files (`rest/postcd.rest`, `rest/deletecd.rest`) to test the API endpoints.

---

## Deployment

### Docker
1. Build the Docker image:
   ```bash
   docker build -t compact-disc-api .
   ```
2. Run the container:
   ```bash
   docker run -p 8080:8080 compact-disc-api
   ```

### Cloud Deployment
- The application can be deployed to cloud platforms like AWS, Azure, or Google Cloud using their respective deployment tools.

---

## Contribution Guidelines

1. Fork the repository and create a new branch for your feature or bug fix.
2. Write clear and concise commit messages.
3. Ensure all new code is covered by unit tests.
4. Submit a pull request with a detailed description of your changes.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contact

For questions or support, contact **Nick Todd** at [nick.todd@conygre.com](mailto:nick.todd@conygre.com).
