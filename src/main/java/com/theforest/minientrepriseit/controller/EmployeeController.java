package com.theforest.minientrepriseit.controller;

import com.theforest.minientrepriseit.api.ValidationService;
import com.theforest.minientrepriseit.entity.EmployeeEntity;
import com.theforest.minientrepriseit.model.Employee;
import com.theforest.minientrepriseit.model.result.Result;
import com.theforest.minientrepriseit.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import static com.theforest.minientrepriseit.model.constant.StatusResultConstant.SUCCESS;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final ValidationService validationService;

    @GetMapping("/get/all")
    public List<EmployeeEntity> allEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Employee employee) {
        Result validationError = validationService.validate(employee);
        if (Objects.nonNull(validationError)) {
            return validationError;
        }
        return buildSuccessResult();
    }

    private Result buildSuccessResult() {
        return Result.builder()
                .status(SUCCESS)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return MessageFormat.format("Deleted employee by id: {0}", id);
    }
}
