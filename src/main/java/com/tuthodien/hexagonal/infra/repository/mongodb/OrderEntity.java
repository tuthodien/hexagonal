package com.tuthodien.hexagonal.infra.repository.mongodb;

import com.tuthodien.hexagonal.domain.model.Order;
import com.tuthodien.hexagonal.domain.model.OrderLine;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "order")
public class OrderEntity {
    @Id
    String id;

    private List<OrderLine> orderLines;

    private Order.Status status;

    private Long amount;
}
