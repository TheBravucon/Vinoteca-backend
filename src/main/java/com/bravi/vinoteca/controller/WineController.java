package com.bravi.vinoteca.controller;

import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.service.WineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vinos")
@RequiredArgsConstructor
public class WineController {

    private final WineService wineService;

    @GetMapping
    public ResponseEntity<List<WineDTO>> getAllActiveWines() {
        return ResponseEntity.ok(wineService.getAllActiveWines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineDTO> getWineById(@PathVariable Long id) {
        return ResponseEntity.ok(wineService.getWineById(id));
    }

    @GetMapping("/bodega/{bodegaId}")
    public ResponseEntity<List<WineDTO>> getWinesByBodegaId(@PathVariable Long bodegaId) {
        return ResponseEntity.ok(wineService.getWinesByBodegaId(bodegaId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<WineDTO>> searchWines(@RequestParam String search) {
        return ResponseEntity.ok(wineService.searchWines(search));
    }

    @GetMapping("/bodega/{bodegaId}/search")
    public ResponseEntity<List<WineDTO>> searchWinesByBodega(
            @PathVariable Long bodegaId,
            @RequestParam String search) {
        return ResponseEntity.ok(wineService.searchWinesByBodega(bodegaId, search));
    }

    @PostMapping
    public ResponseEntity<WineDTO> createWine(@Valid @RequestBody WineRequestDTO request) {
        return ResponseEntity.ok(wineService.createWine(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WineDTO> updateWine(@PathVariable Long id, @Valid @RequestBody WineRequestDTO request) {
        return ResponseEntity.ok(wineService.updateWine(id, request));
    }

    @PatchMapping("/{id}/toggle-activo")
    public ResponseEntity<WineDTO> toggleActivo(@PathVariable Long id) {
        WineDTO wine = wineService.getWineById(id);
        WineRequestDTO request = WineRequestDTO.builder()
                .nombre(wine.getNombre())
                .bodegaId(wine.getBodegaId())
                .tipo(wine.getTipo())
                .precio(wine.getPrecio())
                .descripcion(wine.getDescripcion())
                .imagenUrl(wine.getImagenUrl())
                .stock(wine.getStock())
                .activo(!wine.getActivo())
                .build();
        return ResponseEntity.ok(wineService.updateWine(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWine(@PathVariable Long id) {
        wineService.deleteWine(id);
        return ResponseEntity.noContent().build();
    }
}
