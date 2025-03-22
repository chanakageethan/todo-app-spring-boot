package com.example.todo.service;

import com.example.todo.dto.request.TodoRequestDto;
import com.example.todo.dto.response.ApiResponse;
import com.example.todo.entity.TodoList;

import java.util.Set;

public interface TodoService {

  public ApiResponse<Object> todoListSave(TodoRequestDto dto);

  public ApiResponse<Object> getTodos();
}
