# Deeper task

This is a simple Spring Boot application which serves two REST API requests.

One is a public endpoint, which accepts as an input information about a square and a line and returns information where and if these two objects intersect.

Second one is a username and password protected endpoint, which returns information about how many requests are currently being processed by the application.

## How to launch the application

Open a terminal window. Go into 'task' directory of this project and type the following commands into the terminal:

```shell
mvn clean install
mvn spring-boot:run
```

## Usage

**Intersection checking endpoint** accepts POST request with information about a square and a line. Example input and output can be found bellow.

Input:

```javascript
{
  "square" : {
    "side" : 5,
    "x" : 1,
    "y" : 1
  },
  "line" : {
    "x1" : 3,
    "y1" : 0,
    "x2" : 3,
    "y2" : 15
  }
}
```

Output:

```javascript
{
    "intersect": true,
    "intersectionPoints": [
        {
            "x": 3,
            "y": 1
        },
        {
            "x": 3,
            "y": 6
        },
        null,
        null
    ]
}
```

*intersectionPoints* is an array of 4 Point objects, which contain coordinates where the objects intersect. Points in array represent intersected rectangle sides in a following sequence: top, bottom, left, right.

**Active requests endpoint** can be reached with GET method, but it is protected with Basic Authentication, so it should include username and password (username: admin, password: secret). The response will contain one field *activeRequests*, which shows how many requests are currently being processed by this application (including this request).
