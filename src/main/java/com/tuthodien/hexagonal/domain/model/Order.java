package com.tuthodien.hexagonal.domain.model;

import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
public class Order {
    private UUID id;

    private List<OrderLine> orderLines;

    private Status status;

    private Long amount;

    public Order(UUID id, Product product) {
        this.id = id;
        this.orderLines = Collections.singletonList(new OrderLine(product));
        this.amount = product.getPrice();
        this.status = Status.CREATED;
    }

    public void complete() {
        this.status = Status.COMPLETED;
    }

    public void add(Product product) {
        if (this.status.equals(Status.COMPLETED)) {
            throw new RuntimeException("The order is already completed");
        }

        Optional<OrderLine> line = this.findOrderLine(product.getId());
        if (line.isPresent()) {
            line.get().plus();
        } else {
            this.orderLines.add(new OrderLine(product));
        }
        this.amount += product.getPrice();
    }

    public void remove(Product product) {
        if (this.status.equals(Status.COMPLETED)) {
            throw new RuntimeException("The order is already completed");
        }

        OrderLine line = this.findOrderLine(product.getId()).orElseThrow();
        this.orderLines.remove(line);
        this.amount -= (line.getPrice() * line.getQuantity());
    }

    private Optional<OrderLine> findOrderLine(UUID id) {
        return this.orderLines.stream()
                .filter(line -> line.getProductId().equals(id))
                .findFirst();
    }

    public enum Status {CREATED, COMPLETED}
}
