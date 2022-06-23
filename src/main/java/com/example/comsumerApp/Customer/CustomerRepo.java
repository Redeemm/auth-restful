package com.example.comsumerApp.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

//    @Query("select s from Customer s where s.FirstName = ?1")
    Optional<Customer> findByFirstNameOrLastName (String FistName, String LastName);

}
