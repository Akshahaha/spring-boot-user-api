# spring-boot-user-api

This project implements a simple heart monitor application with user registration, patient management, and heart rate data recording.

## Setup Instructions

1.  **Prerequisites:**
    *   Java Development Kit (JDK) 17 or later.
    *   Apache Maven (version 3.6.3 or later).
    *   MySQL database server.
    *   Git (for cloning the repository).

2.  **Clone the Repository:**

    ```bash
    git clone [repository URL]
 
    ```

3.  **Configure the Database:**

    *   Create a MySQL database named `heart_rate_monitor`.
    *   Update the `src/main/resources/application.properties` file with your database connection details:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/heartmonitor?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update
        ```

        Replace `your_username` and `your_password` with your actual MySQL username and password. The `ddl-auto=update` property will automatically create the database tables based on your entity classes.

4.  **Build and Run the Application:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The application will start on port 8080.



## API Documentation

### 1. User Registration

*   **Endpoint:** `/api/users/register`
*   **Method:** POST
*   **Request Body:**

    ```json
    {
        "email": "user@example.com",
        "password": "password123"
    }
    ```

*   **Response Body (Success):**

    ```json
    {
        "id": 1,
        "email": "user@example.com"
    }
    ```

### 2. User Login

*   **Endpoint:** `/api/users/login`
*   **Method:** POST
*   **Request Body:**

    ```json
    {
        "email": "user@example.com",
        "password": "password123"
    }
    ```

*   **Response Body (Success):**

    ```json
    {
        "message": "Login successful",
        "user": {
            "id": 1,
            "email": "user@example.com"
        }
    }
    ```

*   **Response Body (Failure):**

    ```json
    {
        "message": "Invalid email or password"
    }
    ```

### 3. Add Patient

*   **Endpoint:** `/api/patients`
*   **Method:** POST
*   **Request Body:**

    ```json
    {
        "name": "John Doe",
        "age": 50,
        "userId": 1
    }
    ```

*   **Response Body (Success):**

    ```json
    {
        "id": 1,
        "name": "John Doe",
        "age": 50,
        "user": {
            "id": 1,
            "email": "user@example.com"
        }
    }
    ```

### 4. Get Patient

*   **Endpoint:** `/api/patients/{id}`
*   **Method:** GET
*   **Path Variable:** `id` (Patient ID)
*   **Response Body (Success):**

    ```json
    {
        "id": 1,
        "name": "John Doe",
        "age": 50,
        "user": {
            "id": 1,
            "email": "user@example.com"
        }
    }
    ```

### 5. Get All Patients

*   **Endpoint:** `/api/patients`
*   **Method:** GET
*   **Response Body (Success):**

    ```json
    [
        {
            "id": 1,
            "name": "John Doe",
            "age": 50,
            "user": {
                "id": 1,
                "email": "user@example.com"
            }
        },
        {
            "id": 2,
            "name": "Jane Smith",
            "age": 60,
            "user": {
                "id": 1,
                "email": "user@example.com"
            }
        }
    ]
    ```

### 6. Record Heart Rate

*   **Endpoint:** `/api/heart-rates`
*   **Method:** POST
*   **Request Body:**

    ```json
    {
        "heartRate": 72,
        "patientId": 1
    }
    ```

*   **Response Body (Success):**

    ```json
    {
        "id": 1,
        "patient": {
            "id": 1,
            "name": "John Doe",
            "age": 50
        },
        "heartRate": 72,
        "timestamp": "2025-02-18T12:00:00"
    }
    ```

### 7. Get Heart Rate

*   **Endpoint:** `/api/heart-rates/{id}`
*   **Method:** GET
*   **Path Variable:** `id` (Heart Rate ID)
*   **Response Body (Success):**

    ```json
    {
        "id": 1,
        "patient": {
            "id": 1,
            "name": "John Doe",
            "age": 50
        },
        "heartRate": 72,
        "timestamp": "2025-02-18T12:00:00"
    }
    ```

### 8. Get Heart Rates by Patient

*   **Endpoint:** `/api/heart-rates/patient/{patientId}`
*   **Method:** GET
*   **Path Variable:** `patientId` (Patient ID)
*   **Response Body (Success):**

    ```json
    [
        {
            "id": 1,
            "patient": {
                "id": 1,
                "name": "John Doe",
                "age": 50
            },
            "heartRate": 72,
            "timestamp": "2025-02-18T12:00:00"
        },
        {
            "id": 2,
            "patient": {
                "id": 1,
                "name": "John Doe",
                "age": 50
            },
            "heartRate": 75,
            "timestamp": "2025-02-18T12:15:00"
        }
    ]
    ```

## Additional Information


### Future Improvements

*   Implement Spring Security for authentication and authorization.
*   Add input validation using JSR 303 annotations.
*   Implement more robust error handling.
*   Implement test cases for the application.
*   Add a REST client to show results in graph.

