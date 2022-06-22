package com.example.comsumerApp.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

//    Optional<Customer> findCustomerByEmail(String email);

}
