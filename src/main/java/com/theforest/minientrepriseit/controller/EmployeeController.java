package com.theforest.minientrepriseit.controller;

import com.theforest.minientrepriseit.api.EmployeeService;
import com.theforest.minientrepriseit.api.ValidationService;
import com.theforest.minientrepriseit.entity.EmployeeEntity;
import com.theforest.minientrepriseit.model.Employee;
import com.theforest.minientrepriseit.model.result.EmployeeValidationError;
import com.theforest.minientrepriseit.model.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final ValidationService validationService;
    private final EmployeeService employeeService;


    @GetMapping("/get/all")
    public List<EmployeeEntity> allEmployee() {
        log.info("allEmployee()");
        return employeeService.findAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Employee employee) {
        log.info("save employee: {}", employee);
        Result validationError = validationService.validate(employee);
        if (Objects.nonNull(validationError)) {
            List<String> errors = ((EmployeeValidationError) validationError).getErrors();
            log.info("validation errors: {}", errors);
            return validationError;
        }
        log.info("save success");
        return employeeService.save(employee);
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Employee employee) {
        log.info("update");
        //todo баг, не хватает валидации
       return employeeService.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("delete()");
        return employeeService.delete(id);
    }
}
