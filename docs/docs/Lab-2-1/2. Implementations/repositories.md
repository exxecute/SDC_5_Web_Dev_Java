---
sidebar_position: 3
---

# Repositories

```java
@Profile("file")
@Repository
public class FileCurrencyRepository implements CurrencyRepository {
```

```java
@Profile("jdbc")
@Repository
public class JdbcCurrencyRepository implements CurrencyRepository {
```

```java
@Profile("map")
@Repository
public class MapCurrencyRepository implements CurrencyRepository {
```
