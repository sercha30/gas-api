package com.salesianostriana.dam.GasApi.estaciones.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EstacionServicio implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID id;

    private String nombre;
    private String marca;
    private String ubicacion;
    private Boolean tieneAutolavado = false;
    private Double precioGasoilNormal;
    private Double precioGasolina95Octanos;
    private Double precioGasoilEspecial;
    private Double precioGasolina98;
    private String servicios;
    private LocalDateTime fechaApertura;
}
