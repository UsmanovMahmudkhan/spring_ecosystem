package com.task_tracker.Mini.Task.Tracker.project.Service;

import com.task_tracker.Mini.Task.Tracker.project.Config.Status;
import com.task_tracker.Mini.Task.Tracker.project.Entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalTime;
import java.util.ArrayList;

@Slf4j
@Service
public class TaskService {

    private ArrayList<Task>fullTasks=new ArrayList<>();

    public TaskService(ArrayList<Task> fullTasks) {
        this.fullTasks = fullTasks;
    }

    public ArrayList<Task> getFullTasks() {
        return fullTasks;
    }

    public Task addTask(String desc){
       Task task=new Task(desc, Status.todo);

       task.setId(fullTasks.size()+1);
       task.setUpdatedAt(LocalTime.now());

       if (!fullTasks.contains(task)){
           log.info("Added");
           fullTasks.add(task);
           return task;
       }
       else {
           log.info("Error while adding task!!");
           return null;
       }
    }


}
