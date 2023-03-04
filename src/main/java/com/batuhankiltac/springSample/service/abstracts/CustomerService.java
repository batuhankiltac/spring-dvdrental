package com.batuhankiltac.springSample.service.abstracts;

import com.batuhankiltac.springSample.domain.Customer;
import com.batuhankiltac.springSample.model.CustomerDto;

import java.util.List;

public interface CustomerService {
    void add(CustomerDto customerDto);
    Customer update(CustomerDto customerDto);
    void delete(Integer id);
    List<Customer> getAll();
    List<Customer> getAllByPage(Integer pageNumber, Integer pageSize);
    List<Customer> getAllSortedByID();
    List<Customer> getAllSortedByName();
    Customer getByCustomerId(Integer customerId);
}
