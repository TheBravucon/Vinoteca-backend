package com.bravi.vinoteca.controller;

import com.bravi.vinoteca.dto.BodegaDTO;
import com.bravi.vinoteca.dto.BodegaRequestDTO;
import com.bravi.vinoteca.service.BodegaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bodegas")
@RequiredArgsConstructor
public class BodegaController {

    private final BodegaService bodegaService;

    @GetMapping
    public ResponseEntity<List<BodegaDTO>> getAllActiveBodegas() {
        return ResponseEntity.ok(bodegaService.getAllActiveBodegas());
    }

    @GetMapping("/destacadas")
    public ResponseEntity<List<BodegaDTO>> getDestacadaBodegas() {
        return ResponseEntity.ok(bodegaService.getDestacadaBodegas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaDTO> getBodegaById(@PathVariable Long id) {
        return ResponseEntity.ok(bodegaService.getBodegaById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BodegaDTO>> searchBodegas(@RequestParam String search) {
        return ResponseEntity.ok(bodegaService.searchBodegas(search));
    }

    @PostMapping
    public ResponseEntity<BodegaDTO> createBodega(@Valid @RequestBody BodegaRequestDTO request) {
        return ResponseEntity.ok(bodegaService.createBodega(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaDTO> updateBodega(@PathVariable Long id, @Valid @RequestBody BodegaRequestDTO request) {
        return ResponseEntity.ok(bodegaService.updateBodega(id, request));
    }

    @PatchMapping("/{id}/toggle-destacada")
    public ResponseEntity<BodegaDTO> toggleDestacada(@PathVariable Long id) {
        BodegaDTO bodega = bodegaService.getBodegaById(id);
        BodegaRequestDTO request = BodegaRequestDTO.builder()
                .nombre(bodega.getNombre())
                .descripcion(bodega.getDescripcion())
                .ubicacion(bodega.getUbicacion())
                .pais(bodega.getPais())
                .imagenUrl(bodega.getImagenUrl())
                .destacada(!bodega.getDestacada())
                .activo(bodega.getActivo())
                .build();
        return ResponseEntity.ok(bodegaService.updateBodega(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodega(@PathVariable Long id) {
        bodegaService.deleteBodega(id);
        return ResponseEntity.noContent().build();
    }
}
