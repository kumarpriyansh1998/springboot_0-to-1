package com.priyansh.code.project.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class employeeRoleValidator implements ConstraintValidator<employeeRoleValidation,String> {

    @Override
    public boolean isValid(String input_role, ConstraintValidatorContext constraintValidatorContext) {
        List<String> validRole = List.of("USER","ADMIN","User","Admin");
        return validRole.contains(input_role);
    }
}
