package com.mobileApp.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {
    @Bean
    CommandLineRunner initDB(ItemRepository repository){
        return args -> {};
    }
}
