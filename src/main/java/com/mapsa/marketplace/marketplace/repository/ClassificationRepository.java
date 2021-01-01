package com.mapsa.marketplace.marketplace.repository;
import com.mapsa.marketplace.marketplace.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification,Integer> { }
