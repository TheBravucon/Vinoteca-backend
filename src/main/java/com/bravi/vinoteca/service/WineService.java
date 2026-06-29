package com.bravi.vinoteca.service;

import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.dto.WineRequestDTO;

import java.util.List;

public interface WineService {

    WineDTO findById(Long wineId);

    void createWine(WineRequestDTO request);

    void updateWine(WineRequestDTO request);

    void deleteWine(Long wineId);

    List<WineDTO> findAll();

}
