package com.tuthodien.hexagonal.domain.service;

import com.tuthodien.hexagonal.domain.model.Order;
import com.tuthodien.hexagonal.domain.model.Product;
import com.tuthodien.hexagonal.domain.repository.InventoryRepository;
import com.tuthodien.hexagonal.domain.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

public class OrderServiceTests {
    private OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
    private InventoryRepository inventoryRepository = Mockito.mock(InventoryRepository.class);
    private OrderService orderService = new OrderService(orderRepository, inventoryRepository);

    @Test
    public void createOrder() {
        Product product = new Product(UUID.randomUUID(), 100001L, "PRODUCT NAME");
        Order order = orderService.createOrder(product);

        Mockito.verify(orderRepository).save(ArgumentMatchers.any(Order.class));

    }

    @Test
    public void completeOrder() {
        Order order = Mockito.spy(new Order(UUID.randomUUID(), new Product(UUID.randomUUID(), 100001L, "PRODUCT NAME")));
        Mockito.when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));

        orderService.completeOrder(order.getId());
        Mockito.verify(orderRepository).save(ArgumentMatchers.any(Order.class));
        Mockito.verify(order).complete();

    }
}
