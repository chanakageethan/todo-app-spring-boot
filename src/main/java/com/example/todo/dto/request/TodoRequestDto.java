package com.example.todo.dto.request;


import com.example.todo.entity.TodoItem;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TodoRequestDto {


    private String listName;

    private String createdAt;

    private String userId;

    private Set<TodoItem> todoItems;


}
