package com.example.comsumerApp.modeller.Partner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PartnerConfig {


    @Bean
    CommandLineRunner commandLineRunner(PartnerRepository partnerRepository) {
        return args -> {
			Partner kathy = new Partner(
					"Agbonuglah"
			);



            Partner edith = new Partner(
                    "Yaa"
            );



			partnerRepository.saveAll(
					List.of(
							edith, kathy
					)
			);



        };
    }
}
