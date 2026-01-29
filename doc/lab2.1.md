# Lab 2: Part 1 — Spring Boot

## Objective

Migrate an existing Spring Core application to Spring Boot

## Tasks

1. Convert the existing Spring application to use Spring Boot:
    - Add Spring Boot parent POM and starter dependencies
    - Create a main class annotated with `@SpringBootApplication`
2. Replace XML or Java-based configuration with Spring Boot auto-configuration where applicable
3. Add and apply `application.yaml` or `application.properties` file for externalized configuration
4. Verify the application starts correctly using the embedded server

## Deliverables

- A working Spring Boot application with `@SpringBootApplication` entry point
- Externalized configuration in `application.yml` or `application.properties`

## Acceptance Criteria

- Application migrated to Spring Boot
- All existing functionality remains intact after migration
- Application starts without errors on the default (8080) or on a redefined port


## Materials

1. [start.spring.io](https://start.spring.io)
2. [Spring Boot Reference - Features](https://docs.spring.io/spring-boot/reference/features/index.html)
3. [Marco Behler: How Spring Boot Auto-Configuration Works](https://www.marcobehler.com/guides/spring-boot)
4. [Baeldung: @ConfigurationProperties Guide](https://www.baeldung.com/configuration-properties-in-spring-boot)
5. [Baeldung: @Value Annotation](https://www.baeldung.com/spring-value-annotation)

---

## Common Mistakes to Avoid

- **Wrong YAML indentation** — YAML is sensitive to spaces, use consistent indentation
- **Missing @EnableConfigurationProperties** — required when using @ConfigurationProperties
- **Profile not activated** — check `spring.profiles.active` in config or CLI
- **@Value with missing property** — application fails to start if property doesn't exist (use default values)

---

## Self-Check Questions

1. What does `@SpringBootApplication` combine?
2. What is the difference between `@Value` and `@ConfigurationProperties`?
3. How do you activate a specific profile?
4. What is auto-configuration and how does it work?
5. How do you override a property for a specific profile?
