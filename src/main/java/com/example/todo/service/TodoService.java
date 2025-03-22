package com.example.todo.service;

import com.example.todo.dto.request.TodoRequestDto;
import com.example.todo.entity.TodoList;

import java.util.Set;

public interface TodoService {

  public void todoListSave(TodoRequestDto dto);

  public Set<TodoList>  getTodos();
}
