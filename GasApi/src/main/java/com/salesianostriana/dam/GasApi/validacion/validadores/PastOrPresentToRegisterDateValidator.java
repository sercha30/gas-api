package com.salesianostriana.dam.GasApi.validacion.validadores;

import com.salesianostriana.dam.GasApi.validacion.anotaciones.PastOrPresentToRegisterDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class PastOrPresentToRegisterDateValidator
        implements ConstraintValidator<PastOrPresentToRegisterDate, LocalDateTime> {

    @Override
    public void initialize(PastOrPresentToRegisterDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDateTime fechaApertura,
                           ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
