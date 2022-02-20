package com.theforest.minientrepriseit.service;

import com.theforest.minientrepriseit.api.EmployeeService;
import com.theforest.minientrepriseit.entity.EmployeeEntity;
import com.theforest.minientrepriseit.model.Employee;
import com.theforest.minientrepriseit.model.result.Result;
import com.theforest.minientrepriseit.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.theforest.minientrepriseit.model.constant.StatusResultConstant.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultEmployeeService implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final MessageService messageService;

    @Override
    @Transactional
    public Result save(Employee employee) {
        EmployeeEntity employeeEntity = mapToEntity(employee);
        employeeRepository.save(employeeEntity);
        return buildSuccessResult(messageService.getMessage("description.saved.message"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Result delete(Integer id) { //todo есть баг, если не проверять, что id в есть таблице, вылетает ошибка
        employeeRepository.deleteById(id);
        return buildSuccessResult(messageService.getMessage("description.deleted.message"));
    }

    @Override
    public Result update(Integer id, Employee employee) {
        EmployeeEntity employeeEntity = mapToEntity(id, employee);
        employeeRepository.save(employeeEntity);
        return buildSuccessResult(messageService.getMessage("description.update.message"));
    }

    private EmployeeEntity mapToEntity(Integer id, Employee employee) {
        return EmployeeEntity.builder()
                .id(id)
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .position(employee.getPosition())
                .currentEmp(employee.getCurrentEmp())
                .build();
    }

    private EmployeeEntity mapToEntity(Employee employee) {
        return EmployeeEntity.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .position(employee.getPosition())
                .currentEmp(employee.getCurrentEmp())
                .build();
    }

    private Result buildSuccessResult(String description) {
        return Result.builder()
                .status(SUCCESS)
                .description(description)
                .build();
    }
}
