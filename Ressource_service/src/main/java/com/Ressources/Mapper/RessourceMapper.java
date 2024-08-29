package com.Ressources.Mapper;

import com.Ressources.Dto.RessourceDto;
import com.Ressources.Model.Ressource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RessourceMapper {


    RessourceDto toDto(Ressource ressource);
    Ressource toEntity(RessourceDto projetsDTO);
    List<RessourceDto> toDtoList(List<Ressource> projets);
    List<Ressource> toEntityList(List<RessourceDto> projetsDTOS);
}
