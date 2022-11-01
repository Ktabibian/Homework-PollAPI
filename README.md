# Homework-PollAPI
```
POST http://localhost:8080/polls
```
```
INPUT {
 "question": "Who will win SuperBowl this year?",
 "options": [
 {"value": "New England Patriots"},
 {"value": "Seattle Seahawks"},
 {"value": "Green Bay Packers"},
 {"value": "Denver Broncos"}]
}
```
```
GET http://localhost:8080/polls
```
```
OUTPUT[
    {
        "id": 1,
        "question": "Who will win SuperBowl in 2015?",
        "options": [
            {
                "id": 1,
                "value": "New England Patriots"
            },
            {
                "id": 2,
                "value": "Seattle Seahawks"
            },
            {
                "id": 3,
                "value": "Green Bay Packers"
            },
            {
                "id": 4,
                "value": "Denver Broncos"
            }
        ]
    }
]
```
```
PUT http://localhost:8080/polls/1
```
```
INPUT {
    "id": 1,
    "question": "Who will win SuperBowl in 2015?",
    "options": [
        {"id": 1, "value": "New England Patriots"},
        {"id": 2, "value": "Seattle Seahawks"},
        {"id": 3, "value": "Green Bay Packers"},
        {"id": 4, "value": "Denver Broncos"}]
}
```
```
POST http://localhost:8080/polls/1/votes
```
```
INPUT {
    "option": {"id": 1, "value": "New England Patriots"}
}
```
```
GET http://localhost:8080/computeresult?pollId=1
```
```
OUTPUT {
    "totalvalues": 2,
    "results": [
        {
            "optionId": 1,
            "count": 2
        }
    ]
}
```
```
GET http://localhost:8080/polls/100
```
```
OUTPUT {
    "title": "Resource Not Found",
    "status": 404,
    "detail": "Poll with id 100 not found",
    "timeStamp": 1667329794333,
    "path": null,
    "developerMessage": "com.apress.quickpoll.exception.ResourceNotFoundException",
    "errors": {}
}
```
```
POST http://localhost:8080/polls
```
```
INPUT {
    "options": [
 {"value": "New England Patriots"},
 {"value": "Seattle Seahawks"},
 {"value": "Green Bay Packers"},
 {"value": "Denver Broncos"}]
}
```
```
OUTPUT {
    "title": "Validation Failed",
    "status": 400,
    "detail": "Input validation failed",
    "timeStamp": 1667329856395,
    "path": null,
    "developerMessage": "org.springframework.web.bind.MethodArgumentNotValidException",
    "errors": {
        "question": [
            {
                "code": "NotEmpty",
                "message": "Question is a required field"
            }
        ]
    }
}
```
```
POST http://localhost:8080/polls
```
```
INPUT {
 "question": "Who will win SuperBowl this year?",
 "options": [
 {"value": "New England Patriots"},
 {"value": "Seattle Seahawks"}
 {"value": "Green Bay Packers"},
 {"value": "Denver Broncos"}]
}
```
```
OUTPUT {
    "title": "Message Not Readable",
    "status": 400,
    "detail": "JSON parse error: Unexpected character ('{' (code 123)): was expecting comma to separate Object entries; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Unexpected character ('{' (code 123)): was expecting comma to separate Object entries\n at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 6, column: 3] (through reference chain: com.apress.quickpoll.domain.Poll[\"options\"]->java.util.HashSet[1])",
    "timeStamp": 1667328981850,
    "path": null,
    "developerMessage": "org.springframework.http.converter.HttpMessageNotReadableException",
    "errors": {}
}
```
