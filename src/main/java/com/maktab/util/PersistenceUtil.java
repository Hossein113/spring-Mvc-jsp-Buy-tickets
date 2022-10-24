package com.maktab.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan
public class PersistenceUtil {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

}