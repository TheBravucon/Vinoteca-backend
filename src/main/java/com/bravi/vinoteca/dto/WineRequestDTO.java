package com.bravi.vinoteca.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    private Long bodegaId;
    private String tipo;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    private String descripcion;
    private String imagenUrl;
    private Integer stock;
    private Boolean activo;
}
