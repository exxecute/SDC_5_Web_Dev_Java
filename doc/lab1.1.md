# Lab 1: Part 1 — Build a REST API for a business entity with full CRUD operations.

## Tasks

1. Design a small application for your chosen entity (currency exchange rates, beverages, etc.)
2. Implement the layered architecture: Controller, Service, Repository
3. Use `List` or `Map` in the repository for data storage
4. Implement the following endpoints(this is an example, adjust according to your application):
   - `GET /rates` (or `/items`) - list all items
   - `GET /rates/{id}` - get item by ID
   - `POST /rates` - add new item
   - `PUT /rates/{id}` - update existing item
   - `DELETE /rates/{id}` - delete item
5. Use `@RequestBody` for create and update operations
6. Use `@PathVariable` for get and delete operations
7. Use `@RequestParam` for filtering the list (e.g., by category)
8. Use `@RequestHeader` in at least one request which consumes a header

## Deliverables

- Complete REST API with CRUD operations
- Layered architecture (Controller, Service, Repository)

## Acceptance Criteria

- All five CRUD endpoints work correctly
- JSON serialization/deserialization works properly
- Proper use of HTTP methods and status codes

## Extra Tasks

- Wrap responses in a response object with metadata (date, count)
- Add pagination support for the list endpoint
- Implement repository which works with any database (for example postgresql, h2)

---

## Grading (10 points)

| Criteria | Points |
|----------|--------|
| All CRUD endpoints work | 3 |
| Layered architecture (Controller/Service/Repository) | 2 |
| @PathVariable, @RequestParam, @RequestHeader used | 1 |
| @RequestBody for POST/PUT | 1 |
| Code quality and organization | 2 |
| Extra tasks (bonus) | +2 |
