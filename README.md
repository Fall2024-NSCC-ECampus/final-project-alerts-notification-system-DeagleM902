# Alerts Notification System
The Alerts Notification System is a Spring Boot application designed to manage and retrieve data for emergency services. It provides RESTful API endpoints for fire station information, household and resident information, and emergency alerts.  
This application includes sample data in an H2 in-memory database.
## API Endpoints
### 1. Fire Station API
```GET /firestation?stationNumber=<station_number>```
Retrieves a list of people served by the given fire station, including first name, last name, address, and phone number. Provides a summary of the number of adults and children.
### 2. Child Alert API
```GET /childAlert?address=<address>```
Returns a list of children (under 18 years) at a given address. Includes each child’s name, age, and a list of other individuals living at the address.
### 3. Phone Alert API
```GET /phoneAlert?firestation=<station_number>```
Returns the names and phone numbers of people within the fire station’s jurisdiction.
### 4. Community Email API
```GET /communityEmail?city=<city>```
Returns the names and email addresses of all individuals residing in a given city.
### 5. Person Information API
```GET /personInfo?firstName=<firstName>&lastName=<lastName>```
Retrieves details about a person, including their name, address, age, email, medications, and allergies. Returns all matches if multiple people share the same name.
## Database information
The H2 database can be accessed at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  

Credentials:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave blank)
