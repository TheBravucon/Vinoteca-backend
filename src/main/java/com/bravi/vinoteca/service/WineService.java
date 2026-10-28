package com.bravi.vinoteca.service;

import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.entity.Wine;
import com.bravi.vinoteca.mapper.WineMapper;
import com.bravi.vinoteca.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {

    private final WineRepository wineRepository;
    private final WineMapper wineMapper;

    public List<WineDTO> getAllActiveWines() {
        return wineRepository.findByActivoTrue().stream()
                .map(this::toDTO)
                .toList();
    }

    public WineDTO getWineById(Long id) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vino no encontrado con id: " + id));
        return toDTO(wine);
    }

    public List<WineDTO> getWinesByBodegaId(Long bodegaId) {
        return wineRepository.findByBodegaIdAndActivoTrue(bodegaId).stream()
                .map(this::toDTO)
                .toList();
    }

    public List<WineDTO> searchWines(String search) {
        return wineRepository.searchActiveWines(search).stream()
                .map(this::toDTO)
                .toList();
    }

    public List<WineDTO> searchWinesByBodega(Long bodegaId, String search) {
        return wineRepository.searchByBodegaId(bodegaId, search).stream()
                .map(this::toDTO)
                .toList();
    }

    public WineDTO createWine(WineRequestDTO request) {
        Wine wine = wineMapper.toEntity(request);
        if (wine.getActivo() == null) {
            wine.setActivo(true);
        }
        Wine saved = wineRepository.save(wine);
        return toDTO(saved);
    }

    public WineDTO updateWine(Long id, WineRequestDTO request) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vino no encontrado con id: " + id));
        wineMapper.updateEntity(wine, request);
        wine.setFechaModificacion(LocalDateTime.now());
        Wine updated = wineRepository.save(wine);
        return toDTO(updated);
    }

    public void deleteWine(Long id) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vino no encontrado con id: " + id));
        wine.setActivo(false);
        wine.setFechaModificacion(LocalDateTime.now());
        wineRepository.save(wine);
    }

    private WineDTO toDTO(Wine wine) {
        return WineDTO.builder()
                .id(wine.getId())
                .nombre(wine.getNombre())
                .bodegaId(wine.getBodegaId())
                .tipo(wine.getTipo())
                .precio(wine.getPrecio())
                .descripcion(wine.getDescripcion())
                .imagenUrl(wine.getImagenUrl())
                .stock(wine.getStock())
                .activo(wine.getActivo())
                .build();
    }
}
