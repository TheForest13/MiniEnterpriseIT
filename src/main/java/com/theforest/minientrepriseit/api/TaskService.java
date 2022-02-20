package com.theforest.minientrepriseit.api;

import com.theforest.minientrepriseit.entity.TaskEntity;
import com.theforest.minientrepriseit.model.Task;
import com.theforest.minientrepriseit.model.result.Result;

import java.util.List;

public interface TaskService {
    List<TaskEntity> findAll();

    Result save(Task task);

    Result delete(Integer id);

    Result update(Integer id, Task task);
}
