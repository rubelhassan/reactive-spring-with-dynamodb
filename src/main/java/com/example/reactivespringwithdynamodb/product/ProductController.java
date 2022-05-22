package com.example.reactivespringwithdynamodb.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}/{sk}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String productId, @PathVariable("sk") String sortKey) {
        return ResponseEntity.ok(productService.findProductById(productId, sortKey));
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
