package com.mapsa.marketplace.marketplace.repository;

import com.mapsa.marketplace.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    void deleteById(long id);
}
