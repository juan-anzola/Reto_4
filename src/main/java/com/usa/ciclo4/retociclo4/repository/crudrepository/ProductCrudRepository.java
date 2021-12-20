package com.usa.ciclo4.retociclo4.repository.crudrepository;

import com.usa.ciclo4.retociclo4.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductCrudRepository extends MongoRepository<Product, String> {
    public List<Product> findByPriceLessThanEqual(double price);
    public List<Product> findByDescriptionContainingIgnoreCase(String description);
}
