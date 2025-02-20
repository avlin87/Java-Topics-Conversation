package com.epam.spring.start.controller;

import com.epam.spring.start.domain.entity.Customer;
import com.epam.spring.start.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    public final CustomerService customerService;

    @PostMapping
    public Customer post(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer helloCustomer(@PathVariable Integer id) {
        log.info("hello customer");
        return customerService.getCustomer(id);
    }

    @GetMapping()
    public List<Customer> helloCustomer() {
        log.info("hello customerS!");
        return customerService.getAllCustomers();
    }

    @PutMapping
    public String put() {
        return "Put Example";
    }

    @DeleteMapping
    public void delete() {

    }
}
