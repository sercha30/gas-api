package com.salesianostriana.dam.GasApi.estaciones.model.dto;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateEstacionDto {

    @NotBlank(message = "{estacionServicio.nombre.blank}")
    private String nombre;

    private String marca;

    @NotBlank(message = "{estacionServicio.ubicacion.blank}")
    @Pattern(regexp = "[0-9],[0-9]", message = "estacionServicio.ubicacion.pattern")
    private String ubicacion;

    private Boolean tieneAutolavado = false;

    @NotNull(message = "{estacionServicio.precioGasoilNormal.null}")
    @PositiveOrZero(message = "{estacionServicio.precioGasoilNormal.positiveOrZero}")
    private Double precioGasoilNormal;

    @NotNull(message = "{estacionServicio.precioGasolina95Octanos.null}")
    @PositiveOrZero(message = "{estacionServicio.precioGasolina95Octanos.positiveOrZero}")
    private Double precioGasolina95Octanos;

    @NotNull(message = "{estacionServicio.precioGasoilEspecial.null}")
    @PositiveOrZero(message = "{estacionServicio.precioGasoilEspecial.positiveOrZero}")
    private Double precioGasoilEspecial;

    @NotNull(message = "{estacionServicio.precioGasolina98.null}")
    @PositiveOrZero(message = "{estacionServicio.precioGasolina98.positiveOrZero}")
    private Double precioGasolina98;

    @Lob
    private String servicios;

    @Past(message = "{estacionServicio.fechaApertura.past}")
    private LocalDateTime fechaApertura;

    private LocalDateTime fechaRegistro;
}
