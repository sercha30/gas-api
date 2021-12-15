package com.salesianostriana.dam.GasApi.estaciones.controller;

import com.salesianostriana.dam.GasApi.estaciones.model.dto.CreateEstacionDto;
import com.salesianostriana.dam.GasApi.estaciones.model.dto.EstacionDtoConverter;
import com.salesianostriana.dam.GasApi.estaciones.model.dto.GetEstacionDto;
import com.salesianostriana.dam.GasApi.estaciones.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/estaciones")
public class EstacionController {

    private final EstacionService estacionService;
    private final EstacionDtoConverter converter;

    @GetMapping("/")
    public ResponseEntity<List<GetEstacionDto>> listarTodas() {
        return ResponseEntity.ok().body(
                estacionService.buscarTodas()
                        .stream().map(converter::convertEstacionToGetEstacionDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetEstacionDto> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(
                converter.convertEstacionToGetEstacionDto(
                        estacionService.buscarUnaPorId(id)
                )
        );
    }

    @PostMapping("/")
    public ResponseEntity<GetEstacionDto> crearNueva(@Valid @RequestBody CreateEstacionDto nuevaEstacion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        converter.convertEstacionToGetEstacionDto(
                                estacionService.incluirNueva(converter.convertCreateEstacionDtoToGetEstacionDto(nuevaEstacion))
                        )
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetEstacionDto> editarUna(@PathVariable UUID id,
                                                    @RequestBody CreateEstacionDto estacion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        converter.convertEstacionToGetEstacionDto(
                                estacionService.editarPorId(id, estacion)
                        )
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUna(@PathVariable UUID id) {
        estacionService.eliminarPorId(id);

        return ResponseEntity.noContent()
                .build();
    }
}
