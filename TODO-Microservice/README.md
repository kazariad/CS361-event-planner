MICROSERVICE PROJECT FOR TODO DESKTOP APP

This microservice is implemented using Python and Flask to provide a Message of the Day (motd) and a version number for a desktop TODO application.

---------------
INSTRUCTIONS:
---------------
Requesting Data
---------------
- Message of the Day (motd) Endpoint:
    - Method: Get
    - URL: /motd
    - Example call:
![motd Example call](images/motd_call.png)

- Version Endpoint:
    - METHOD: GET
    - URL: /version
    - Example call:
![version Example call](images/version_call.png)

---------------
RECIEVING DATA
---------------
- motd Endpoint: 
    - Returns a random message from a list
- Version Endpoint:
    - Returns the current version of the microservice "v1.0.0"

---------------------
UML SEQUENCE DIAGRAM:
---------------------

![UML Sequence Diagram](images/uml.png)
