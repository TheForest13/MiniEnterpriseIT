package com.theforest.minientrepriseit.repository;

import com.theforest.minientrepriseit.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
