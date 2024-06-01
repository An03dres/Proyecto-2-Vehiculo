package com.proyecto2.proyecto2.service;

import com.proyecto2.proyecto2.entity.Vehiculo;
import com.proyecto2.proyecto2.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getVehiculoById(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    public void delete(Long id) {
        vehiculoRepository.deleteById(id);
    }

    public void update(Long id, Vehiculo vehiculo) {
        Vehiculo existingVehiculo = vehiculoRepository.findById(id).orElse(null);
        if (existingVehiculo != null) {
            existingVehiculo.setColor(vehiculo.getColor());
            existingVehiculo.setMarca(vehiculo.getMarca());
            existingVehiculo.setModelo(vehiculo.getModelo());
            existingVehiculo.setPlaca(vehiculo.getPlaca());
            existingVehiculo.setTipo(vehiculo.getTipo());
            existingVehiculo.setPotencia(vehiculo.getPotencia());
            vehiculoRepository.save(existingVehiculo);
        }
    }

    public Double getAveragePowerByType(String tipo) {
        return vehiculoRepository.findAveragePowerByType(tipo);
    }

    public Double getMaxPowerByType(String tipo) {
        return vehiculoRepository.findMaxPowerByType(tipo);
    }
}