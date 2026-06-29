package com.bravi.vinoteca.mapper;

import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.entity.Wine;

public interface WineMapper {

    WineDTO toDTO(Wine wine);

    Wine toEntity(WineRequestDTO request);

    void updateEntity(Wine wine, WineRequestDTO request);
}
