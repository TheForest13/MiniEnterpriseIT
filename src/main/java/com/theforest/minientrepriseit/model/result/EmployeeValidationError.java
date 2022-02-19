package com.theforest.minientrepriseit.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeValidationError extends Result {
    private List<String> errors;

    public EmployeeValidationError(String status, List<String> errors) {
        super(status);
        this.errors = errors;
    }
}
