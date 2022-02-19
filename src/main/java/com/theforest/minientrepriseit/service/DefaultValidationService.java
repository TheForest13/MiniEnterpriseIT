package com.theforest.minientrepriseit.service;

import com.theforest.minientrepriseit.api.TypeProvider;
import com.theforest.minientrepriseit.api.ValidationService;
import com.theforest.minientrepriseit.model.Employee;
import com.theforest.minientrepriseit.model.result.EmployeeValidationError;
import com.theforest.minientrepriseit.model.result.Result;
import com.theforest.minientrepriseit.service.validation.ValidationComposer;
import com.theforest.minientrepriseit.service.validation.employee.EmployeeEmptyFieldValidation;
import com.theforest.minientrepriseit.service.validation.employee.EmployeeFormatFieldValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.theforest.minientrepriseit.model.constant.StatusResultConstant.FAILED;

@Service
@RequiredArgsConstructor
public class DefaultValidationService implements ValidationService {

    private final MessageService messageService;
    private final TypeProvider typeProvider;

    @Override
    public Result validate(Employee employee) {
        List<String> errors = new ValidationComposer(
                new EmployeeEmptyFieldValidation(messageService.getMessage("empty.field.error")),
                new EmployeeFormatFieldValidation(messageService.getMessage("format.field.error"), typeProvider)
        )
                .validate(employee);

        return build(errors);
    }

    private EmployeeValidationError build(List<String> errors) {
        return errors.isEmpty() ? null : new EmployeeValidationError(FAILED, errors);
    }
}
