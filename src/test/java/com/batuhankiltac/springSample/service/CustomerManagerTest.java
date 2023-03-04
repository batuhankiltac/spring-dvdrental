package com.batuhankiltac.springSample.service;

import com.batuhankiltac.springSample.converter.CustomerConverter;
import com.batuhankiltac.springSample.domain.Customer;
import com.batuhankiltac.springSample.model.CustomerDto;
import com.batuhankiltac.springSample.repository.CustomerRepository;
import com.batuhankiltac.springSample.service.concretes.CustomerManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerManagerTest {

    @InjectMocks
    private CustomerManager customerManager;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerConverter customerConverter;

    @Test
    public void it_should_save_customer() {
        // Given
        final CustomerDto customerDto = CustomerDto.builder().build();
        final Customer customer = Customer.builder().build();
        when(customerConverter.convert(customerDto)).thenReturn(customer);

        // When
        customerManager.add(customerDto);

        // Then
        verify(customerConverter).convert(customerDto);
        verify(customerRepository).save(customer);
    }

    @Test
    public void it_should_update_customer() {
        // Given
        final CustomerDto customerDto = CustomerDto.builder()
                .customerId(1)
                .firstName("Batuhan")
                .email("test@test.com")
                .build();
        final Customer customer = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .email(customerDto.getEmail())
                .lastName(customerDto.getLastName())
                .firstName(customerDto.getFirstName())
                .build();
        when(customerRepository.findById(customerDto.getCustomerId())).thenReturn(Optional.of(customer));

        // When
        customerManager.update(customerDto);

        // Then
        verify(customerRepository).findById(customerDto.getCustomerId());
        verify(customerRepository).save(customer);
    }

    @Test
    public void it_should_delete_customer() {
        // Given
        final Integer id = 1;

        // When
        customerManager.delete(id);

        // Then
        verify(customerRepository).deleteById(id);
    }

    @Test
    public void it_should_get_all_customers() {
        // Given
        final Customer customer1 = Customer.builder().build();
        final Customer customer2 = Customer.builder().build();
        final List<Customer> customers = Arrays.asList(customer1, customer2);

        // When
        customerManager.getAll();

        // Then
        verify(customerRepository).findAll();
        assertThat(customers).isNotEmpty();
    }

    @Test
    public void it_should_get_customer_by_customer_id() {
        // Given
        final Customer customer = Customer.builder()
                .customerId(1)
                .firstName("Batuhan")
                .email("test@test.com")
                .build();

        // When
        customerManager.getByCustomerId(customer.getCustomerId());

        // Then
        verify(customerRepository).getByCustomerId(customer.getCustomerId());
    }
}
