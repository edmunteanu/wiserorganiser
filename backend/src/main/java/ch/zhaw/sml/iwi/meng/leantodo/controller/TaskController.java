package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Task;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TaskRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Timetable;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TimetableRepository;

@Component
public class TaskController {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks(Long timetableId) {
        Timetable timetable = timetableRepository.getById(timetableId);

        return timetable.getTasks();
    }
    
    public Task getTask(Long id) {
        return taskRepository.getById(id);
    }
}