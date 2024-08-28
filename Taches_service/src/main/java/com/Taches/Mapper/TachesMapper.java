package com.Taches.Mapper;

import com.Taches.Dto.TachesDto;
import com.Taches.Model.Taches;
import org.mapstruct.MappingTarget;

public interface TachesMapper {

    TachesDto toDto(Taches taches);
    Taches toEntity(TachesDto tachesDto);
    void updateEntityFromDto(TachesDto dto, @MappingTarget Taches entity);
}
