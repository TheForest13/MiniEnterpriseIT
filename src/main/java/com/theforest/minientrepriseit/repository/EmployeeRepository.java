package com.theforest.minientrepriseit.repository;

import com.theforest.minientrepriseit.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
