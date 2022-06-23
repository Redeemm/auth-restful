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
                    1,
                    "Red",
                    "RedMan",
                    "redf@gmail.com",
                    12345,
                    "2343"

            );




            CustomerRepo.saveAll(
                    List.of(
                            Red
                    )
            );



        };
    }
}
