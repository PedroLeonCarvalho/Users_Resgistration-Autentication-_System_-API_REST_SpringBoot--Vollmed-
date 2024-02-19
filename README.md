
## Registration System
Implements a registration for doctors and pacients, save it in Postgres and has endpoints for Front-End uses. It has a Figma Design  front-end avaible for mobile.


## Technologies Used

- **REST API**: Implementation of a RESTful API for communication between the frontend and backend of the system.
- **Spring Boot**: Usage of the Spring Boot framework for rapid and easy development of Java applications.
    - **Spring Security**: used for authentication of users.  
    - **Spring Web**: Spring module for creating web applications.
    - **Bean Validation**: Use of bean validations to validate input data.
    - **Spring Data JPA**: Integration of Spring Boot with JPA for data access.
- **MySQL**: Relational database used for storing system data.
- **Flyway**: Utilization of Flyway to manage and control the database evolution history through migrations.
- **Lombok**: Use of Lombok to simplify the creation of Java classes with automatic getters and setters through annotations.
- **Spring Initializer**: Tool used to initialize Spring Boot projects easily.
- **Maven**: Dependency manager used to manage project dependencies.
- **JWT**: Java Web Token for Stateless access controll

## Key Features

- **Patient Registration**: Ability to register new patients in the system, with validations to ensure data integrity.
- **Appointment Scheduling**: Functionality to schedule medical appointments, allowing doctors and patients to manage their schedules easily and intuitively.
- **Consultation Management**: Possibility to view, edit, and cancel scheduled appointments, providing flexibility for doctors and patients.
- **Database Access**: MySQL database access configurations, ensuring a secure and efficient connection to the data storage system.
