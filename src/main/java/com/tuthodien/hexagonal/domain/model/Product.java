package com.tuthodien.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID id;
    private Long price;
    private String name;

    public boolean equals(Product product) {
        return this.id.compareTo(product.id) == 0;
    }
}
