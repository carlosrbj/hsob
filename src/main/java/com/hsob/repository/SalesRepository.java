package com.hsob.repository;

import com.hsob.model.sales.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author carlos
 */

@Repository
public interface SalesRepository extends MongoRepository<Sales, String> {
}
