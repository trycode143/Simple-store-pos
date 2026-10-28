package com.store.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.store.pos.entity.Product;
import com.store.pos.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        product.setId(0);
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(int id, Product updated) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setPrice(updated.getPrice());
            existing.setQuantity(updated.getQuantity());
            return productRepository.save(existing);
        });
    }

    public boolean deleteProduct(int id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}