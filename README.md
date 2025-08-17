# Profile Matcher

Profile Matcher is a Spring Boot application that solves the "Profile Matcher" problem proposed by Gameloft Barcelona. It matches user profiles to game campaigns using a RESTful API.

## Technologies Used

- Java 21
- Spring Boot
- H2 Database
- Maven
- IntelliJ IDEA

## Getting Started

1. **Clone the repository:**

```
git clone https://github.com/andrew-smalls/profile-matcher.git
```
2. **Navigate to the project directory and build:**
```
cd profile-matcher mvn clean install
```
3. **Run the application:**
```
mvn spring-boot:run
```

## Usage

Test the API using Postman or a browser:
```
GET http://localhost:4040/get_client_config/97983be2-98b7-11e7-90cf-082e5f28d836
```
![2023-11-13 06_33_01-get_client_config - My Workspace](https://github.com/andrew-smalls/profile-matcher/assets/78035090/c479b426-a781-4585-835c-d475530c26e4)

## Project Structure

- Entry point: `ProfileMatcherApplication` in `src/main/java/com/andrei/profilematcher/`
- In-memory H2 database for development and testing

## License

This project is for demonstration purposes.

