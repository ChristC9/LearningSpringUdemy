package com.chriscode.todo.dao;

import com.chriscode.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}
