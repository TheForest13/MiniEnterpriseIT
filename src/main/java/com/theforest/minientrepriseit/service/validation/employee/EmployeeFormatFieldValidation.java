package com.theforest.minientrepriseit.service.validation.employee;

import com.theforest.minientrepriseit.api.EmployeeValidation;
import com.theforest.minientrepriseit.api.TypeProvider;
import com.theforest.minientrepriseit.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.theforest.minientrepriseit.builder.FormatFieldErrorBuilder.build;
import static com.theforest.minientrepriseit.type.EmployeeFieldNameType.*;

public class EmployeeFormatFieldValidation implements EmployeeValidation {

    private final String fieldErrorMessage;
    private final TypeProvider typeProvider;

    public EmployeeFormatFieldValidation(String fieldErrorMessage, TypeProvider typeProvider) {
        this.fieldErrorMessage = fieldErrorMessage;
        this.typeProvider = typeProvider;
    }

    @Override
    public List<String> validate(Employee employee) {
        return Stream.of(
                        Optional.ofNullable(build(employee.getPosition(), typeProvider, fieldErrorMessage, POSITION))
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
