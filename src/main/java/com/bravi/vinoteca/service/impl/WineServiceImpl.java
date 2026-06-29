package com.bravi.vinoteca.service.impl;

import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.entity.Wine;
import com.bravi.vinoteca.mapper.WineMapper;
import com.bravi.vinoteca.repository.WineRepository;
import com.bravi.vinoteca.service.WineService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineServiceImpl implements WineService {

    private final WineRepository wineRepository;
    private final WineMapper wineMapper;

    public WineServiceImpl(WineRepository wineRepository, WineMapper wineMapper) {
        this.wineRepository = wineRepository;
        this.wineMapper = wineMapper;
    }

    @Override
    public List<WineDTO> findAll() {
        return wineRepository.findAll().stream().map(wineMapper::toDTO).toList();
    }

    @Override
    public WineDTO findById(Long wineId) {
        return wineRepository.findById(wineId).map(wineMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Wine not found for id: " + wineId));
    }

    @Override
    public void createWine(WineRequestDTO request) {
        Wine wine = wineMapper.toEntity(request);
        wineRepository.save(wine);
    }

    @Override
    public void updateWine(WineRequestDTO request) {
        Wine wine = wineRepository.findById(request.getWineId())
                .orElseThrow(() -> new EntityNotFoundException("Wine not found for id: " + request.getWineId()));

        wineMapper.updateEntity(wine, request);
        wineRepository.save(wine);
    }

    @Override
    public void deleteWine(Long wineId) {
        Wine wine = wineRepository.findById(wineId)
                .orElseThrow(() -> new EntityNotFoundException("Wine not found for id: " + wineId));
        wineRepository.delete(wine);
    }
}
