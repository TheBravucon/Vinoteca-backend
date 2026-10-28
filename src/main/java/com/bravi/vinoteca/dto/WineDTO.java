package com.bravi.vinoteca.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineDTO {
    private Long id;
    private String nombre;
    private Long bodegaId;
    private String tipo;
    private Double precio;
    private String descripcion;
    private String imagenUrl;
    private Integer stock;
    private Boolean activo;
}
