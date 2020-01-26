# Questionnaire App

The application which present a questionnaire for the user to fill out.

## GET 

   **Get list of all questions**
  ``` 
   /questionnaire
 ```
 where
   `userId=[string]`

GET Request example:
  ```
GET /questionnaire 
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
  ```

   **Get a single question by id**
  ``` 
   /questionnaire/{questionId}
 ```
 where
   `questionId=[int]`

GET Request example:
  ```
GET /questionnaire/2
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
  ```

   **Get all answers**
  ``` 
   /questionnaire/answers
 ```

GET Request example:
  ```
GET /questionnaire/answers
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
  ```
  
## PUT

   **Add or update an answer**
  ``` 
   /questionnaire/{questionId}/{answerId}
 ```
POST Request example:
  ```
POST /questionnaire/1/3
Host: localhost:8080
Content-Type: application/json
cache-control: no-cache

Body:
{1:3}
  ```

# Compile the project

  ```
  mvn clean install 
  ```
The app can be also start from IDE.
