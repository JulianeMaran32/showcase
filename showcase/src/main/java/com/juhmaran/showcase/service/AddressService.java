package com.juhmaran.showcase.service;

import com.juhmaran.showcase.domain.dto.AddressRequest;
import com.juhmaran.showcase.domain.model.Address;
import com.juhmaran.showcase.mapper.AddressMapper;
import com.juhmaran.showcase.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Service
//@RequiredArgsConstructor
public class AddressService {

//    private final AddressRepository repository;
//    AddressMapper mapper;
//
//    /**
//     * COMPARAÇÃO DOS CAMPOS
//     */
//
//    public String isNumberEqual(AddressRequest request) {
//
//        Address address = mapper.addressRequestToAddress(request);
//
//        if (request.getNumber() != null && (request.getNumber().equals(address.getNumber()))) {
//            return "true";
//        }
//
//        if (request.getNumber() != null) {
//            return "false";
//        }
//
//        return "not_available";
//
//    }
//
//    public String isZipCodeEqual(AddressRequest request) {
//
//        Address address = mapper.addressRequestToAddress(request);
//
//        if (request.getZipCode() != null && (request.getZipCode().equals(address.getZipCode()))) {
//            return "true";
//        }
//
//        if (request.getZipCode() != null) {
//            return "false";
//        }
//
//        return "not_available";
//
//    }
//
//    public String isStreetEqual(AddressRequest request) {
//
//        Address address = mapper.addressRequestToAddress(request);
//
//        if (request.getStreet() != null && (request.getStreet().equals(address.getStreet()))) {
//            return "true";
//        }
//
//        if (request.getStreet() != null) {
//            return "false";
//        }
//
//        return "not_available";
//
//    }

}
