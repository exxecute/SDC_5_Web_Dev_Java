package com.webdev.sdc.repository;

import com.webdev.sdc.exception.NotImplemented;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.model.CurrencyEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
@Profile("jdbc")
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
        String sql = "SELECT id, code, rate FROM currency";
        List<CurrencyEntity> list = new ArrayList<>();

        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new CurrencyEntity(
                        rs.getLong("id"),
                        Currency.valueOf(rs.getString("code")),
                        rs.getDouble("rate")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public CurrencyEntity findById(Long id) {
        String sql = "SELECT id, code, rate FROM currency WHERE id=?";

        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CurrencyEntity(
                        rs.getLong("id"),
                        Currency.valueOf(rs.getString("code")),
                        rs.getDouble("rate")
                );
            }

            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByType(Currency type) {
        String sql = "SELECT 1 FROM currency WHERE code=?";

        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, type.name());
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CurrencyEntity save(CurrencyEntity currency) {
        String sql = "INSERT INTO currency(code, rate) VALUES (?, ?)";

        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, currency.getType().name());
            ps.setDouble(2, currency.getRate());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return new CurrencyEntity(
                        rs.getLong(1),
                        currency.getType(),
                        currency.getRate()
                );
            }

            return currency;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM currency WHERE id=?";

        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
