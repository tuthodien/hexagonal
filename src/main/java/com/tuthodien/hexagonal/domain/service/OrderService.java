package com.tuthodien.hexagonal.domain.service;

import com.tuthodien.hexagonal.domain.model.Order;
import com.tuthodien.hexagonal.domain.model.Product;
import com.tuthodien.hexagonal.domain.repository.InventoryRepository;
import com.tuthodien.hexagonal.domain.repository.OrderRepository;

import java.util.UUID;

public class OrderService {

    private OrderRepository orderRepository;
    private InventoryRepository inventoryRepository;

    public OrderService(OrderRepository orderRepository, InventoryRepository inventoryRepository) {
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Order createOrder(Product product) {
        Order order = new Order(UUID.randomUUID(), product);
        return this.orderRepository.save(order);
    }

    public Order addProduct(UUID id, Product product) {

        Product product1 = inventoryRepository.getProduct(product.getId()).orElseThrow();

        Order order = this.orderRepository.findById(id).orElseThrow();


        order.add(product);

        return this.orderRepository.save(order);
    }

    public void completeOrder(UUID uuid) {
        Order order = this.orderRepository.findById(uuid).orElseThrow();
        order.complete();

        this.orderRepository.save(order);

    }
}
