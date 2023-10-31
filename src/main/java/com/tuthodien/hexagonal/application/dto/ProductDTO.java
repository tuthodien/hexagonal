package com.tuthodien.hexagonal.application.dto;

import java.util.UUID;

public record ProductDTO(UUID id, Long price, String name) {
}
