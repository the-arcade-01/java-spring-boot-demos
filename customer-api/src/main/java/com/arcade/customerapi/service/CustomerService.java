package com.arcade.customerapi.service;

import com.arcade.customerapi.model.CustomerModel;
import com.arcade.customerapi.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo repository;

    @Autowired
    public CustomerService(CustomerRepo repository) {
        this.repository = repository;
    }

    List<CustomerModel> getAllCustomerList() {
        return repository.findAll();
    }

    CustomerModel getCustomer(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Customer not found"));
    }

    CustomerModel addCustomer(CustomerModel customer) {
        return repository.save(customer);
    }

    CustomerModel updateCustomer(CustomerModel updateCustomer, Long id) throws Exception {
        return repository.findById(id).map((customer) -> {
            customer.setName(updateCustomer.getName());
            customer.setEmail(updateCustomer.getEmail());
            customer.setNumber(updateCustomer.getNumber());

            return repository.save(customer);
        }).orElseThrow(() -> new Exception("Customer not found with ID: " + id));
    }

    String deleteCustomer(Long id) {
        repository.deleteById(id);
        return String.format("Customer deleted with Id: " + id);
    }

    String deleteAll() {
        repository.deleteAll();
        return "All Customers deleted";
    }
}
