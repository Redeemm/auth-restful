package com.example.comsumerApp.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo CustomerRepo) {
        return args -> {
            Customer Red = new Customer(
                    "redeemerdela@gmail.com",
                    "RedMan"
            );



            Customer Todd = new Customer(
                    "Toddmanu@gmail.com",
                    "GodTodd"
            );



            CustomerRepo.saveAll(
                    List.of(
                            Red, Todd
                    )
            );



        };
    }
}
