package com.salesianostriana.dam.GasApi.estaciones.service;

import com.salesianostriana.dam.GasApi.errors.exceptions.EntityNotFoundException;
import com.salesianostriana.dam.GasApi.errors.exceptions.ListEntityNotFoundException;
import com.salesianostriana.dam.GasApi.errors.exceptions.SingleEntityNotFoundException;
import com.salesianostriana.dam.GasApi.estaciones.model.EstacionServicio;
import com.salesianostriana.dam.GasApi.estaciones.model.dto.CreateEstacionDto;
import com.salesianostriana.dam.GasApi.estaciones.model.dto.EstacionDtoConverter;
import com.salesianostriana.dam.GasApi.estaciones.model.dto.GetEstacionDto;
import com.salesianostriana.dam.GasApi.estaciones.repos.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository repository;
    private final EstacionDtoConverter converter;

    public List<EstacionServicio> buscarTodas() throws ListEntityNotFoundException {
        List<EstacionServicio> estaciones = repository.findAll();

        if(estaciones.isEmpty()) {
            throw new ListEntityNotFoundException(EstacionServicio.class);
        } else {
            return estaciones;
        }
    }

    public EstacionServicio buscarUnaPorId(UUID id) throws SingleEntityNotFoundException {
        Optional<EstacionServicio> estacionServicio = repository.findById(id);

        if(estacionServicio.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(),EstacionServicio.class);
        } else {
            return estacionServicio.get();
        }
    }

    public EstacionServicio incluirNueva(GetEstacionDto nuevaEstacion) {
        return repository.save(converter.convertGetEstacionDtoToEstacion(nuevaEstacion));
    }

    public EstacionServicio editarPorId(UUID id, CreateEstacionDto estacionDto)
            throws EntityNotFoundException{
        buscarUnaPorId(id);

       return repository.save(converter.convertGetEstacionDtoToEstacion(
               converter.convertCreateEstacionDtoToGetEstacionDto(estacionDto)
       ));
    }

    public void eliminarPorId(UUID id) {
        buscarUnaPorId(id);

        repository.deleteById(id);
    }
}
