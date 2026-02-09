---
sidebar_position: 1
---

# The task

Lab 2: Part 2 — Database Configuration

## Objective

Configure database connectivity and implement the data access layer with multiple implementation strategies using Spring profiles.

## Tasks

1. Configure the application to use a relational database (e.g., PostgreSQL, H2)
2. Create a DAO interface with standard CRUD operations
3. Implement the DAO using JDBC from Java standard library
4. Implement the DAO using Spring's `JdbcTemplate`
5. Create two Spring profiles (`jdbc` and `jdbctemplate`) to switch between implementations

## Deliverables

- DAO interface and two implementations (JDBC and JdbcTemplate)
- Profile-specific configuration for database and DAO selection

## Acceptance Criteria

- Application connects to the database successfully
- CRUD operations work correctly with both DAO implementations
- Switching profiles changes the active DAO implementation without code changes

## Extra Tasks

- Configure HikariCP connection pool with custom settings
- Add a third `JdbcClient` implementation of DAO with a corresponding `jdbcclient` profile

## Materials

1. [Oracle JDBC Tutorial](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
2. [Baeldung: Introduction to HikariCP](https://www.baeldung.com/hikaricp)
3. [Baeldung: Spring JdbcTemplate Guide](https://www.baeldung.com/spring-jdbc-jdbctemplate)
4. [Spring JdbcClient Reference](https://docs.spring.io/spring-framework/reference/data-access/jdbc/core.html#jdbc-JdbcClient)
5. [Baeldung: JdbcClient Guide](https://www.baeldung.com/spring-6-jdbcclient-api)

---

## Common Mistakes to Avoid

- **Not closing connections** — use try-with-resources or let Spring manage connections
- **SQL injection** — never concatenate user input into SQL, use PreparedStatement
- **Wrong DataSource configuration** — check URL, username, password, driver class
- **Connection pool exhaustion** — set appropriate pool size, release connections properly

---

## Self-Check Questions

1. Why is connection pooling important?
2. What is the difference between Statement and PreparedStatement?
3. How does JdbcTemplate simplify JDBC code?
4. What happens if you don't close a database connection?
5. How do you configure HikariCP pool size?