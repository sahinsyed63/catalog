package com.example.catalog.service;

import com.example.catalog.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    Product addProduct(Product product);
    void deleteProduct(Long id);
}
