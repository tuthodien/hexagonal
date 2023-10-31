package com.tuthodien.hexagonal.application.mapper;

import org.mapstruct.Mapper;

import java.util.List;


public interface DTOMapper<DTO, Model> {
    DTO toDTO(Model model);

    List<DTO> toDTOList(List<Model> models);

    Model toModel(DTO dto);

    List<Model> toModelList(List<DTO> dtos);
}
