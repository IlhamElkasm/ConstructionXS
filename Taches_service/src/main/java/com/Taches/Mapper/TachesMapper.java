package com.Taches.Mapper;

import com.Taches.Dto.TachesDto;
import com.Taches.Model.Taches;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TachesMapper {

    TachesDto toDto(Taches taches);
    Taches toEntity(TachesDto tachesDto);
}
