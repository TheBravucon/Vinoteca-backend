package com.bravi.vinoteca.repository;

import com.bravi.vinoteca.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {

    List<Bodega> findByActivoTrue();

    List<Bodega> findByDestacadaTrueAndActivoTrue();

    @Query("SELECT b FROM Bodega b WHERE b.activo = true AND " +
           "(LOWER(b.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(b.descripcion) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(b.pais) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Bodega> searchActiveBodegas(@Param("search") String search);
}
