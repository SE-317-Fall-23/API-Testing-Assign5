# Assignment 5
Write code and tests for a User Registration API service. 

## Requirements
Create three REST api to create, edit and read user registraion.
The api should match the specs in the API specs section below.
Use SprignBoot or any other framework.


### API Specs

Certainly, here are the API specifications for the POST route that creates a user:

#### **API Endpoint**: `/user`

**HTTP Method**: POST

**Description**: This API endpoint allows the creation of a new user by providing user registration details in the request body. Upon successful creation, it returns the newly created user's details as a JSON response.

The API should validate the inputs against the validation rules given in assignment 4. In addition you should ensure that usernames and emails are unique across all users.

The API should verify if the address is a real adddress by using an external api. You can use [Azure address validation](https://learn.microsoft.com/en-us/rest/api/billing/2019-10-01-preview/address/validate?tabs=HTTP).

The API should store the provided input in a CSV file. We are using the CSV file as a DB.


**Request Parameters**: None

**Request Body**:
- A JSON object containing user registration details. Here are the required fields:
  - `firstName` (string): The first name of the user.
  - `lastName` (string): The last name of the user.
  - `street` (string): The street address of the user.
  - `city` (string): The city of the user's address.
  - `state` (string): The state or province of the user's address.
  - `zip` (string): The ZIP or postal code of the user's address.
  - `country` (string): The country of the user's address.
  - `phone` (string): The phone number of the user.
  - `email` (string): The email address of the user.
  - `username` (string): The username chosen by the user.

Example Request Body:
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "street": "123 Main Street",
    "city": "City",
    "state": "State",
    "zip": "ZIP",
    "country": "Country",
    "phone": "555-123-4567",
    "email": "johndoe@example.com",
    "username": "johndoe123"
}
```

**Response**:
- **HTTP Status Code**: 201 (Created) - Successful user creation.
- **Response Body**: A JSON object (same structure as the request body) containing the details of the newly created user.

Example Response:
```json
{
    "id": "12345", // Unique user identifier
    "firstName": "John",
    "lastName": "Doe",
    "street": "123 Main Street",
    "city": "City",
    "state": "State",
    "zip": "ZIP",
    "country": "Country",
    "phone": "555-123-4567",
    "email": "johndoe@example.com",
    "username": "johndoe123"
}
```

- **HTTP Status Code**: 400 (Bad Request) - If the request is malformed or missing required fields.
- **Response Body**: An error message indicating the reason for the bad request.

Example Error Response:
```json
{
    "error": "Invalid request. Missing required field: 'lastName'."
}
```

This API endpoint expects a well-formed JSON object with user registration details in the request body. If the user creation is successful, it returns a 201 status code with the newly created user's details. If the request is malformed or missing required fields, it returns a 400 status code with an error message. The response includes the newly created user's unique identifier (`id`) for reference.

#### **API Endpoint**: `/user/{user-id}`

**HTTP Method**: GET

**Description**: This API endpoint retrieves user data from the CSV file based on the provided user ID and returns it as a JSON response.

**Request Parameters**:
- `{user-id}` (Path Parameter): The unique identifier of the user for whom you want to retrieve data.

**Response**:
- **HTTP Status Code**: 200 (OK) - Successful request.
- **Response Body**: A JSON object containing user data for the specified user.

Example Response:
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "street": "123 Main Street",
    "city": "City",
    "state": "State",
    "zip": "ZIP",
    "country": "Country",
    "phone": "555-123-4567",
    "email": "johndoe@example.com",
    "username": "johndoe123"
}
```

- **HTTP Status Code**: 404 (Not Found) - If the user with the specified `user-id` is not found.
- **Response Body**: An error message indicating that the user was not found.

Example Error Response:
```json
{
    "error": "User not found."
}
```

This API endpoint expects a user ID as a path parameter, and it returns a JSON object with the user's details. If the user ID is not found, it returns a 404 status code with an error message.

### Tests
* Include the unit tests from the previous assginment in this submission.
* Write tests for both routes
* Use a test double to test the intergration with the address validation service. I.e. write unit tests for the address validation service integration