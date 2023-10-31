package com.tuthodien.hexagonal.infra.config;

import com.tuthodien.hexagonal.HexagonalApplication;
import com.tuthodien.hexagonal.domain.repository.InventoryRepository;
import com.tuthodien.hexagonal.domain.repository.OrderRepository;
import com.tuthodien.hexagonal.domain.service.OrderService;
import com.tuthodien.hexagonal.infra.repository.rest.RestInventoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalApplication.class)
public class BeanConfiguration {
    @Bean
    OrderService orderService(OrderRepository orderRepository, InventoryRepository inventoryRepository) {
        return new OrderService(orderRepository, inventoryRepository);
    }

    @Bean
    InventoryRepository inventoryRepository() {
        return new RestInventoryRepository();
    }
}
