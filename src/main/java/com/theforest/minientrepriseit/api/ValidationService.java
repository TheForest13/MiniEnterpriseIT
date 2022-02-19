package com.theforest.minientrepriseit.api;

import com.theforest.minientrepriseit.model.Employee;
import com.theforest.minientrepriseit.model.result.Result;

public interface ValidationService {
    Result validate(Employee employee);
}
