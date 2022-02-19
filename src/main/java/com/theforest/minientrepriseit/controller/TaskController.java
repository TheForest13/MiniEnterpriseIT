package com.theforest.minientrepriseit.controller;

import com.theforest.minientrepriseit.entity.TaskEntity;
import com.theforest.minientrepriseit.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping("/get/all")
    public List<TaskEntity> getAll() {
        return taskRepository.findAll();
    }
}
