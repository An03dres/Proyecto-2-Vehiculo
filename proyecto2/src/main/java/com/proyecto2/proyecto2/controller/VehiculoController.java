package com.proyecto2.proyecto2.controller;

import com.proyecto2.proyecto2.entity.Vehiculo;
import com.proyecto2.proyecto2.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAll() {
        return vehiculoService.getVehiculos();
    }

    @GetMapping("/{vehiculoId}")
    public Vehiculo getById(@PathVariable("vehiculoId") Long vehiculoId) {
        return vehiculoService.getVehiculoById(vehiculoId);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Vehiculo vehiculo) {
        vehiculoService.saveOrUpdate(vehiculo);
    }

    @DeleteMapping("/{vehiculoId}")
    public void delete(@PathVariable("vehiculoId") Long vehiculoId) {
        vehiculoService.delete(vehiculoId);
    }

    @PutMapping("/{vehiculoId}")
    public void update(@PathVariable("vehiculoId") Long vehiculoId, @RequestBody Vehiculo vehiculo) {
        vehiculoService.update(vehiculoId, vehiculo);
    }

    @GetMapping("/potencia-media/{tipo}")
    public Double getAveragePowerByType(@PathVariable("tipo") String tipo) {
        return vehiculoService.getAveragePowerByType(tipo);
    }

    @GetMapping("/potencia-maxima/{tipo}")
    public Double getMaxPowerByType(@PathVariable("tipo") String tipo) {
        return vehiculoService.getMaxPowerByType(tipo);
    }
}