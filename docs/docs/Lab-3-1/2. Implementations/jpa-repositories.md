---
sidebar_position: 4
---

# Jpa Repositories

```java
@Repository
@Profile("jpa")
public interface JpaCurrencyRepository extends JpaRepository<CurrencyEntity, Long>, CurrencyRepository {
}
```

```java
@Repository
public interface BankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findById(Long id);

    BankEntity save(BankEntity bank);

    List<BankEntity> findAll();
}
```
