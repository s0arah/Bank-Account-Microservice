package com.benmessaoud.comptemicroservice.repository;

import com.benmessaoud.comptemicroservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
}
