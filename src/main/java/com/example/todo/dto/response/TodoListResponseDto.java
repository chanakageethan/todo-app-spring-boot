package com.example.todo.dto.response;

import com.example.todo.entity.TodoItem;
import com.example.todo.entity.TodoList;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
@Builder
public class TodoListResponseDto {
    private Set<TodoList> todoItems;
}
