package com.tuthodien.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    private UUID productId;
    private String productName;
    private Long price;
    private Integer quantity;

    public OrderLine(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), 1);
    }

    public Integer plus() {
        return this.quantity++;
    }

    public Integer minus(){
        return this.quantity--;
    }
}
