# poc-springcloud-aws-sqs

Using: Java 11, Spring Boot, Spring Cloud, hexagonal architecture, MongoDB, AWS SQS

## To run the pub application, do:
1) browse to the directory: `poc-springcloud-aws-sqs\poc-spring-cloud-aws-sqs-pub`
2) execute the command: `mvn spring-boot:run`

## To run the sub application, do:
1) browse to the directory: `poc-springcloud-aws-sqs\poc-spring-cloud-aws-sqs-sub`
2) execute the command: `mvn spring-boot:run`
3) install Mongo with Docker: 
  a) browse to the directory: `poc-spring-cloud-aws-sns\src\main\resources`
  b) execute the command: `docker-compose up -d`

**IMPORTANT**: You need to create an SQS queue in your Amazon account and change the setting in the `TcpAwsSqsPersonAdapterIn.java` [class](https://github.com/juli0mendes/poc-springcloud-aws-sqs/blob/98be871ab682e21589dd6e1487ff7926539442ce/poc-spring-cloud-aws-sqs-sub/src/main/java/com/juli0mendes/pocsnssub/application/config/BrokerInput.java#L5).
