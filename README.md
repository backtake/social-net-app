# social-net-app

Simple social networking application, similar to Twitter. 
The application supports the scenarios below.

-  **path ="/user" method GET** - return all users

-  **path ="/user" method POST** - creates a user

-  **path ="/user/{id}" method **GET** - get all messages posted by user in reverse chronological order

-  **path ="/user/{id}" method POST** - post a 140 character message

-  **path ="/user/{id}/followed" method GET** - get all messages posted by all the people followed by user in reverse chronological        order

- **path ="/user/{id}/followed/{toBeFollowedId}" method PUT** - user adds another user to followed


# how to run it?

-  build a jar file using:
```
mvn package
```
-  run it with: 
```
java -jar target/social-net-app-0.0.1-SNAPSHOT.jar
```
