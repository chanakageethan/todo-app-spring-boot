package com.example.todo.dto.request;


import com.example.todo.entity.TodoItem;
import com.example.todo.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TodoListRequestDto {


    private String listName;

    private String createdAt;

    private String userId;


}
