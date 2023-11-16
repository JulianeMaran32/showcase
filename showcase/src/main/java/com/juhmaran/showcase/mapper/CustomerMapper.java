package com.juhmaran.showcase.mapper;

import com.juhmaran.showcase.domain.dto.CustomerRequest;
import com.juhmaran.showcase.domain.dto.CustomerResponse;
import com.juhmaran.showcase.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCIA = Mappers.getMapper(CustomerMapper.class);

    static CustomerMapper customerMapper() {
        return INSTANCIA;
    }

    // model > response
    CustomerResponse customerToCustomerResponse(Customer customer);

    // response > request
    CustomerRequest customerResponseToCustomerRequest(CustomerResponse customerResponse);

    // request > model
    Customer customerRequestToCustomer(CustomerRequest customerRequest);

}
