package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.TaskController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Task;

@RestController
public class TaskEndpoint {

    @Autowired
    private TaskController taskController;

    @RequestMapping(path = "/api/timetables/{id}/tasks", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<Task> getTasks(@RequestParam(name="id") Long timetableId) {
        return taskController.getTasks(timetableId);
    }
    
    @RequestMapping(path = "/api/tasks/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public Task getTask(@RequestParam(name="id") Long id) {
        return taskController.getTask(id);
    }
}