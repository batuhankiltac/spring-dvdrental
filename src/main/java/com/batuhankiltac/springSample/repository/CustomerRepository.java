package com.batuhankiltac.springSample.repository;

import com.batuhankiltac.springSample.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer getByCustomerId(Integer customerId);
}