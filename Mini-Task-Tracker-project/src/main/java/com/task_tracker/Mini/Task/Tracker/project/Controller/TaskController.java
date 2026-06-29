package com.task_tracker.Mini.Task.Tracker.project.Controller;

import com.task_tracker.Mini.Task.Tracker.project.Config.Status;
import com.task_tracker.Mini.Task.Tracker.project.Entity.Task;
import com.task_tracker.Mini.Task.Tracker.project.Service.TaskService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("update/{id}")
    public String updateTaskStatus(@PathVariable int id,@RequestParam Status status,Model model){
        var newTask=service.updateTask(id,status);
        model.addAttribute("task",newTask);
        return "updated";
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        boolean result=service.delete(id);
        model.addAttribute("result",result);
        return "delete";
    }



    @GetMapping("/list/all")
    public String tasks(Model model){
        model.addAttribute("all",service.getAll());
        return "allTask";
    }

    @GetMapping("/list/todo")
    public String getToDos(Model model){
        model.addAttribute("todos",service.getAllToDos());
        return "todo";
    }

}
