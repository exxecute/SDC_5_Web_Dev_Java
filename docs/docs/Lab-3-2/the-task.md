---
sidebar_position: 1
---

# The task

Lab 3: Part 2 — Spring Data

## Tasks

1. Create Spring Data repository for all entities
2. Refactor service layer to use repository interfaces instead of DAO
3. Apply `@Transactional` annotations to service methods where appropriate

## Acceptance Criteria

- All CRUD operations work through Spring Data repositories
- Service methods are properly annotated with `@Transactional`
- No direct EntityManager usage

## Extra Tasks

- Implement pagination and sorting functionality
- Create custom query methods using `@Query` annotation for complex queries


## Materials

1. [Spring Data JPA - Query Methods](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
2. [Thorben Janssen: Spring Data JPA Query Methods](https://thorben-janssen.com/spring-data-jpa-query-annotation/)
3. [Baeldung: Spring Data JPA @Query](https://www.baeldung.com/spring-data-jpa-query)
4. [Vlad Mihalcea: Spring @Transactional](https://vladmihalcea.com/read-write-read-only-transaction-routing-spring/)
5. [Baeldung: Spring Data JPA Pagination](https://www.baeldung.com/spring-data-jpa-pagination-sorting)
6. [Vlad Mihalcea: N+1 Query Problem](https://vladmihalcea.com/n-plus-1-query-problem/)

---

## Common Mistakes to Avoid

- **N+1 query problem** — fetching related entities one by one instead of joining
- **Missing @Transactional** — LazyInitializationException when accessing lazy collections
- **Wrong @Transactional placement** — put on service layer, not repository
- **Modifying entities outside transaction** — changes won't be persisted
- **Complex method names** — use @Query for complex queries instead

---

## Self-Check Questions

1. What is the N+1 query problem and how do you solve it?
2. What is the difference between `CrudRepository` and `JpaRepository`?
3. How does Spring Data derive queries from method names?
4. When should you use `@Query` instead of derived query methods?
5. What does `@Transactional(readOnly = true)` do?