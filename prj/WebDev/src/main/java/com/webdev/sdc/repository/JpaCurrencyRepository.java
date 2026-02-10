package com.webdev.sdc.repository;

import com.webdev.sdc.model.CurrencyEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface JpaCurrencyRepository extends JpaRepository<CurrencyEntity, Long>, CurrencyRepository {
}
