package com.bravi.vinoteca.mapper;

import com.bravi.vinoteca.dto.BodegaRequestDTO;
import com.bravi.vinoteca.dto.BodegaDTO;
import com.bravi.vinoteca.entity.Bodega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BodegaMapper {

    BodegaMapper INSTANCE = Mappers.getMapper(BodegaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaModificacion", ignore = true)
    Bodega toEntity(BodegaRequestDTO request);

    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaModificacion", ignore = true)
    void updateEntity(@MappingTarget Bodega bodega, BodegaRequestDTO request);

    BodegaDTO toDTO(Bodega bodega);
}
