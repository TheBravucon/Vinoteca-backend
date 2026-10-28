package com.bravi.vinoteca.service;

import com.bravi.vinoteca.dto.BodegaRequestDTO;
import com.bravi.vinoteca.dto.BodegaDTO;
import com.bravi.vinoteca.entity.Bodega;
import com.bravi.vinoteca.mapper.BodegaMapper;
import com.bravi.vinoteca.repository.BodegaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaService {

    private final BodegaRepository bodegaRepository;
    private final BodegaMapper bodegaMapper;

    public List<BodegaDTO> getAllActiveBodegas() {
        return bodegaRepository.findByActivoTrue().stream()
                .map(this::toDTO)
                .toList();
    }

    public List<BodegaDTO> getDestacadaBodegas() {
        return bodegaRepository.findByDestacadaTrueAndActivoTrue().stream()
                .map(this::toDTO)
                .toList();
    }

    public BodegaDTO getBodegaById(Long id) {
        Bodega bodega = bodegaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada con id: " + id));
        return toDTO(bodega);
    }

    public List<BodegaDTO> searchBodegas(String search) {
        return bodegaRepository.searchActiveBodegas(search).stream()
                .map(this::toDTO)
                .toList();
    }

    public BodegaDTO createBodega(BodegaRequestDTO request) {
        Bodega bodega = bodegaMapper.toEntity(request);
        bodega.setDestacada(false);
        bodega.setActivo(true);
        Bodega saved = bodegaRepository.save(bodega);
        return toDTO(saved);
    }

    public BodegaDTO updateBodega(Long id, BodegaRequestDTO request) {
        Bodega bodega = bodegaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada con id: " + id));
        bodegaMapper.updateEntity(bodega, request);
        bodega.setFechaModificacion(LocalDateTime.now());
        Bodega updated = bodegaRepository.save(bodega);
        return toDTO(updated);
    }

    public void deleteBodega(Long id) {
        Bodega bodega = bodegaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada con id: " + id));
        bodega.setActivo(false);
        bodega.setFechaModificacion(LocalDateTime.now());
        bodegaRepository.save(bodega);
    }

    private BodegaDTO toDTO(Bodega bodega) {
        return BodegaDTO.builder()
                .id(bodega.getId())
                .nombre(bodega.getNombre())
                .descripcion(bodega.getDescripcion())
                .ubicacion(bodega.getUbicacion())
                .pais(bodega.getPais())
                .imagenUrl(bodega.getImagenUrl())
                .destacada(bodega.getDestacada())
                .activo(bodega.getActivo())
                .build();
    }
}
