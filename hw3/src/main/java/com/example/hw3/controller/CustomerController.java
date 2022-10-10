package com.example.hw3.controller;

import com.example.hw3.dto.CustomerRequest;
import com.example.hw3.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
@RestController
@RequestMapping("people")
public class CustomerController {
    private ConcurrentHashMap<String, Customer> customers;

    public CustomerController() {
        customers = new ConcurrentHashMap<>();
        customers = new ConcurrentHashMap<>();
        customers.put("1", new Customer("1", "Ich", "ich1234@gmail.com", 11111111));
        customers.put("2", new Customer("2", "Long", "long1234@gmail.com", 22222222));
        customers.put("3", new Customer("3", "Quang", "quang2001@gmail.com", 33333333));
        customers.put("4", new Customer("4", "Minh", "minh12345@gmail.com", 4444444));
    }

    @GetMapping
    public List<Customer> getAllPeople() {
        return customers.values().stream().toList();
    }

    @PostMapping
    public Customer createNewCustomer(@RequestBody CustomerRequest customerRequest) {
        String uuid = UUID.randomUUID().toString();
        Customer newCustomer = new Customer(uuid, customerRequest.fullname(), customerRequest.email(), customerRequest.telephone());
        customers.put(uuid, newCustomer);
        return newCustomer;
    }

    @GetMapping(value = "/{id}")
    public Customer getPeopleByID(@PathVariable("id") String id) {
        return customers.get(id);
    }

    @PutMapping(value = "/{id}")
    public Customer updateCustomerByID(@PathVariable("id") String id, @RequestBody CustomerRequest customerRequest) {
        Customer updatePeople = new Customer(id, customerRequest.fullname(), customerRequest.email(), customerRequest.telephone());
        customers.replace(id, updatePeople);
        return updatePeople;
    }

    @DeleteMapping(value = "/{id}")
    public Customer deleteCustomer(@PathVariable("id") String id) {
        return customers.remove(id);
    }
}


