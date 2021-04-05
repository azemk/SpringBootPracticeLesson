package com.example.controller;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class Controller {
    @Autowired
    TaskService taskService;


    @GetMapping("/getTasks")

    public List<Task> getTasks(){

        return taskService.getAll();
    }
    @PostMapping ("/create")
    public Task create(@RequestBody Task task ){
        return taskService.create(task);
    }
    //model--> repository<->controller
    //model--> repository-->service <-> controller
    //read
    @GetMapping("/getAll")
    public List<Task> getAll(){
        return taskService.getAll();
    }
    //update
    @PostMapping("/update")
    public Task update (@RequestBody Task task ){
        return taskService.update(task);
    }
    //delete
    @DeleteMapping("/delete/{id}") //.../tasks/delete//2
    public String delete (@PathVariable Integer id ){
       taskService.delete(id);
        return "Successfully deleted .";
    }
    @GetMapping("/newest")
public List<Task> getNewest(){
        return taskService.getNewest();
    }






}
