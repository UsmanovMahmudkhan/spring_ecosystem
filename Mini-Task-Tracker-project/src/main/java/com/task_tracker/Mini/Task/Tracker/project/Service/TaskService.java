package com.task_tracker.Mini.Task.Tracker.project.Service;

import com.task_tracker.Mini.Task.Tracker.project.Config.Status;
import com.task_tracker.Mini.Task.Tracker.project.Entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
public class TaskService {

    private ArrayList<Task>fullTasks=new ArrayList<>();
    private int Counter=0;

    public TaskService(ArrayList<Task> fullTasks) {
        this.fullTasks = fullTasks;
    }

    public ArrayList<Task> getFullTasks() {
        return fullTasks;
    }

    public Task addTask(String desc){
       Task task=new Task(desc, Status.todo);
       task.setCreatedAt(LocalTime.now());
       task.setId(Counter);
       if (!fullTasks.contains(task)){
           log.info("Added");
           fullTasks.add(task);
           Counter++;
           return task;
       }
       else {
           log.info("Error while adding task!!");
           return null;
       }
    }

    public Task updateTask(int id,Status status){
        Task updated=null;
        for(Task task:fullTasks){
           if(task.getId()==id){
               task.setStatus(status);
               updated=task;
               log.info("Status of task updated id: "+id);
           }
       }
        return updated;
    }


    public boolean delete(int id){
        for(Task task:fullTasks){
            if(task.getId()==id){
                fullTasks.remove(task);
                log.info("Task deleted id: " + id);
                return true;
            }
        }
        log.info("Error while finding ID for deleting task");
        return false;
    }


    public @Nullable ArrayList<Task> getAll() {
        return fullTasks;
    }


    public ArrayList<Task>getAllToDos(){

        ArrayList<Task>todos=new ArrayList<>();
        for(Task task:fullTasks){
            if(task.getStatus().equals("todo")){
                todos.add(task);
            }
        }

        return todos;
    }
}
