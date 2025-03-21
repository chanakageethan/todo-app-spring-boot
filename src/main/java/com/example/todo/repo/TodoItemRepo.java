package com.example.todo.repo;

import com.example.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepo extends JpaRepository<TodoItem,String> {

}
