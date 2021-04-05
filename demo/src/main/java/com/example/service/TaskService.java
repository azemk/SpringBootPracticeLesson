package com.example.service;

import com.example.model.Task;

import java.util.List;
import java.util.stream.Stream;

public interface TaskService {
    // crud operation
    Task create (Task task ); //получить обьект ->сохранить обьект и вернуть сохранненую версию
    List<Task> getAll();
    Task update (Task task);
    void delete (Integer id );
    //Extra operations
    List<Task> getNewest();//получить новейшие


}
