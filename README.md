## Project Structure

```plaintext
CS7NS4-assign3
├── README.md                        # Project documentation
├── pom.xml                          # Maven project configuration
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org/tcd/cs7ns4
│   │   │       ├── AirQualityApplication.java   # Main application class
│   │   │       ├── controller
│   │   │       │   └── AirQualityController.java # REST API controller
│   │   │       ├── dto
│   │   │       │   └── AirQualityResponse.java   # Data transfer object for API response
│   │   │       ├── entity
│   │   │       │   └── AirQualityData.java       # Entity class for air quality data
│   │   │       ├── repository
│   │   │       │   └── AirQualityRepository.java # JPA repository for data storage
│   │   │       ├── scheduler
│   │   │       │   └── ScheduledTasks.java       # Scheduled tasks for data fetching
│   │   │       └── service
│   │   │           └── AirQualityService.java    # Service for handling data logic
│   │   └── resources
│   │       ├── application.properties            # Application configuration
│   │       ├── combined_sensor_data.csv          # data file from assignment2
│   │       ├── data.sql                          # SQL initialization data
│   │       └── import.py                         # Data import script
└── test
    └── java/org/tcd/cs7ns4
        └── Cs7ns4ApplicationTests.java           # Unit tests
```

## Setup Instructions


**Configure Database:**
   Ensure PostgreSQL is installed and running. Create a database named `cs7ns4_db`, and update `application.properties` with your database credentials.

**Modify API Token and Cities:**
    - Set the API token and list of cities in `application.properties`.
    - Example:
      ```properties
      airquality.api.token=YOUR_API_TOKEN
      airquality.cities=beijing,shanghai,guangzhou
      ```
**Run the Application:**
   ```bash
   ./mvnw spring-boot:run
   ```
   This command starts the Spring Boot application.

**Access the API Endpoints:**
    - Fetch air quality data for a specific city (e.g., `dublin`):
      ```bash
      curl -X GET "http://localhost:8080/api/airquality/dublin"
      ```

## Scheduled Task

Data is automatically fetched and saved every hour as per the configured schedule in `ScheduledTasks.java`. Adjust the schedule in `application.properties` if needed.

## Additional Information

- **Libraries Used:** Spring Boot, Spring Data JPA, HikariCP, PostgreSQL, Maven.
- **Test Cases:** Located under `src/test`.

## License

This project is licensed under the MIT License.
```

This format keeps it concise, organized, and easy to navigate.