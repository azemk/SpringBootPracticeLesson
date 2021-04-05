package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TaskServiceImpl implements TaskService  {
    @Autowired
    TaskRepository taskRepository;
    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll().stream().map(x ->{
            x.setTimeCreated("CMT(+6)"+x.getTimeCreated());
            return x;
        } ).collect(Collectors.toList());
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getNewest() {
        List<Task> listOfTasks1 = taskRepository.findAll();
        List<Task> listOfTasks = new ArrayList<>();

        for(int i = listOfTasks1.size()-1;i>=0;i--){
            listOfTasks.add(listOfTasks1.get(i));
        }

        return listOfTasks;
    }
}
