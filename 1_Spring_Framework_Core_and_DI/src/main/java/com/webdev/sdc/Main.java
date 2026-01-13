package com.webdev.sdc;

import com.webdev.sdc.config.AppConfig;
import com.webdev.sdc.model.Currency;
import com.webdev.sdc.service.CurrencyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CurrencyService service = ctx.getBean(CurrencyService.class);
        service.printRate(Currency.EUR);

        ctx.close();
    }
}