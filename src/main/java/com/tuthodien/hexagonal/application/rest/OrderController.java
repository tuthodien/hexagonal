package com.tuthodien.hexagonal.application.rest;

import com.tuthodien.hexagonal.application.dto.OrderDTO;
import com.tuthodien.hexagonal.application.dto.ProductDTO;
import com.tuthodien.hexagonal.application.mapper.OrderMapper;
import com.tuthodien.hexagonal.application.mapper.ProductMapper;
import com.tuthodien.hexagonal.domain.model.Order;
import com.tuthodien.hexagonal.domain.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody ProductDTO product) {
        Order order = orderService.createOrder(ProductMapper.INSTANCE.toModel(product));

        return OrderMapper.INSTANCE.toDTO(order);
    }

    @PostMapping("/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO addProduct(@PathVariable UUID id, @RequestBody ProductDTO product) {
        Order order = orderService.addProduct(id, ProductMapper.INSTANCE.toModel(product));
        return OrderMapper.INSTANCE.toDTO(order);
    }

    @PostMapping("/{id}/complete")
    public void completeOrder(@PathVariable UUID id) {
        orderService.completeOrder(id);
    }


}
