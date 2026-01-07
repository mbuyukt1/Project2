package com.example.task2.api;

import com.example.task2.domain.Product;
import com.example.task2.repository.ProductRepository;
import com.example.task2.dto.ProductRequest;
import com.example.task2.dto.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    @Operation(summary = "Get all products", description = "Lists all products in the database")
    public List<ProductResponse> getAll() {
        return repository.findAll().stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setPrice(product.getPrice());
            return response;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @Operation(summary = "Add new product", description = "Creates a new product and saves it to H2 database")
    public ProductResponse create(@RequestBody ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        Product savedProduct = repository.save(product);

        ProductResponse response = new ProductResponse();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setPrice(savedProduct.getPrice());
        return response;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product", description = "Updates an existing product by its ID")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest request) {
        return repository.findById(id).map(product -> {
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            Product updated = repository.save(product);

            ProductResponse response = new ProductResponse();
            response.setId(updated.getId());
            response.setName(updated.getName());
            response.setPrice(updated.getPrice());
            return response;
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product", description = "Removes a product from the database")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}