package com.store.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.pos.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}