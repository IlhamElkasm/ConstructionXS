package com.Taches.Mapper;

import com.Taches.Dto.TachesDto;
import com.Taches.Model.Taches;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TachesMapper {

    TachesDto toDto(Taches taches);
    Taches toEntity(TachesDto tachesDto);
    void updateEntityFromDto(TachesDto dto, @MappingTarget Taches entity);
    List<TachesDto> toDtoList(List<Taches> taches);
    List<Taches> toEntityList(List<TachesDto> tachesDtos);
}
