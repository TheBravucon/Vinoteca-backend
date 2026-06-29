package com.bravi.vinoteca.controller;

import com.bravi.vinoteca.dto.WineDTO;
import com.bravi.vinoteca.dto.WineRequestDTO;
import com.bravi.vinoteca.service.WineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vinos")
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping
    public List<WineDTO> listarTodos() {
        return wineService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> crear(@Valid @RequestBody WineRequestDTO request) {
        wineService.createWine(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(wineService.findById(id));
    }

    @PatchMapping
    public ResponseEntity<Void> actualizar(@Valid @RequestBody WineRequestDTO request) {
        wineService.updateWine(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        wineService.deleteWine(id);
        return ResponseEntity.ok().build();
    }
}