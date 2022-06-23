package com.example.comsumerApp.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo CustomerRepo;


    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.CustomerRepo = customerRepo;
    }


    public List<Customer> getCustomer() {
        return CustomerRepo.findAll();
    }

    public void addNewCustomer(Customer Customer) {

       Optional<Customer> customerOptional =  CustomerRepo.findByFirstNameOrLastName(Customer.getFirstName(),Customer.getLastName());
       if (customerOptional.isPresent()) {
           throw new IllegalStateException("name not found");
       }
       CustomerRepo.save(Customer);

    }
}
