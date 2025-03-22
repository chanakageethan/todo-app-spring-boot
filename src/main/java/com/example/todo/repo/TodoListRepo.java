package com.example.todo.repo;

import com.example.todo.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TodoListRepo extends JpaRepository<TodoList,String> {
    @Query(nativeQuery = true, value = "SELECT *  FROM todo_list ")
    public Set<TodoList> getAllTodos();
}
