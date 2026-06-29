package com.bravi.vinoteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "wine")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    private String bodega;
    private String tipo;
    private Double precio;

    @Column(length = 1000)
    private String descripcion;
    private String imagenUrl;
}