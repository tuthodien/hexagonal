package com.tuthodien.hexagonal.application.mapper;

import com.tuthodien.hexagonal.application.dto.OrderDTO;
import com.tuthodien.hexagonal.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper extends DTOMapper<OrderDTO, Order> {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
