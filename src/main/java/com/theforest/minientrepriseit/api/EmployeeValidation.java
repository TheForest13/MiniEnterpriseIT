package com.theforest.minientrepriseit.api;

import com.theforest.minientrepriseit.model.Employee;

import java.util.List;

public interface EmployeeValidation {

    List<String> validate(Employee employee);
}
