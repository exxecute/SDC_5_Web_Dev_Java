---
sidebar_position: 1
---

# The task

1. Configure the application to connect to RabbitMQ
2. Implement a REST client to call an external API and process the response
3. Create a message producer that sends the processed response to a RabbitMQ queue
4. Implement a message consumer to read messages from the RabbitMQ queue and handle them appropriately

## Materials

1. [Spring RestClient Reference](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-restclient)
2. [Baeldung: Spring RestClient](https://www.baeldung.com/spring-boot-restclient)
3. [RabbitMQ Official Tutorials](https://www.rabbitmq.com/tutorials)
4. [CloudAMQP: RabbitMQ for Beginners](https://www.cloudamqp.com/blog/part1-rabbitmq-for-beginners-what-is-rabbitmq.html)
5. [Spring AMQP Reference](https://docs.spring.io/spring-amqp/reference/)

---

## Common Mistakes to Avoid

- **Not handling REST client errors** — external services can fail, always handle exceptions
- **Message not acknowledged** — unacked messages stay in queue, causing duplicates
- **RabbitMQ connection refused** — check if RabbitMQ is running and port is correct
- **Blocking in async context** — don't block message consumers with long operations

---

## Self-Check Questions

1. When would you use synchronous REST calls vs asynchronous messaging?
2. What is a message queue and why is it useful?
3. How does RabbitMQ routing work (exchanges, queues, bindings)?
4. What happens if a message consumer fails?
5. What are the benefits of observability in distributed systems?