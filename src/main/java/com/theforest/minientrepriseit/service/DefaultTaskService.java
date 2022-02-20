package com.theforest.minientrepriseit.service;

import com.theforest.minientrepriseit.api.TaskService;
import com.theforest.minientrepriseit.entity.TaskEntity;
import com.theforest.minientrepriseit.model.Task;
import com.theforest.minientrepriseit.model.result.Result;
import com.theforest.minientrepriseit.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.theforest.minientrepriseit.model.constant.StatusResultConstant.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultTaskService implements TaskService {
    private final TaskRepository taskRepository;
    private final MessageService messageService;

    @Override
    @Transactional(readOnly = true)
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Result save(Task task) { //todo тут будет много багов + не красиво
        TaskEntity taskEntity = build(task);
        taskRepository.save(taskEntity);
        return buildSuccessResult(messageService.getMessage("description.saved.message"));
    }

    @Override
    @Transactional
    public Result delete(Integer id) {
        taskRepository.deleteById(id);
        return buildSuccessResult(messageService.getMessage("description.update.message")); //todo неправильное сообщение
    }

    @Override
    public Result update(Integer id, Task task) {
        TaskEntity taskEntity = build(task); //todo тут баг маппига + проверка что id есть в таблице
        taskEntity.setId(id);
        taskRepository.save(taskEntity);
        return buildSuccessResult(messageService.getMessage("description.deleted.message"));
    }

    private TaskEntity build(Task task) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = dateFormat.format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        TaskEntity taskEntity = null;
        try {
            taskEntity = TaskEntity.builder()
                    .title(task.getTitle())
                    .dateCompletion(format.parse(task.getDateCompletion()))
                    .dateCreated(format.parse(dateCreated))
                    .description(task.getDescription())
                    .uid(DigestUtils.md5Hex(task.getTitle() + dateCreated))
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return taskEntity;
    }

    private Result buildSuccessResult(String description) {
        return Result.builder()
                .status(SUCCESS)
                .description(description)
                .build();
    }
}
