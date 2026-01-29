package com.webdev.sdc.config;

import com.webdev.sdc.lifecycle.LifecycleBean;
import com.webdev.sdc.repository.CurrencyRepository;
import com.webdev.sdc.repository.FileCurrencyRepository;
import com.webdev.sdc.repository.JdbcCurrencyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.FileNotFoundException;

@Configuration
@ComponentScan("com.webdev.sdc")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${repository.type}")
    private String repositoryType;

    @Value("${filepath.rates}")
    private String ratesFilePath;

    @Bean
    public CurrencyRepository currencyRepository(DataSource dataSource) throws FileNotFoundException {
        switch (RepositoryType.from(repositoryType)) {
            case FILE -> {
                return new FileCurrencyRepository(ResourceUtils.getFile(ratesFilePath));
            }
            case JDBC -> {
                return new JdbcCurrencyRepository(dataSource);
            }
            default -> {
                throw new IllegalStateException();
            }
        }
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:h2:mem:testJdbc");
        return ds;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifecycleBean lifecycleBean() {
        return new LifecycleBean();
    }
}