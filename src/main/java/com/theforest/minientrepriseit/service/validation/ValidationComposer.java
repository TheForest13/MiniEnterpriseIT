package com.theforest.minientrepriseit.service.validation;

import com.theforest.minientrepriseit.api.EmployeeValidation;
import com.theforest.minientrepriseit.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationComposer {

    private final List<EmployeeValidation> validations = new ArrayList<>();

    public ValidationComposer(EmployeeValidation... validation) {
        validations.addAll(Arrays.asList(validation));
    }

    public List<String> validate(Employee form) {
        return validations.stream()
                .flatMap(validation -> validation.validate(form).stream())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
