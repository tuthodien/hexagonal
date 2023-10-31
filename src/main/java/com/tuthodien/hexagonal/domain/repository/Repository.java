package com.tuthodien.hexagonal.domain.repository;

import java.util.Optional;
import java.util.UUID;

public interface Repository<T, U> {
   T save(T t);

    Optional<T> findById(U id);
}
