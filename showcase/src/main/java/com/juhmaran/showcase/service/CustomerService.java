package com.juhmaran.showcase.service;

import com.juhmaran.showcase.domain.dto.CustomerRequest;
import com.juhmaran.showcase.domain.dto.CustomerResponse;
import com.juhmaran.showcase.domain.model.Customer;
import com.juhmaran.showcase.exceptions.runtime.CustomerNotFoundException;
import com.juhmaran.showcase.mapper.CustomerMapper;
import com.juhmaran.showcase.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;
    private final CustomerValidationUtil util;

    public CustomerService(CustomerRepository repository,
                           CustomerMapper customerMapper, CustomerValidationUtil util) {
        this.repository = repository;
        this.customerMapper = customerMapper;
        this.util = util;
    }

    @Transactional
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        util.validateCustomerData(customerRequest);
        Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
//        customer.setActive(true);
        customer.setCreatedAt(LocalDateTime.now());
        customer = util.saveCustomer(customer);
        return customerMapper.customerToCustomerResponse(customer);
    }

    @Transactional
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = util.getCustomerByIdAndVerifyStatus(id);
        util.validateCustomerData(customerRequest);
        util.updateCustomerDetails(customer, customerRequest);
        customer = util.saveCustomer(customer);
        return customerMapper.customerToCustomerResponse(customer);
    }

    public CustomerResponse getCustomerById(Long id) {
        try {
            Customer customer = util.getCustomerByIdAndVerifyStatus(id);
            return customerMapper.customerToCustomerResponse(customer);
        } catch (CustomerNotFoundException e) {
            log.info("Usuário não encontrado {}: ", id);
            throw new CustomerNotFoundException(e.getMessage());
        }
    }

    public void deactivateCustomer(Long id) {
        try {
            Customer customer = util.getCustomerByIdAndVerifyStatus(id);
            if (customer.isActive()) {
                customer.setActive(false);
                customer.setUpdatedAt(LocalDateTime.now());
                repository.save(customer);
                log.info("Usuário inativado com sucesso");
            }
            log.info("Usuário já está inativo");
        } catch (CustomerNotFoundException e) {
            log.info("Usuário não encontrado {}: ", id);
            throw new CustomerNotFoundException(e.getMessage());
        }
    }

    public void activateCustomer(Long id) {
        try {
            Customer customer = util.getCustomerByIdAndVerifyStatus(id);
            if (customer.isActive()) {
                customer.setActive(true);
                customer.setUpdatedAt(LocalDateTime.now());
                util.saveCustomer(customer);
                log.info("Usuário ativado com sucesso");
            }
            log.info("Usuário já está ativo");
        } catch (CustomerNotFoundException e) {
            log.info("Usuário não encontrado {}: ", id);
            throw new CustomerNotFoundException(e.getMessage());
        }
    }

}
