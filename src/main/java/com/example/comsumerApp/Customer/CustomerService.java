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


//    public void addNewCustomer(Customer Customer) {
//        Optional<Customer> optionalCustomer = CustomerRepo.findCustomerByEmail(Customer.getEmail());
//        if (optionalCustomer.isPresent()) {
//            throw new IllegalStateException("email is available");
//        }
//        CustomerRepo.save(Customer);
//    }

//    public void deleteCustomer(Long CustomerID) {
//        boolean exist = CustomerRepo.existsById(CustomerID);
//        if (!exist) {
//            throw new IllegalStateException("Customer ID " + CustomerID + " does not exist");
//        }
//        CustomerRepo.deleteById(CustomerID);
//    }
}
