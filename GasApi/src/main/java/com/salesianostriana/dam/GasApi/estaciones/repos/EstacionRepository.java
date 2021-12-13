package com.salesianostriana.dam.GasApi.estaciones.repos;

import com.salesianostriana.dam.GasApi.estaciones.model.EstacionServicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstacionRepository extends JpaRepository<EstacionServicio, UUID> {
}
