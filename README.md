# social-net-app
Simple social networking application, similar to Twitter. 
The application supports the scenarios below.

path ="/user" method GET - return all users

path ="/user" method POST - creates a user

path ="/user/{id}" method GET - get all messages posted by user in reverse chronological order

path ="/user/{id}" method POST - post a 140 character message

path ="/user/{id}/followed" method GET - get all messages posted by all the people followed by user in reverse chronological order

path ="/user/{id}/followed/{toBeFollowedId}" method POST - user adds another user to followed
