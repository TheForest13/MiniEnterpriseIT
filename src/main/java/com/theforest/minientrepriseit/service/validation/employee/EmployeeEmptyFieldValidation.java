package com.theforest.minientrepriseit.service.validation.employee;

import com.theforest.minientrepriseit.api.EmployeeValidation;
import com.theforest.minientrepriseit.model.Employee;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.theforest.minientrepriseit.builder.EmptyFieldErrorBuilder.build;
import static com.theforest.minientrepriseit.type.EmployeeFieldNameType.*;

@Data
public class EmployeeEmptyFieldValidation implements EmployeeValidation {

    private final String fieldErrorMessage;

    public EmployeeEmptyFieldValidation(String fieldErrorMessage) {
        this.fieldErrorMessage = fieldErrorMessage;
    }

    @Override
    public List<String> validate(Employee employee) {
        return Stream.of(
                        Optional.ofNullable(build(employee.getFirstName(), fieldErrorMessage, FIRST_NAME)),
                        Optional.ofNullable(build(employee.getLastName(), fieldErrorMessage, LAST_NAME)),
                        Optional.ofNullable(build(employee.getPosition(), fieldErrorMessage, POSITION)),
                        Optional.ofNullable(build(employee.getCurrentEmp(), fieldErrorMessage, CURRENT_EMP)) //todo тут баг валидации по обязательному полю (надо просто убрать эту строчку)
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
