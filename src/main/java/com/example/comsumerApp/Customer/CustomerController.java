package com.example.comsumerApp.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private CustomerService CustomerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.CustomerService = customerService;
    }

    @GetMapping
    public List<Customer> getStudent() {
        return CustomerService.getCustomer();
    }

//    @PostMapping
//    public void registerNewStudent(@RequestBody Customer Customer) {
//        CustomerService.addNewCustomer(Customer);
//    }
//
//    @DeleteMapping(path = "{CustomerID}")
//    public void deleteStudent(@PathVariable("CustomerID") Long CustomerID) {
//        CustomerService.deleteCustomer(CustomerID);
//    }

}
