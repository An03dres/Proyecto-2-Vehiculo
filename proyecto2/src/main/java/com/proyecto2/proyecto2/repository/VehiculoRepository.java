package com.proyecto2.proyecto2.repository;

import com.proyecto2.proyecto2.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT AVG(v.potencia) FROM Vehiculo v WHERE v.tipo = ?1")
    Double findAveragePowerByType(String tipo);

    @Query("SELECT MAX(v.potencia) FROM Vehiculo v WHERE v.tipo = ?1")
    Double findMaxPowerByType(String tipo);
}