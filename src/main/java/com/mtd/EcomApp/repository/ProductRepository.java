package com.mtd.EcomApp.repository;

import com.mtd.EcomApp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Spring Data will automatically create methods for CRUD operations.
    // You can add custom query methods here later.
}