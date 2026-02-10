---
sidebar_position: 2
---

# All existing functionality remains intact after migration

Editing Profiles to `Jdbc`, `Map` and `File`

## JDBC

```txt
server.port=8080
spring.application.name=currency-app

filepath.rates=classpath:rates.txt
spring.profiles.default=file
spring.profiles.active=jdbc
```

![jdbc](../../../assets/Lab-2-1/jdbc.png)

## Map

```txt
server.port=8080
spring.application.name=currency-app

filepath.rates=classpath:rates.txt
spring.profiles.default=file
spring.profiles.active=map
```

![map](../../../assets/Lab-2-1/map.png)

## File

```txt
server.port=8080
spring.application.name=currency-app

filepath.rates=classpath:rates.txt
spring.profiles.default=file
spring.profiles.active=file
```

![file](../../../assets/Lab-2-1/file.png)
