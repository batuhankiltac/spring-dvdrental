package com.batuhankiltac.springSample.controller;

import com.batuhankiltac.springSample.domain.Customer;
import com.batuhankiltac.springSample.model.CustomerDto;
import com.batuhankiltac.springSample.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void add(@RequestBody CustomerDto customerDto) {
        customerService.add(customerDto);
    }

    @PutMapping
    public Customer update(@RequestBody CustomerDto customerDto) {
        return customerService.update(customerDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        customerService.delete(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/by-page")
    public List<Customer> getAllByPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return customerService.getAllByPage(pageNumber, pageSize);
    }

    @GetMapping("/sorted-by-id")
    public List<Customer> getAllSortedByID() {
        return customerService.getAllSortedByID();
    }

    @GetMapping("/sorted-by-name")
    public List<Customer> getAllSortedByName() {
        return customerService.getAllSortedByName();
    }

    @GetMapping("/by-customer-id")
    public Customer getByCustomerId(@RequestParam Integer customerId) {
        return customerService.getByCustomerId(customerId);
    }
}