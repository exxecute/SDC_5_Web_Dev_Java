---
sidebar_position: 1
---

# The task

1. Create an interface for a repository (e.g., `BeverageRepository` or `CurrencyRepository`)
2. Implement two versions: one reading from JDBC, another from a file
3. Use `@Configuration` to switch between implementations based on a property
4. Demonstrate constructor injection in a service class
5. Create a bean with prototype scope and verify its behavior

## Deliverables

- Working Spring application with DI configuration
- Two repository implementations switchable via configuration

## Acceptance Criteria

- Application starts without errors
- Correct repository is injected based on configuration
- Prototype-scoped bean creates new instance on each request

## Extra Tasks

- Configure any bean to automatically perform initialization and destroy logic
- Fetch from an external API value used to configure one of repository


## Notes: 
Use spring (not spring boot), run via main method
Ignore slides about spring boot, mention in the presentation