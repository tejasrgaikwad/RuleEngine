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
    serviceId: "Payment",
    products: [
        {
            type:"video",
            name:"Learning to Ski"
        }
    ]
}
```

### Expected Response as below for above request:
######(Note: actions object will contain the decision/answer from Rule Engine):
```json
{
  serviceId: "Payment",
  products:[
    {
        type: "Physical",
        name: "Test",
        actions: [
              "Upgrade membership",
              "Send Email notification"
        ]
    }
  ]
}

```