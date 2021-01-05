# Flask-todo-app

Springboot application to create a todo application with spring security which keeps track of the todos separately as completed and incomplete todos. tech - springboot, java

In this challenge you are supposed to create a todo application 
where the user can add notes and after completing the certain task can mark it as completed.

Follow the following instructions to complete the application:

MODELS:

The application has 2 models named user and notes with the following fields and types:
1. User: -------> id(Int), username(String), userEmail(String), password(String).
2. Notes : -------> id(Int), text(String),is_completed(Boolean), user_id(foriegn key)

ENDPOINTS: 
1. /register  ---> This endpoint is used to register a user to the system.
- request - User data - id, username, userEmail, password
- response - "User registered successfully", HttpStatus.CREATED

2. /login  ----> This endpoint is used to login to the system.
- response - "logged into user successfully", HttpStatus.ok


3. /logout ----> This endpoint is used to logout of the system.
- response - "logged out successfully", HttpStatus.ok

4. /add    ----> This endpoint is used to create a new note. The 
note should be added to the current logged in user.

- request - Notes data - id, text, is_completed
- response - Get the added notes data in JSON format, HttpStatus.OK
Error message - "log in to user to add note"

{
    "id": 101,
    "text": "springboot",
    "is_completed": false
}


5. /user/{id} --> This endpoint is used to get the user data by it ID.
- request - id
- response - user data in JSON format, Httpstatus.OK

{
    "id": 1,
    "username": "jonty",
    "userEmail": "jonty@gmail.com",
    "password": "rhodes",
    "notes": [
        {
            "id": 101,
            "text": "springboot API'S",
            "is_completed": false
        },
        {
            "id": 103,
            "text": "API'S",
            "is_completed": false
        }
    ]
}


6. /complete/{id} ----> This endpoint is used to mark a particular task as complete by altering the boolean field in the model. 

- request - note id
- response - Edited Notes data in JSON format, HttpStatus.OK

{
    "id": 101,
    "text": "springboot",
    "is_completed": true
}


7. /delete/task/<id> -----> This endpoint is used to delete task with that particular id. User has to login to delete a note.

- request - note id
- response - "Note deleted successfully",  HttpStatus.OK
Error message - "Note with the given ID not found", HttpStatus.BAD_REQUEST

8. /all/tasks ----> This endpoint is used to return all the tasks by current logged in user.


[
    {
        "id": 101,
        "text": "springboot API'S",
        "is_completed": false
    },
    {
        "id": 102,
        "text": "REST API'S",
        "is_completed": true
    }
]


- response - Get all notes of current logged in user in JSON format, HttpStatus.OK

9. /completed/tasks ----> This endpoint is used to return all the completed tasks by current logged in user.

- response -  Get all notes of current logged in user in JSON format whose tasks are completed (is_completed = true), HttpStatus.OK


[
    {
        "id": 101,
        "text": "springboot API'S",
        "is_completed": true
    },
    {
        "id": 102,
        "text": "REST API'S",
        "is_completed": true
    }
]


10. /incomplete/tasks ----> This endpoint is used to return all the incomplete tasks by the logged in user.

- response -  Get all notes of current logged in user in JSON format whose tasks are incomplete (is_completed = false), HttpStatus.OK



[
    {
        "id": 101,
        "text": "springboot API'S",
        "is_completed": false
    },
    {
        "id": 102,
        "text": "REST API'S",
        "is_completed": false
    }
]



