package com.arcade.customerapi.controller;

import com.arcade.customerapi.model.CustomerModel;
import com.arcade.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        List<CustomerModel> customers = customerService.getAllCustomerList();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomer(@PathVariable Long id) throws Exception {
        CustomerModel customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerModel> addCustomer(@RequestBody CustomerModel customer) {
        CustomerModel newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel customer, @PathVariable Long id) throws Exception {
        CustomerModel updateCustomer = customerService.updateCustomer(customer, id);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        String response = customerService.deleteCustomer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        String response = customerService.deleteAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
