package com.juhmaran.showcase.repository;

import com.juhmaran.showcase.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
