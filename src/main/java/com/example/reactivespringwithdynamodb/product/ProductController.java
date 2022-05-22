package com.example.reactivespringwithdynamodb.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String productId) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @PostMapping("/products")
    public ResponseEntity<?> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(ResponseEntity.noContent().build());
    }
}
