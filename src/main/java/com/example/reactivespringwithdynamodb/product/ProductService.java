package com.example.reactivespringwithdynamodb.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findProductById(String id, String sortKey) {
        return productRepository.findProductByIdAndName(id, sortKey);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}

