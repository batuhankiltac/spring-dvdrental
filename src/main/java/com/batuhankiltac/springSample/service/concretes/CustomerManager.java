package com.batuhankiltac.springSample.service.concretes;

import com.batuhankiltac.springSample.converter.CustomerConverter;
import com.batuhankiltac.springSample.domain.Customer;
import com.batuhankiltac.springSample.model.CustomerDto;
import com.batuhankiltac.springSample.repository.CustomerRepository;
import com.batuhankiltac.springSample.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @Override
    public void add(CustomerDto customerDto) {
        Customer customer = customerConverter.convert(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setEmail(customerDto.getEmail());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return customerRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Customer> getAllSortedByID() {
        Sort sort = Sort.by(Sort.Direction.ASC, "customerId");
        return customerRepository.findAll(sort);
    }

    @Override
    public List<Customer> getAllSortedByName() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return customerRepository.findAll(sort);
    }

    @Override
    public Customer getByCustomerId(Integer customerId) {
        return customerRepository.getByCustomerId(customerId);
    }
}