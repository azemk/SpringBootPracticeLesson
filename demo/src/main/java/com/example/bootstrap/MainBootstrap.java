package com.example.bootstrap;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap  implements ApplicationRunner {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            Task task = new Task("hello ");
            Task task1 = new Task("bye");

            taskRepository.save(task);
            taskRepository.save(task1);
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex ){
            System.out.println("Unexpected error");
            System.out.println(ex.getStackTrace());
        }finally{
            System.out.println("Application is working !");
        }
    }
}
