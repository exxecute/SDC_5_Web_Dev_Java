---
sidebar_position: 1
---

# Create Spring Data repository for all entities

```java
@Repository
public interface BankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findById(Long id);

    BankEntity save(BankEntity bank);

    List<BankEntity> findAll();

    @Query("SELECT b FROM BankEntity b ORDER BY b.name ASC")
    List<BankEntity> findAllBanksOrderedByName();
}
```

```java
@Repository
@Profile("jpa")
public interface JpaCurrencyRepository extends JpaRepository<CurrencyEntity, Long>, CurrencyRepository {
}
```