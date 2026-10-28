package com.bravi.vinoteca.mapper;

import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.entity.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WineMapper {

    WineMapper INSTANCE = Mappers.getMapper(WineMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaModificacion", ignore = true)
    Wine toEntity(WineRequestDTO request);

    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaModificacion", ignore = true)
    void updateEntity(@MappingTarget Wine wine, WineRequestDTO request);

    WineDTO toDTO(Wine wine);
}
