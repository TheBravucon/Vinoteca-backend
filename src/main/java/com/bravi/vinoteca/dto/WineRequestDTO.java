package com.bravi.vinoteca.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WineRequestDTO {

    private Long wineId;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La bodega es obligatoria")
    private String bodega;

    private String tipo;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @Column(length = 1000)
    private String descripcion;

    private String imagenUrl;
}
