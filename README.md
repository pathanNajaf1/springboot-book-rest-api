# Spring Boot Book REST API

A simple RESTful API built using Spring Boot that performs CRUD operations for managing books.

This project was created while learning Spring Boot fundamentals and REST API development.

## Features

- Get all books
- Get book by ID
- Add new book
- Update existing book
- Delete a book

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Maven

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /books | Get all books |
| GET | /books/{id} | Get book by ID |
| POST | /books | Add a new book |
| PUT | /books/{bookid} | Update a book |
| DELETE | /books/{bookid} | Delete a book |

## Example Request (POST)

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin"
}
