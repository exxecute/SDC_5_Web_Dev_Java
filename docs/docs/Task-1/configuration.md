---
sidebar_position: 3
---

# Configuration

```java title="Config"
@Configuration
@ComponentScan("com.webdev.sdc")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${repository.type}")
    private String repositoryType;

    @Value("${filepath.rates}")
    private String ratesFilePath;

    @Bean
    public CurrencyRepository currencyRepository() throws FileNotFoundException {
        switch (RepositoryType.from(repositoryType)) {
            case MAP -> {
                return new MapCurrencyRepository();
            }
            case FILE -> {
                return new FileCurrencyRepository(ResourceUtils.getFile(ratesFilePath));
            }
            case JDBC -> {
                return new JdbcCurrencyRepository();
            }
            default -> {
                throw new NotFoundException(0L, "No Repository type");
            }
        }
    }
}
```

```java title="Repository types"
public enum RepositoryType {
    MAP("map"),
    FILE("file"),
    JDBC("jdbc");

    private final String value;

    RepositoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RepositoryType from(String value) {
        for (RepositoryType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown repository type: " + value);
    }
}
```

```java title="application.properties"
filepath.rates=classpath:rates.txt
repository.type=jdbc
```

```java title="rates.txt"
USD=90.5
EUR=98.2
```
