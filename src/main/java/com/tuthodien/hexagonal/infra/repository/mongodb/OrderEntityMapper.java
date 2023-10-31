package com.tuthodien.hexagonal.infra.repository.mongodb;

import com.tuthodien.hexagonal.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {
    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

    OrderEntity toEntity(Order order);

    Order toModel(OrderEntity entity);
}
