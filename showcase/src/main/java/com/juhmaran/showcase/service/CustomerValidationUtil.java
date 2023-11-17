package com.juhmaran.showcase.service;

import com.juhmaran.showcase.domain.dto.CustomerRequest;
import com.juhmaran.showcase.domain.model.Address;
import com.juhmaran.showcase.domain.model.Customer;
import com.juhmaran.showcase.exceptions.runtime.*;
import com.juhmaran.showcase.mapper.AddressMapper;
import com.juhmaran.showcase.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class CustomerValidationUtil {

    private final CustomerRepository repository;
    AddressMapper addressMapper;

    public CustomerValidationUtil(CustomerRepository repository) {
        this.repository = repository;
    }

    public void checkCustomerStatus(Customer customer) {
//        if (!customer.isActive()) {
//            throw new CustomerNotActiveException();
//        }
    }
    public void validateCustomerData(CustomerRequest customerRequest) {
        if (repository.existsByEmail(customerRequest.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        if (customerRequest.getDocumentNumber() == null) {
            throw new DocumentNumberCannotBeNullException();
        }

        if (repository.existsByDocumentNumber(customerRequest.getDocumentNumber())) {
            throw new DocumentNumberAlreadyExistsException();
        }
    }

    public Customer saveCustomer(Customer customer) {
        try {
            return repository.save(customer);
        } catch (InternalServerErrorException e) {
            log.info("Erro ao salvar o cliente {}: ", customer);
            throw new InternalServerErrorException("Erro ao salvar o cliente", e);
        }
    }

//    public void validateCustomerData(CustomerRequest customerRequest) {
//        if (repository.existsByEmail(customerRequest.getEmail())) {
//            throw new EmailAlreadyExistsException("O email já está em uso");
//        }
//
//        if (repository.existsByDocumentNumber(customerRequest.getDocumentNumber())) {
//            throw new DocumentNumberAlreadyExistsException("O documento já está em uso");
//        }
//    }
//
//    public Customer saveCustomer(Customer customer) {
//        try {
//            return repository.save(customer);
//        } catch (InternalServerErrorException e) {
//            log.info("Erro ao salvar o cliente {}: ", customer);
//            throw new InternalServerErrorException("Erro ao salvar o cliente", e);
//        }
//    }

    public Customer getCustomerByIdAndVerifyStatus(Long id) {
        try {
            Customer customer = repository.findById(id)
                    .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado"));
            if (!customer.isActive()) {
                throw new CustomerNotActiveException("O cliente não está ativo");
            }
            return customer;
        } catch (CustomerNotFoundException e) {
            log.info("Usuário não encontrado {}: ", id);
            throw new CustomerNotFoundException(e.getMessage());
        }
    }

    public void updateCustomerDetails(Customer customer, CustomerRequest customerRequest) {
        if (customer.getEmail().equals(customerRequest.getEmail())) {
            customer.setEmail(customerRequest.getEmail());
        } else {
            log.info("Email já cadastrado {}: ", customer.getEmail());
            throw new EmailNotChangeableException("O email não pode ser alterado");
        }

        if (customer.getDocumentNumber().equals(customerRequest.getDocumentNumber())) {
            customer.setDocumentNumber(customerRequest.getDocumentNumber());
        } else {
            log.info("Número de documento já cadastrado {}: ", customer.getDocumentNumber());
            throw new DocumentNumberNotChangeableException("O documento não pode ser alterado");
        }
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        Address address = addressMapper.addressRequestToAddress(customerRequest.getAddressRequest());
        customer.setAddress(address);
        customer.setUpdatedAt(LocalDateTime.now());
    }

}
