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

    //Get Customer from DB
    public List<Customer> getCustomer() {
        return CustomerRepo.findAll();
    }


//    Add new customer to DB
//    public void addNewCustomer(Customer customer) {
//        Optional<Customer> optionalCustomer = CustomerRepo.findByFirstNameOrLastName(customer.getFirstName(), customer.getLastName());
//        if (optionalCustomer.isPresent()) {
//            throw new IllegalStateException("name is available");
//        }
//        CustomerRepo.save(customer);
//    }

    public void deleteCustomer(Long customerID) {
        boolean exist = CustomerRepo.existsById(customerID);
        if (!exist) {
            throw new IllegalStateException("Dont exist");
        }
        CustomerRepo.deleteById(customerID);
    }
}
