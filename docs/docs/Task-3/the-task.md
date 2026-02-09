---
sidebar_position: 1
---

# The task

1. Implement user service to manage users(create, add, etc)
2. Implement `UserDetailsService` interface
3. Implement the following endpoints:
   - `POST /login` - authenticate user (returns JWT token)
   - `POST /register` - register new user
5. On login, verify user exists
6. Use Spring Security to protect POST/PUT/DELETE endpoints (only authenticated users)
7. Configure `SecurityFilterChain` for stateless JWT authentication

## Extra Tasks

- Add JWT refresh token endpoint
- Implement role-based access (ADMIN and USER roles)
- Protect POST and DELETE currency/item endpoints for ADMIN only
- Use `AuthenticationEventPublisher` for login event tracking
## Materials

1. [Spring Security Project](https://spring.io/projects/spring-security)
2. [Spring Security Getting Started Guide](https://spring.io/guides/gs/securing-web)
3. [Medium: Spring Boot Security Step by Step](https://medium.com/@ansgar.nell/spring-boot-security-step-by-step-21ea836499f8)
4. [GeeksForGeeks: Introduction to Spring Security](https://www.geeksforgeeks.org/advance-java/introduction-to-spring-security-and-its-features/)
5. [GeeksForGeeks: Securing REST APIs](https://www.geeksforgeeks.org/advance-java/securing-rest-apis-with-spring-security/)
6. [Spring RestClient Reference](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-restclient)
7. [Baeldung: Spring RestClient](https://www.baeldung.com/spring-boot-restclient)

---

## Common Mistakes to Avoid

- **CORS errors** — configure CORS in SecurityFilterChain for frontend access
- **403 instead of 401** — check if authentication or authorization is failing
- **Password not encoded** — always use PasswordEncoder, never store plain text
- **JWT token expired** — handle token refresh or re-authentication
- **Disabling CSRF without understanding** — only safe for stateless APIs

---

## Self-Check Questions

1. What is the difference between authentication and authorization?
2. How does JWT authentication work in a stateless API?
3. What is the purpose of `UserDetailsService`?
4. When would you use `RestClient` vs `RestTemplate`?
5. How do you configure path-based security rules?