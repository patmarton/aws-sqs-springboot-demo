# aws-sqs-springboot-demo

Template project for connection Spring Boot application to AWS SQS, send and consume messages.

<b>Requirements</b>


    1. IntelliJ or other IDE with Spring Boot
    2. AWS Account with a single SQS set up
    3. AWS credentials (public + secret + session)
    4. Add AWS credentials to application.properties
    
  
<b>Steps</b>

    1. mvn spring-boot:run
    2. Message to the queue can be sent using the localhost:8080/send/{your message} endpoint
    3. The sqs listener will dequeue the message and write to stdout
