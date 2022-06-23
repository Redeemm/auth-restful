package com.example.comsumerApp.Customer;

import com.example.comsumerApp.Customer.Exception.ResourceNotFoundException;
import org.aspectj.weaver.ast.ITestVisitor;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

Test t = new Test() {
    @Override
    public void accept(ITestVisitor iTestVisitor) {

    }
};

    private final CustomerService CustomerService;
    private final CustomerRepo customerRepo;


    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepo customerRepo) {
        this.CustomerService = customerService;
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public List<Customer> getStudent() {
        return CustomerService.getCustomer();
    }

//    @PostMapping
//    public void registerNewStudent(@RequestBody Customer Customer) {
//        CustomerService.addNewCustomer(Customer);
//    }


//    @GetMapping("customers/{id}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long CustomerID)
//            throws ResourceNotFoundException {
//        Customer customer = CustomerRepo.findById(CustomerID)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerID));
//        return ResponseEntity.ok().body(customer);
//    }
//
//    @PostMapping("/customer")
//    public Customer createCustomer(@Valid @RequestBody Customer customer) {
//        return CustomerRepo.save(customer);
//    }
//
//    @PutMapping("/customer/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long CustomerID, @Valid @RequestBody Customer CustomerDetails)
//
//            throws ResourceNotFoundException {
//        Customer customer = CustomerRepo.findById(CustomerID)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerID));
//
//        customer.setFirstName(CustomerDetails.getFirstName());
//        customer.setLastName(CustomerDetails.getLastName());
//        customer.setEmail(CustomerDetails.getEmail());
//        customer.setEmail(CustomerDetails.getEmail());
//        customer.setPhone(CustomerDetails.getPhone());
//        customer.setAddress(CustomerDetails.getAddress());
//
//        return ResponseEntity.ok(this.customerRepo.save(customer));
//    }

    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long CustomerID)
            throws ResourceNotFoundException {
        Customer customer = customerRepo.findById(CustomerID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerID));

        customerRepo.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
