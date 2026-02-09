---
sidebar_position: 1
---

# The task

1. Add Spring Boot Actuator dependency to the project
2. Configure actuator endpoints in `application.yml`
3. Create a multi-stage `Dockerfile` for the application
4. Build and run the application in a Docker container
5. Verify the application is accessible from the container, including main functionality and actuator health endpoint

## Extra Tasks

- Configure and run multi-container setup (application + database) using Docker Compose
- Add health checks to Docker Compose configuration

## Materials

1. [Docker: Multi-stage Builds](https://docs.docker.com/build/building/multi-stage/)
2. [Spring Boot Docker Topical Guide](https://spring.io/guides/topicals/spring-boot-docker)
3. [Docker Compose](https://docs.docker.com/compose/)
4. [Spring Boot Actuator Reference](https://docs.spring.io/spring-boot/reference/actuator/index.html)
5. [Baeldung: Spring Boot Actuator](https://www.baeldung.com/spring-boot-actuators)

---

## Common Mistakes to Avoid

- **Exposing sensitive actuator endpoints** — secure or disable endpoints like `/env`, `/configprops`
- **Large Docker images** — use multi-stage builds, don't include build tools in final image
- **Port not exposed** — remember to EXPOSE and publish ports with `-p`
- **Container can't connect to host DB** — use `host.docker.internal` or Docker network
- **Application crashes on startup** — check logs with `docker logs <container>`

---

## Self-Check Questions

1. What actuator endpoints are enabled by default?
2. What is the benefit of multi-stage Docker builds?
3. How do you pass environment variables to a Docker container?
4. What is the difference between EXPOSE and `-p` flag?
5. How do you check if your application is healthy in a container?