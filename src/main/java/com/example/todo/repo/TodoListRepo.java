package com.example.todo.repo;

import com.example.todo.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepo extends JpaRepository<TodoList,String> {

}
