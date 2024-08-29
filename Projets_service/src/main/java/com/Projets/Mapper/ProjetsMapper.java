package com.Projets.Mapper;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Model.Projets;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjetsMapper {

        ProjetsDTO toDto(Projets projet);
        Projets toEntity(ProjetsDTO projetsDTO);
        List<ProjetsDTO> toDtoList(List<Projets> projets);
        List<Projets> toEntityList(List<ProjetsDTO> projetsDTOS);

}
