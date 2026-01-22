package com.webdev.sdc.repository;

import com.webdev.sdc.exception.GlobalException;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class JdbcCurrencyRepository implements CurrencyRepository {
    private final DataSource dataSource;

    public JdbcCurrencyRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public double getRate(Currency currency) {
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps =
                     c.prepareStatement("SELECT rate FROM currency WHERE code=?")) {

            ps.setString(1, currency.name());
            ResultSet rs = ps.executeQuery();
            return rs.next() ? rs.getDouble("rate") : 0.0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CurrencyEntity> findAll() {
        throw new GlobalException("Not implemented");
    }

    @Override
    public CurrencyEntity findById(Long id) {
        throw new GlobalException("Not implemented");
    }

    @Override
    public boolean existsByType(Currency type) {
        throw new GlobalException("Not implemented");
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        throw new GlobalException("Not implemented");
    }

    @Override
    public void deleteById(Long id) {
        throw new GlobalException("Not implemented");
    }
}
