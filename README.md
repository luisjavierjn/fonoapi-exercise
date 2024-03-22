# FONOAPI

This project use the H2 database and create tables & loads data from a file called data.sql located in the resources 
folder, the project has been dockerized, and it runs with the command "docker-compose up", coverage is above 90%. Three
controllers has been built addressing the following endpoints:

* GET "/api/v1/inventory"
* GET "/api/v1/inventory/devices" fonoapi to expose information for each phone
* GET "/api/v1/user"
* GET "/api/v1/req/types"
* GET "/api/v1/req" information available for each phone
* POST "/api/v1/req" service that allows a phone to be booked / returned
* DELETE "/api/v1/req/{id}"

**What aspect of this exercise did you find most interesting?**  


**What did you find most cumbersome?**  


## docker-compose up

![Forcing Dockerfile](./images/Screenshot%20from%202024-03-22%2003-33-56.png)  
![Spin up instance](./images/Screenshot%20from%202024-03-22%2003-34-14.png)  

## H2

![H2 Login Console](./images/Screenshot%20from%202024-03-22%2003-40-28.png)  
![H2 Database](./images/Screenshot%20from%202024-03-22%2003-40-59.png)  

## Endpoints

![Endpoint1](./images/Screenshot%20from%202024-03-22%2003-45-57.png)  
![Endpoint2](./images/Screenshot%20from%202024-03-22%2003-45-59.png)  
![Endpoint3](./images/Screenshot%20from%202024-03-22%2003-46-00.png)  
![Endpoint4](./images/Screenshot%20from%202024-03-22%2003-46-01.png)  
![Endpoint5](./images/Screenshot%20from%202024-03-22%2003-46-02.png)  
![Endpoint6](./images/Screenshot%20from%202024-03-22%2003-46-04.png)  
