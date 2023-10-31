package com.tuthodien.hexagonal.domain.repository;

import com.tuthodien.hexagonal.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface InventoryRepository {
    public Optional<Product> getProduct(UUID id);
}
