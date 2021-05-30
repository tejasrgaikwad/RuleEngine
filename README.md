# Business Rule Engine SpringBoot Version [0.0.1-SNAPSHOT]

## Introduction:

This is backend written in spring boot for decision-making based on business rules. 
Please see below details for how to run the project. 

### Requirements:
1. JDK 1.8^ (Runtime/compiler)
2. Maven 3.0^ (for running compilation script and creating artifact)
3. Intellij/Eclipse IDE(optional)


### How to start:
From cmd:
1. Go to spring boot project root directory from cmd [RuleEngine/]
2. Make sure you have java and maven executables in path
3. run command "mvn clean install" (to build the project and run test cases)
4. run below command to run the project:
   "java -jar target/rule-engine-xxxxx.jar" from target directory.


### Documentation of API:

After running the project, hit below url to access swagger docs
http://localhost:8080/swagger-ui.html


### Frameworks Used:
1. Spring Boot for Rest API
2. Drools Business Rule Engine


### Request Body :
######(Note: You can pass multiple products in one request using products array):
```json
{
  "productDetails": [
    {
      "name": "test book",
      "type": "book"
    },
    {
      "name": "test product",
      "type": "physical product"
    },
    {
      "name": "Learning to Ski",
      "type": "Video"
    }
  ],
  "serviceId": "payment"
}
```

### Expected Response as below for above request:
######(Note: actions object will contain the decision/answer from Rule Engine):
```json
{
  "serviceId": "payment",
  "productDetails": [
    {
      "name": "test book",
      "type": "book",
      "actions": [
        "create duplicate parking slip for the royalty department",
        "generate a commission payment to the agent"
      ]
    },
    {
      "name": "test product",
      "type": "physical product",
      "actions": [
        "generate a packing slip for shipping",
        "generate a commission payment to the agent"
      ]
    },
    {
      "name": "Learning to Ski",
      "type": "Video",
      "actions": [
        "Add Free 'First Aid Video' to Packing Slip"
      ]
    }
  ]
}
```