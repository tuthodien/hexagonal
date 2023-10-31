package com.tuthodien.hexagonal.application.mapper;

import com.tuthodien.hexagonal.application.dto.ProductDTO;
import com.tuthodien.hexagonal.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper extends DTOMapper<ProductDTO, Product> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
