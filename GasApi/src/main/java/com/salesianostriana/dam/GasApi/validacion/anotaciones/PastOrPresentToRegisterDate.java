package com.salesianostriana.dam.GasApi.validacion.anotaciones;

import com.salesianostriana.dam.GasApi.validacion.validadores.PastOrPresentToRegisterDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastOrPresentToRegisterDateValidator.class)
@Documented
public @interface PastOrPresentToRegisterDate {

    String message() default "La fecha de apertura debe ser menos a la fecha de registro";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
