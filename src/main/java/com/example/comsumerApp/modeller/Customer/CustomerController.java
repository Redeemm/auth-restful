package com.example.comsumerApp.modeller.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService CustomerService;
    private final CustomerRepo customerRepo;


    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepo customerRepo) {
        this.CustomerService = customerService;
        this.customerRepo = customerRepo;
    }

    @GetMapping("api/v1/customer")
    public List<Customer> getStudent() {
        return CustomerService.getCustomer();
    }


//    @PostMapping(path = "api/v1/customer")
//    public void registerNewStudent( @RequestBody Customer customer) {
//        CustomerService.addNewCustomer(customer);
//    }

    @DeleteMapping("api/v1/customer/{id}")
    public void deleteCustomer( @PathVariable(value = "id") Long CustomerID) {
        CustomerService.deleteCustomer(CustomerID);
    }

    @PutMapping(path = "{CustomerID}")
    public void updateCustomer(
            @PathVariable("CustomerID") Long CustomerID,
            @RequestParam(required = false) String FirstName,
            @RequestParam(required = false) String LastName,
            @RequestParam(required = false) String Email,
            @RequestParam(required = false) int Phone,
            @RequestParam(required = false) String Address
            ) {
        CustomerService.updateCustomer(CustomerID, FirstName, LastName, Email, Phone, Address);
    }
}
