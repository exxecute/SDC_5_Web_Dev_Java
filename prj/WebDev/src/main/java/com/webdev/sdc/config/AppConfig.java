package com.webdev.sdc.config;


import com.webdev.sdc.repository.CurrencyRepository;
import com.webdev.sdc.repository.MapCurrencyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.webdev.sdc")
public class AppConfig {

    @Bean
    public CurrencyRepository currencyRepository() {
        return new MapCurrencyRepository();
    }
}