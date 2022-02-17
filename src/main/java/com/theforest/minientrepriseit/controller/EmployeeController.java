package com.theforest.minientrepriseit.controller;

import com.theforest.minientrepriseit.dto.EmployeeDto;
import com.theforest.minientrepriseit.model.EmployeeEntity;
import com.theforest.minientrepriseit.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/get/all")
    public List<EmployeeEntity> allEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employee = EmployeeEntity.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .position(employeeDto.getPosition())
                .build();
        employeeRepository.save(employee);
        return "success";
    }
}
