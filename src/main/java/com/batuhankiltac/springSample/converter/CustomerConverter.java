package com.batuhankiltac.springSample.converter;

import com.batuhankiltac.springSample.domain.Customer;
import com.batuhankiltac.springSample.model.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer convert(CustomerDto customerDto) {
        return Customer.builder()
                .customerId(customerDto.getCustomerId())
                .email(customerDto.getEmail())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
    }
}
