package com.tuthodien.hexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private UUID id;
    private OrderDTO.Status status;
    private Long amount;

    public enum Status {CREATED, COMPLETED}
}
