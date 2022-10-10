package com.example.hw4.reposity;

import com.example.hw4.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerReposity {
    private List<Customer> customers = new ArrayList<>();
    public CustomerReposity(){
        try{
            File file = ResourceUtils.getFile("classpath:static/Customers.json");
            ObjectMapper mapper = new ObjectMapper();
            customers.addAll(mapper.readValue(file, new TypeReference<List<Customer>>(){}));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Customer> getAll(){
        return customers;
    }
    public Customer update(Customer customer){
        get(customer.getId()).ifPresent(existCustomer -> {
            existCustomer.setFullname(customer.getFullname());
            existCustomer.setEmail(customer.getEmail());
            existCustomer.setPhone(customer.getPhone());
        });
        return customer;
    }
    public Customer create(Customer customer){
        int id;
        if (customers.isEmpty()){
            id = 1;
        } else {
            Customer lastCustomer = customers.get(customers.size() - 1);
            id = lastCustomer.getId() + 1;
        }
        customer.setId(id);
        customers.add(customer);
        return customer;
    }
    public void delete(Customer customer){deleteByID(customer.getId()); }

    public Optional<Customer> get(int id){
        return customers.stream().filter(p -> p.getId() == id).findFirst();
    }
    public void deleteByID(int id){
        get(id).ifPresent(existed -> customers.remove(existed));
    }
}

