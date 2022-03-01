# kotlin-service

## Requirements 
Java 16

## How to run
`./gradlew bootRun`

## Endpoints

| URL       | Description   |
|-----------|---------------|
| http://localhost:8080/ | Simple endpoint with mustache |
| http://localhost:8080/ping | Ping          |


## Done

1. Dependabot integration with PRs raised for issues
2. CircleCI
3. Ping endpoint - test with `WebTestClient`
4. Controller with mustache template - test with `TestRestTemplate`


## Todo

1. Controller with wiremock / RestAssured
2. Endpoint talking to simple R2DBC
3. Swagger 
4. Test cases with simple Spring webtest
5. 
   1. Test cases with WebTestClient
   2. Test cases with RestAssured
   3. Swagger documentation
   4. Flyway to build and populate the database
   5. 
