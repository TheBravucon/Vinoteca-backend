package com.bravi.vinoteca.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodegaRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String pais;
    private String imagenUrl;
    private Boolean destacada;
    private Boolean activo;
}
