package com.example.hw4.controller;

import com.example.hw4.model.Customer;
import com.example.hw4.reposity.CustomerReposity;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private CustomerReposity customerReposity;
    public CustomerController(){
        customerReposity = new CustomerReposity();
    }
    //trang chủ
    @GetMapping("/")
    public String home(){
        return "home";
    }
    //hiển thị tất cả danh sách
    @GetMapping("/listAll")
    public String listAll(Model model){
        List<Customer> customers = customerReposity.getAll();
        model.addAttribute("customers", customers);
        return "listAll";
    }
    //cập nhập thông tin cho customer
    @GetMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model){
        Optional<Customer> customer = customerReposity.get(id);
        if(customer.isPresent()){
            model.addAttribute("customer",customer);
        }
        return "customerForm";
    }
    //tạo customer mới
    @GetMapping("create")
    public String creatNew(Model model){
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }
    // xóa customer
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model){
        customerReposity.deleteByID(id);
        model.addAttribute("people",customerReposity.getAll());
        return "redirect:/listAll";
    }
    @PostMapping("/post")
    public String postInfo(@ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(customer.getId()>0){
                customerReposity.update(customer);
            }else{
                customerReposity.create(customer);
            }
            model.addAttribute("people", customerReposity.getAll());
            return "redirect:/listAll";
        }
        return "customerForm";
    }
}
