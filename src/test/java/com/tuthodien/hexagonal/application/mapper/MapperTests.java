package com.tuthodien.hexagonal.application.mapper;

import com.tuthodien.hexagonal.application.dto.OrderDTO;
import com.tuthodien.hexagonal.application.dto.ProductDTO;
import com.tuthodien.hexagonal.domain.model.Order;
import com.tuthodien.hexagonal.domain.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class MapperTests {

    @Test
    public void productMapperTest() {
        ProductDTO productDTO = new ProductDTO(UUID.randomUUID(), 9988989L, "Some test prod");
        Product product = ProductMapper.INSTANCE.toModel(productDTO);

        Assertions.assertEquals(productDTO.id(), product.getId());
        Assertions.assertEquals(productDTO.name(), product.getName());
        Assertions.assertEquals(productDTO.price(), product.getPrice());
    }

    @Test
    public void orderMapperTest() {

        Order order = new Order(UUID.randomUUID(), new Product(UUID.randomUUID(), 9988989L, "Some test prod"));
        OrderDTO dto = OrderMapper.INSTANCE.toDTO(order);

        Assertions.assertEquals(dto.getId(), order.getId());
        Assertions.assertEquals(dto.getAmount(), order.getAmount());
        Assertions.assertEquals(dto.getStatus(), order.getStatus());
    }
}
