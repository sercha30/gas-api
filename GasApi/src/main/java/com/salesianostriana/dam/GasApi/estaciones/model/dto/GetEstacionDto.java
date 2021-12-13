package com.salesianostriana.dam.GasApi.estaciones.model.dto;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetEstacionDto implements Serializable {

    private UUID id;

    @NotBlank
    private String nombre;

    private String marca;

    @NotBlank
    private String ubicacion;

    private Boolean tieneAutolavado = false;

    @NotNull
    @PositiveOrZero
    private Double precioGasoilNormal;

    @NotNull
    @PositiveOrZero
    private Double precioGasolina95Octanos;

    @NotNull
    @PositiveOrZero
    private Double precioGasoilEspecial;

    @NotNull
    @PositiveOrZero
    private Double precioGasolina98;

    @Lob
    private String servicios;

    @Past
    private LocalDateTime fechaApertura;

}
