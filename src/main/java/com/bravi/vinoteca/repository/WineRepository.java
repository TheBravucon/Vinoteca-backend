package com.bravi.vinoteca.repository;

import com.bravi.vinoteca.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    List<Wine> findByActivoTrue();

    List<Wine> findByBodegaIdAndActivoTrue(Long bodegaId);

    @Query("SELECT w FROM Wine w WHERE w.activo = true AND " +
           "(LOWER(w.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(w.tipo) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(w.descripcion) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Wine> searchActiveWines(@Param("search") String search);

    @Query("SELECT w FROM Wine w WHERE w.activo = true AND w.bodegaId = :bodegaId " +
           "AND (LOWER(w.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(w.tipo) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Wine> searchByBodegaId(@Param("bodegaId") Long bodegaId, @Param("search") String search);
}
