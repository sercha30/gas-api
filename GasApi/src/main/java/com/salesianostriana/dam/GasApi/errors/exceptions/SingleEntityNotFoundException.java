package com.salesianostriana.dam.GasApi.errors.exceptions;

public class SingleEntityNotFoundException extends EntityNotFoundException{


    public SingleEntityNotFoundException(String id, Class clazz) {
        super(String.format("No se puede encontrar una entidad del tipo %s con ID: %s",
                clazz.getName(), id));
    }
}
