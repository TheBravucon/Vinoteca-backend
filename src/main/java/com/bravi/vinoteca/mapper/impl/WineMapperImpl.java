package com.bravi.vinoteca.mapper.impl;

import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.entity.Wine;
import com.bravi.vinoteca.mapper.WineMapper;
import org.springframework.stereotype.Component;

@Component
public class WineMapperImpl implements WineMapper {

    @Override
    public WineDTO toDTO(Wine wine) {
        return WineDTO.builder()
                .descripcion(wine.getDescripcion())
                .nombre(wine.getNombre())
                .bodega(wine.getBodega())
                .precio(wine.getPrecio())
                .tipo(wine.getTipo())
                .build();
    }

    @Override
    public Wine toEntity(WineRequestDTO request) {
        return Wine.builder()
                .descripcion(request.getDescripcion())
                .nombre(request.getNombre())
                .bodega(request.getBodega())
                .precio(request.getPrecio())
                .tipo(request.getTipo())
                .build();
    }

    @Override
    public void updateEntity(Wine wine, WineRequestDTO request) {
        wine.setBodega(request.getBodega());
        wine.setPrecio(request.getPrecio());
        wine.setNombre(request.getNombre());
        wine.setDescripcion(request.getDescripcion());
        wine.setTipo(request.getTipo());
    }
}
