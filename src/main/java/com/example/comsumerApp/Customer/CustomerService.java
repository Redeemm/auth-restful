package com.example.comsumerApp.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateCustomer(Long customerID, String firstName, String lastName, String email, int phone, String address) {
        Customer customer = CustomerRepo.findById(customerID)
                .orElseThrow(
                () -> new IllegalStateException("don't exist"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(customer.getFirstName(), firstName)) {
            customer.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(customer.getLastName(), lastName)) {
            customer.setLastName(lastName);
        }
        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            customer.setEmail(email);
        }
        if (!Objects.equals(customer.getPhone(), phone)) {
            customer.setPhone(phone);
        }
        if (address != null && address.length() > 0 && !Objects.equals(customer.getAddress(), address)) {
            customer.setAddress(address);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(customer.getLastName(), lastName)) {
            customer.setLastName(lastName);
        }
    }

}
