//package com.example.comsumerApp.modeller.Product;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ProductConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
//        return args -> {
//            Product red = new Product(
//                    "Agbonuglah",
//                    "cagbonuglah@gmail.com",
//                    "ds"
//            );
//
//            Product rad = new Product(
//                    "Agbonuglah",
//                    "cagbonuglah@gmail.com",
//                    "ds"
//            );
//
//            productRepository.saveAll(
//                    List.of(
//                            red, rad
//                    )
//            );
//        };
//    }
//}
