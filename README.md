# REST API application

## Install and Run

 ./gradlew bootRun

## dependencies

    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	runtimeOnly 'mysql:mysql-connector-java'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'

# REST API

The REST API is part of a test an the app is described below.


## Get all guests.

### Request

`GET /guest/all/`

    http://localhost:8080/guest/all

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": [
            {
                "id": 0,
                "firstName": "Luis",
                "lastName": "Hernandez",
                "email": "hernandezldm@gmail.com",
                "phone": "+584124172840",
                "address": "Valencia",
                "comment": ""
            },
            {
                "id": 18,
                "firstName": "Alondra",
                "lastName": "Dominguez",
                "email": "alondraDominguez@gmail.com",
                "phone": null,
                "address": "valencia",
                "comment": ""
            }
        ]
    }

## Get all guests with a name o lastName contaning.

### Request

`GET /guest/name/{nameOrLastName}`

    http://localhost:8080/guest/name/nd

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": [
        {
            "id": 0,
            "firstName": "Luis",
            "lastName": "Hernandez",
            "email": "hernandezldm@gmail.com",
            "phone": "+584124172840",
            "address": "Valencia",
            "comment": ""
        },
        {
            "id": 18,
            "firstName": "Alondra",
            "lastName": "Dominguez",
            "email": "alondraDominguez@gmail.com",
            "phone": null,
            "address": "valencia",
            "comment": ""
        },
  
    ]
}

## Get all reservations.

### Request

`GET /reservation/all/`

    http://localhost:8080/reservation/all

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "reservations": [
            {
                "id": 1,
                "guestId": 18,
                "from": "2021-11-03",
                "to": "2021-11-03",
                "comment": "",
                "created": "2021-10-03 21:49:48",
                "updated": "2021-10-03 21:49:48"
            },
            {
                "id": 12,
                "guestId": 0,
                "from": "2021-10-14",
                "to": "2021-10-14",
                "comment": "",
                "created": "2021-10-03 14:11:02",
                "updated": "2021-10-03 14:11:02"
            }
        ]
    }

## Get if the reservation is available.

### Request

`GET /reservation/check/{startDate}/{endDate}`

    http://localhost:8080/reservation/check/2021-10-27/2021-10-27

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": {
        "available": true,
        "from": "2021-10-27",
        "to": "2021-10-27"
        }
    }

## Get a specific reservation.

### Request

`GET /reservation/{id}/`

    http://localhost:8080/reservation/1675

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": {
        "id": 1675,
        "guestId": 18,
        "from": "2021-11-03",
        "to": "2021-11-03",
        "comment": "",
        "created": "2021-10-03 21:49:48",
        "updated": "2021-10-03 21:49:48"
        }
    }

## Create a guest.

### Request

`POST /guest/create/`

    http://localhost:8080/guest/create

    {
    "header": null,
    "data": {
        "firstName": "JR",
        "lastName": "Paez",
        "email": "ssadasd@gmail.com",
        "phone": "34567890",
        "address": "valencia",
        "comment": ""
        }
    }

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": {
        "id": 34,
        "firstName": "JR",
        "lastName": "Paez",
        "email": "ssadasd@gmail.com",
        "phone": "34567890",
        "address": "valencia",
        "comment": ""
        }
    }   

## Create a reservation with a specific guest.

### Request

`POST /reservation/create`

    http://localhost:8080/reservation/create

    {
    "header": null,
    "data": {
        "guestId": 0,
        "from": "2021-10-27",
        "to": "2021-10-27",
        "comment": ""
        }
    }

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": "You are booked already."
    },
    "error": null,
    "data": {
        "id": 37,
        "guestId": 0,
        "from": "2021-10-27",
        "to": "2021-10-27",
        "comment": null,
        "created": null,
        "updated": null
        }
    }

## Create a reservation with a new guest.

### Request

`POST /reservation/create-new-guest`

    http://localhost:8080/reservation/create-new-guest

    {
    "header": null,
    "data": {
        "firstName": "New",
        "lastName": "Guest",
        "email": "newguest@gmail.com",
        "phone": "123456788",
        "address": "Canada",
        "from":"2021-11-01",
        "to":"2021-11-01",
        "comment": "i hope so"
        }
    }

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": {
        "id": 39,
        "guestId": 38,
        "from": "2021-11-01",
        "to": "2021-11-01",
        "comment": "i hope so",
        "created": null,
        "updated": null
        }
    }

## Update a specific reservation.

### Request

`PUT /reservation/update`

    http://localhost:8080/reservation/update

    {
    "header": null,
    "data": {
        "id":1,
        "guestId": 18,
        "from": "2021-11-02",
        "to": "2021-11-02",
        "comment": ""
        }
    }

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": {
        "id": 1,
        "guestId": 18,
        "from": "2021-11-02",
        "to": "2021-11-02",
        "comment": "",
        "created": null,
        "updated": null
        }
    }

## Attempt to change a Thing using partial params

### Request

`DELETE /reservation/delete/{id}`

    http://localhost:8080/reservation/delete/0

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Content-Type: application/json

    {
    "header": {
        "result": "SUCCESS",
        "detail": null
    },
    "error": null,
    "data": {
        "id": 0,
        "guestId": null,
        "from": null,
        "to": null,
        "comment": null,
        "created": null,
        "updated": null
        }
    }
