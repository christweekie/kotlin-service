# kotlin-service

## Requirements 
Java 18

## How to run
`./gradlew bootRun`

## Endpoints

| URL       | Description                   |
|-----------|-------------------------------|
| http://localhost:8080/ | Simple endpoint with mustache |
| http://localhost:8080/swagger-ui/index.html | Swagger |
| http://localhost:8080/ping | Ping   |
| http://localhost:8080/api/article/ | REST call for all |
| http://localhost:8080/api/user/ | REST call for users |
| http://localhost:8080/api/article/reactor-bismuth-is-out | REST call                     |


## Done

1. Dependabot integration with PRs raised for issues
2. CircleCI
3. Ping endpoint - test with `WebTestClient`
4. Controller with mustache template - test with `TestRestTemplate`
5. REST controller - test with MockMvc
6. Swagger
7. WebMvcTest - lightweight test on controller with MockMvc


## Todo

1. Controller with wiremock / RestAssured
2. Endpoint talking to simple R2DBC
3. Test cases with simple Spring webtest
4. Build docker image and push to repo
5. Properties - with CSV to list
6. Junit 5 various tests
