# Recipe Book

# About

The Recipe Book web application is a JavaSpring-based platform that allows users to create, browse, and manage their personal recipe collection. The application offers the functionality of GET, POST, PUT, PATCH, and DELETE HTTP methods to allow users to interact with the database through the API.

Users can access recipes stored in the PostgreSQL database through GET requests, which retrieve information about recipes. Users can also add new recipes to the database using POST requests, while PUT to update whole recipe or PATCH to edit title of recipe, these request allow them to modify or update existing recipes as needed. Finally, DELETE requests allow users to remove recipes from the database.

The application's front-end interface was developed using Vue, allowing for a user-friendly and intuitive design. Overall, the Recipe Book web application offers a comprehensive and efficient way to manage recipe collections, with robust functionality and a modern, responsive interface.


## Build with

Spring Boot 

Maven

Lombok

Vue+Vite

Postgres


# Installation

1. Clone the rep

```git clone https://github.com/mmontii/recipe-book.git```

2. Downlaod and start PostgresSql on your local machine with following parameters:

```url: jdbc:postgresql://localhost:5432/postgres```
```username=postgres```
```password=postgres```

3. Build the Project 

```mvn clean package```

4. Start Java Spring Project

5. Start Vue Frontend (you need to downlaod npm for it)

```npm run dev```

