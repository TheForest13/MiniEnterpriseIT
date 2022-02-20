package com.theforest.minientrepriseit.api;

import com.theforest.minientrepriseit.entity.EmployeeEntity;
import com.theforest.minientrepriseit.model.Employee;
import com.theforest.minientrepriseit.model.result.Result;

import java.util.List;

public interface EmployeeService {
    Result save(Employee employee);

    List<EmployeeEntity> findAll();

    Result delete(Integer id);

    Result update(Integer id, Employee employee);
}
