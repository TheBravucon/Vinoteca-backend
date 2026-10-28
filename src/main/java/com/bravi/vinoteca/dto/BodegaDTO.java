package com.bravi.vinoteca.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodegaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String pais;
    private String imagenUrl;
    private Boolean destacada;
    private Boolean activo;
}
