package com.webdev.sdc.repository;

import com.webdev.sdc.model.CurrencyEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
