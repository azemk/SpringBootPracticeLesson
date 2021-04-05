package com.example.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_1")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    @Column(name="message",nullable = false ,unique = true)
    private String message ;

    @Column(name="timeCreated")
    private String  timeCreated;

    public Task(){
        this.timeCreated = LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute();

    }

    public Task(String message) {
        this.timeCreated = LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute();
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", timeCreated='" + timeCreated + '\'' +
                '}';
    }
}
