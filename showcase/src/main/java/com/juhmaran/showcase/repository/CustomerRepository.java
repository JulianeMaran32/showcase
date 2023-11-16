package com.juhmaran.showcase.repository;

import com.juhmaran.showcase.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByDocumentNumber(String documentNumber);

}
