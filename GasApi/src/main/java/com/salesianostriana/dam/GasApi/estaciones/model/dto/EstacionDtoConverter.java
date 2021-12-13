package com.salesianostriana.dam.GasApi.estaciones.model.dto;

import com.salesianostriana.dam.GasApi.estaciones.model.EstacionServicio;
import org.springframework.stereotype.Component;

@Component
public class EstacionDtoConverter {

    public GetEstacionDto convertEstacionToGetEstacionDto(EstacionServicio estacionServicio) {
        return GetEstacionDto.builder()
                .id(estacionServicio.getId())
                .nombre(estacionServicio.getNombre())
                .fechaApertura(estacionServicio.getFechaApertura())
                .marca(estacionServicio.getMarca())
                .precioGasoilEspecial(estacionServicio.getPrecioGasoilEspecial())
                .precioGasoilNormal(estacionServicio.getPrecioGasoilNormal())
                .precioGasolina95Octanos(estacionServicio.getPrecioGasolina95Octanos())
                .precioGasolina98(estacionServicio.getPrecioGasolina98())
                .servicios(estacionServicio.getServicios())
                .tieneAutolavado(estacionServicio.getTieneAutolavado())
                .ubicacion(estacionServicio.getUbicacion())
                .build();
    }

    public EstacionServicio convertGetEstacionDtoToEstacion(GetEstacionDto estacionDto) {
        return EstacionServicio.builder()
                .id(estacionDto.getId())
                .nombre(estacionDto.getNombre())
                .fechaApertura(estacionDto.getFechaApertura())
                .marca(estacionDto.getMarca())
                .precioGasoilEspecial(estacionDto.getPrecioGasoilEspecial())
                .precioGasoilNormal(estacionDto.getPrecioGasoilNormal())
                .precioGasolina95Octanos(estacionDto.getPrecioGasolina95Octanos())
                .precioGasolina98(estacionDto.getPrecioGasolina98())
                .servicios(estacionDto.getServicios())
                .tieneAutolavado(estacionDto.getTieneAutolavado())
                .ubicacion(estacionDto.getUbicacion())
                .build();
    }
}
