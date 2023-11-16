package com.juhmaran.showcase.mapper;

import com.juhmaran.showcase.domain.dto.AddressRequest;
import com.juhmaran.showcase.domain.dto.AddressResponse;
import com.juhmaran.showcase.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCIA = Mappers.getMapper(AddressMapper.class);

    static AddressMapper addressMapper() {
        return INSTANCIA;
    }

    // model > response
    AddressResponse addressToAddressResponse(Address address);

    // response > request
    AddressRequest addressResponseToAddressRequest(AddressResponse addressResponse);

    // request > model
    Address addressRequestToAddress(AddressRequest addressRequest);

}
