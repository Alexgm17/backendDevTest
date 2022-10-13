# backendDevTest technical test


This project has been carried out as part of a technical test. Next, it will be detailed what it consists of and the approach that has been taken into account for its development.

### Table of contents
* [What is the project about?](https://github.com/Alexgm17/backendDevTest#what-is-the-project-about-?)
* [What structure has been applied?](https://github.com/Alexgm17/backendDevTest#what-structure-has-been-applied-?)
* [Implemented peculiarities](https://github.com/Alexgm17/backendDevTest#implemented-peculiarities)
* [Testing results](https://github.com/Alexgm17/backendDevTest#testing-results)

## What is the project about?


For this case, it was necessary to develop an intermediate REST API that would consume two endpoints of other existing APIs.
[Here](https://github.com/Alexgm17/backendDevTest/blob/main/src/main/resources/doc/openapi/api-definition.yml) is the agreed contract for our API.


On the one hand, our new API makes a call to the endpoint that returns the product ids similar to the product id that we received in the request.
Once the list of ids of products similar to ours is obtained, a request is made for each id of the list to the second endpoint, which will return the details of the product (id, name, price, availability).


Once this information is obtained, the new service developed will return a list of the details of products similar to the id of the product that it receives by request.

![](D:\Projects\backendDevTest\backendDevTest\src\main\resources\images\diagram.jpg)

## What structure has been applied?


For the development of this application, the DTO pattern has been implemented, in order to be able to work more comfortably with the input/output objects that it will receive.

The package structure followed is based on the basic organization, starting from a main package called "products", from which two packages arise, "controller" and "service". The latter contains different packages, grouped by functionality.

## Implemented peculiarities

The [open api generator plugin](https://mvnrepository.com/artifact/org.openapitools/openapi-generator-maven-plugin) has been incorporated into the project, which facilitates development, auto generating the interface of the different operations that the API may contain,
which will later be implemented by the controllers, as well as the DTO object that will be returned.

## Testing results


After the execution of the tests, here you can see the results of the different requests:

- Test execution

```
docker-compose run --rm k6 run scripts/test.js
```

![](D:\Projects\backendDevTest\backendDevTest\src\main\resources\images\test-execution.PNG)

- Grafana tests results

http://localhost:3000/d/Le2Ku9NMk/k6-performance-test 

![](D:\Projects\backendDevTest\backendDevTest\src\main\resources\images\grafana-test-result.PNG)