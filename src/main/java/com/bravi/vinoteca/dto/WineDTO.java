package com.bravi.vinoteca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WineDTO {

    private String nombre;
    private String bodega;
    private String tipo;
    private Double precio;
    private String descripcion;
    private String imagenUrl;

}