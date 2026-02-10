---
sidebar_position: 1
---

# New Repositories

## JDBC

```java
@Profile("jdbc")
@Repository
public class JdbcCurrencyRepository implements CurrencyRepository {
    private final DataSource dataSource;


    public JdbcCurrencyRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<CurrencyEntity> findAll() {
        List<CurrencyEntity> list = new ArrayList<>();
        String sql = "SELECT id, type, rate FROM currency";


        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("JDBC findAll failed", e);
        }
        return list;
    }


    @Override
    public Optional<CurrencyEntity> findById(Long id) {
        String sql = "SELECT id, type, rate FROM currency WHERE id = ?";


        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {


            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("JDBC findById failed", e);
        }
        return Optional.empty();
    }


    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        String sql = "INSERT INTO currency(type, rate) VALUES (?, ?)";


        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            ps.setString(1, currency.getType());
            ps.setDouble(2, currency.getRate());
            ps.executeUpdate();


            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    currency = new CurrencyEntity(keys.getLong(1), currency.getType(), currency.getRate());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("JDBC save failed", e);
        }
        return currency;
    }


    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM currency WHERE id = ?";


        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {


            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("JDBC deleteById failed", e);
        }
    }

    @Override
    public List<CurrencyEntity> findByType(String type) {
        List<CurrencyEntity> list = new ArrayList<>();
        String sql = "SELECT id, type, rate FROM currency WHERE type = ?";


        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {


            ps.setString(1, type);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("JDBC findByType failed", e);
        }
        return list;
    }

    private CurrencyEntity map(ResultSet rs) throws SQLException {
        return new CurrencyEntity(
                rs.getLong("id"),
                rs.getString("type"),
                rs.getDouble("rate")
        );
    }
}
```

## JDBC Template

```java
@Profile("jdbctemplate")
@Repository
public class JdbcTemplateCurrencyRepository implements CurrencyRepository {


    private final JdbcTemplate jdbcTemplate;


    public JdbcTemplateCurrencyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private CurrencyEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CurrencyEntity(
                rs.getLong("id"),
                rs.getString("type"),
                rs.getDouble("rate")
        );
    }


    @Override
    public List<CurrencyEntity> findAll() {
        return jdbcTemplate.query("SELECT id, type, rate FROM currency", this::mapRow);
    }


    @Override
    public Optional<CurrencyEntity> findById(Long id) {
        List<CurrencyEntity> list = jdbcTemplate.query(
                "SELECT id, type, rate FROM currency WHERE id = ?",
                this::mapRow,
                id
        );
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        jdbcTemplate.update(
                "INSERT INTO currency(type, rate) VALUES (?, ?)",
                currency.getType(), currency.getRate()
        );

        Long id = jdbcTemplate.queryForObject("SELECT MAX(id) FROM currency", Long.class);
        return new CurrencyEntity(id, currency.getType(), currency.getRate());
    }


    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM currency WHERE id = ?", id);
    }


    @Override
    public List<CurrencyEntity> findByType(String type) {
        return jdbcTemplate.query(
                "SELECT id, type, rate FROM currency WHERE type = ?",
                this::mapRow,
                type
        );
    }
}
```