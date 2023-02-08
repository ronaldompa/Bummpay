package br.com.bummpay.validation;

import br.com.bummpay.validation.constraintvalidation.NotEmpytListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmpytListValidator.class)
public @interface NotEmpytList {

    String message() default "A Lista não pode ser vazia";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
