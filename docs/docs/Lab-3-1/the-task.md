---
sidebar_position: 1
---

# The task

Lab 3: Part 1 — JPA and Hibernate

## Tasks

1. Add JPA and Hibernate dependencies to the project
2. Configure application to work with Hibernate
3. Create entity classes with appropriate JPA annotations
4. Implement at least one entity relationship (`@OneToMany` / `@ManyToOne`)
5. Implement basic CRUD operations using `EntityManager`

## Acceptance Criteria

- Application starts without JPA/Hibernate errors
- Database CRUD operations use Hibernate


## Materials

1. [Thorben Janssen: JPA Entity Mapping](https://thorben-janssen.com/key-jpa-hibernate-annotations/)
2. [Vlad Mihalcea: Entity Identifier Strategies](https://vladmihalcea.com/hibernate-and-uuid-identifiers/)
3. [Thorben Janssen: Entity Relationships](https://thorben-janssen.com/entity-mappings-introduction-jpa-fetchtypes/)
4. [Vlad Mihalcea: ManyToOne Best Practices](https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/)
5. [Vlad Mihalcea: EAGER vs LAZY Fetching](https://vladmihalcea.com/hibernate-facts-the-importance-of-fetch-strategy/)
6. [Vlad Mihalcea: Cascade Types Guide](https://vladmihalcea.com/jpa-cascade-types/)

---

## Common Mistakes to Avoid

- **Missing @Entity annotation** — class won't be recognized as entity
- **No default constructor** — JPA requires a no-arg constructor
- **Using EAGER fetch everywhere** — causes performance issues, prefer LAZY
- **Bidirectional relationship without mappedBy** — duplicate foreign keys
- **Wrong cascade type** — CascadeType.ALL can delete more than intended

---

## Self-Check Questions

1. What is the difference between JPA and Hibernate?
2. When would you use EAGER vs LAZY fetching?
3. What is the persistence context?
4. How do you define a bidirectional OneToMany relationship?
5. What are the differences between `persist()`, `merge()`, and `save()`?