package com.chriscode.todo.service;

import com.chriscode.todo.dao.ToDoRepository;
import com.chriscode.todo.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService{

    ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findById(int theId) {

        Optional<ToDo> idExists = toDoRepository.findById(theId);

        ToDo theToDo = null;

        if (idExists.isEmpty()){
            throw new RuntimeException("ToDo id -" + theId + " not found");
        }
        theToDo = idExists.get();
        return theToDo;
    }

    @Override
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void deleteById(int theId) {
        toDoRepository.deleteById(theId);
    }
}
