package com.tuthodien.hexagonal.infra.repository.mongodb;

import com.tuthodien.hexagonal.domain.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReactiveMongoOrderRepository extends ReactiveMongoRepository<OrderEntity, String> {
   // Mono<OrderEntity> findByUuid(String uuid);
}
