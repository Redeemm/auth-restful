package com.example.comsumerApp.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
//            throws ResourceNotFoundException {
//        Customer customer = customerRepo.findById(CustomerID)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerID));
//
//        customerRepo.delete(customer);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;

        CustomerService.deleteCustomer(CustomerID);

    }
}
