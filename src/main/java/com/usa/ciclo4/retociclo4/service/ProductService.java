package com.usa.ciclo4.retociclo4.service;

import com.usa.ciclo4.retociclo4.model.Product;
import com.usa.ciclo4.retociclo4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(String reference){
        return productRepository.getProduct(reference);
    }

    public Product save(Product product){
        if(product.getReference() == null) {
            return product;
        }else{
            return productRepository.save(product);
        }
    }

    public Product update(Product product) {

        if (product.getReference() != null) {
            Optional<Product> dbProduct = productRepository.getProduct(product.getReference());
            if (!dbProduct.isEmpty()) {

                /*if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }*/
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                /*if (product.getPresentation() != null) {
                    dbProduct.get().setPresentation(product.getPresentation());
                }*/

                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                        dbProduct.get().setPhotography(product.getPhotography());
                    }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference){
        return getProduct(reference).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }
}
