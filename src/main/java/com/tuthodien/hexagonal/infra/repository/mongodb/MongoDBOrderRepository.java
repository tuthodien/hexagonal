package com.tuthodien.hexagonal.infra.repository.mongodb;

import com.tuthodien.hexagonal.domain.model.Order;
import com.tuthodien.hexagonal.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoDBOrderRepository implements OrderRepository {
    private final ReactiveMongoOrderRepository repository;
    private final OrderEntityMapper mapper;

    public MongoDBOrderRepository(ReactiveMongoOrderRepository repository, OrderEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Order save(Order order) {
        return repository.save(mapper.toEntity(order))
                .map(mapper::toModel)
                .block();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return repository.findById(id.toString())
                .map(mapper::toModel)
                .blockOptional();
    }
}
