package com.tuthodien.hexagonal.domain.repository;

import com.tuthodien.hexagonal.domain.model.Order;

import java.util.UUID;

public interface OrderRepository extends Repository<Order, UUID> {
}
