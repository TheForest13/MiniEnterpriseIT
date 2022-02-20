package com.theforest.minientrepriseit.controller;

import com.theforest.minientrepriseit.api.TaskService;
import com.theforest.minientrepriseit.entity.TaskEntity;
import com.theforest.minientrepriseit.model.Task;
import com.theforest.minientrepriseit.model.result.Result;
import com.theforest.minientrepriseit.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/get/all")
    public List<TaskEntity> allTasks() {
        log.info("allTasks");
        return taskService.findAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Task task) {
        log.info("save task: {}", task);
        return taskService.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("delete task");
        return taskService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Task task) {
        log.info("update by id {}? task: {}", id, task);
        return taskService.update(id, task);
    }
}
