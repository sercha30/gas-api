package com.salesianostriana.dam.GasApi.errors.exceptions;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class clazz) {
        super(String.format("No se pueden encontrar elementos del tipo %s ",
                clazz.getName()));
    }
}
