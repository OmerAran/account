
# account project

This project is about account-customer-transaction relations.
I have followed [@folksdev](https://www.github.com/folksdev) current springboot web app development educational resource.
I have experienced RestAPI development, how to work with relationships between entities, logic of DTOs and converters, Unit Testing and Exception Handling. Thanks him for helping me improve myself.

## API Reference

#### Get Customer

```http
  GET  /v1/customer/{customerId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `customerId` | `string` | **Required**.|


#### Post create account request

```http
  POST /v1/account 
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `body`      | `createAccountRequest` | **Required**.|

```http
  body: createAccountRequest
  {
  "customerId" : "",
  "initialCredit" : ""
  }
```

| Parameter       | Type                      | Description         |
|:----------------|:--------------------------|:--------------------|
| `Authorization` | `InMemory Authentication` | **Admin and User**. |

```http
  Basic Auth: Get Customer By Id 
  {
  "username" : "user",
  "password" : "password"
  }
```
```http
  Basic Auth: Create Account Request
  {
  "username" : "admin",
  "password" : "password"
  }
```

## Lessons Learned

- Dto Logic and how to write dto converter
- Using kotlin in a SpringBoot Project
- Unit Testing
- InMemory Database
- Exception Handling and Validation (with default messages)
- InMemory Basic Authentication

## Tech Stack

**Server:** Java 11, Spring Boot, Spring Basic Authentication

**Client:** React - not added yet.




## 🔗 Links
[![portfolio](https://img.shields.io/badge/omeraran_cv-000?style=for-the-badge&logo=&logoColor=white)](https://omeraran.github.io/) 

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/omeraran)

## Authors

- [@omeraran](https://www.github.com/omeraran)


## Badges
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)



