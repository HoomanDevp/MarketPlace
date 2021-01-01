package com.mapsa.marketplace.marketplace.repository;

import com.mapsa.marketplace.marketplace.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
}
