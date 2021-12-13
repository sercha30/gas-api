package com.salesianostriana.dam.GasApi.errors.exceptions;

public class RequestBodyMissingException extends RuntimeException{

    public RequestBodyMissingException() {
        super("El cuerpo de la petición está vacío");
    }
}
