---
sidebar_position: 2
---

# Update properties

```txt
server.port=8080
spring.application.name=currency-app

filepath.rates=classpath:rates.txt
spring.profiles.default=file
spring.profiles.active=jdbctemplate

spring.datasource.url=jdbc:h2:file:~/testdb;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=none

spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql
spring.sql.init.encoding=UTF-8
```

## SQL files

```sql title="schema"
DROP TABLE IF EXISTS  currency;

CREATE TABLE IF NOT EXISTS currency (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        type VARCHAR(10) NOT NULL,
                                        rate DOUBLE NOT NULL
);
```

```sql title="data"
INSERT INTO currency(type, rate) VALUES('USD', 1.0);
INSERT INTO currency(type, rate) VALUES('EUR', 0.95);
INSERT INTO currency(type, rate) VALUES('BYN', 2.5);
```

## DB Configuration

```java
@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.driver-class-name}") String driver
    ) {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driver)
                .build();
    }
}
```