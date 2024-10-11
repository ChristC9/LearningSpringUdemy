package com.chriscode.todo.service;

import com.chriscode.todo.entity.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ToDoService {

    public List<ToDo> findAll();
    ToDo findById(int theId);
    ToDo save(ToDo toDo);
    void deleteById(int theId);

}
