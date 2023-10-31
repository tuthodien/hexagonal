package com.tuthodien.hexagonal.infra.repository.rest;

import com.tuthodien.hexagonal.domain.model.Product;
import com.tuthodien.hexagonal.domain.repository.InventoryRepository;

import java.util.Optional;
import java.util.UUID;

public class RestInventoryRepository implements InventoryRepository {
    @Override
    public Optional<Product> getProduct(UUID id) {
        return Optional.empty();
    }
}
