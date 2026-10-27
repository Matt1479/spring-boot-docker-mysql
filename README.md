# Spring Boot Docker MySQL

This project demonstrates how to containerize a Spring Boot application with a MySQL database using Docker Compose. It provides a REST API for creating, retrieving, updating, and deleting users.

Docker Compose Watch is configured to rebuild the `server` service when files in `src/` change.

## Getting Started

1. Ensure Docker is installed and running.
2. Configure your environment variables in `.env`.
3. Keep `.env` out of Git because it contains database credentials. Do not commit it to your repository.
4. Start the application:

```bash
docker compose up --build --watch
```

`docker compose up --build --watch` combines the following:

```bash
docker compose up --build
docker compose watch
```

The API will be available at [http://localhost:8080/api/users](http://localhost:8080/api/users).

## API Endpoints

Base path: `/api/users`

| Method    | Endpoint          | Description           | Success Status    |
|-----------|-------------------|-----------------------|-------------------|
| `POST`    | `/api/users`      | Create a user         | `201 Created`     |
| `GET`     | `/api/users`      | Get all users         | `200 OK`          |
| `GET`     | `/api/users/{id}` | Get a user by ID      | `200 OK`          |
| `PUT`     | `/api/users/{id}` | Update a user by ID   | `204 No Content`  |
| `DELETE`  | `/api/users/{id}` | Delete a user by ID   | `204 No Content`  |

### Request Body

For `POST /api/users` and `PUT /api/users/{id}`:

```json
{
  "name": "John",
  "email": "john@example.com"
}
```

`{id}` is the user's ID. Requests for a user that doesn't exist return `404 Not Found` if handled by the service as configured.

## Development

Check out the `dev` branch for the development setup using Spring Boot DevTools and Docker Compose Watch.

## Tech Stack

- Java 25
- Spring Boot 4.1.2
    - Spring Web
    - Spring Data JPA
    - MySQL Driver
    - Docker Compose Support
    - Testcontainers
