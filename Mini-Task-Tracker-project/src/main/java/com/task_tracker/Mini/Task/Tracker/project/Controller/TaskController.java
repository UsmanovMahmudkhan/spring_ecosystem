package com.task_tracker.Mini.Task.Tracker.project.Controller;

import com.task_tracker.Mini.Task.Tracker.project.Config.Status;
import com.task_tracker.Mini.Task.Tracker.project.Entity.Task;
import com.task_tracker.Mini.Task.Tracker.project.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Controller
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String postTask(@RequestParam String desciption, Model model){
        var added=service.addTask(desciption);
        model.addAttribute("task",added);
        return "response";
    }

}
