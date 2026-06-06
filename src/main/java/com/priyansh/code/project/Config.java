package com.priyansh.code.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public PaymentService paymentService(){
        System.out.println("Creating bean");
        PaymentService ps = new PaymentService();
        ps.setVal(100);
        return ps;
    }

}
