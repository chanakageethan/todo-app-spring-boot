package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name="todo_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoList {



    @Id
    @Column(name="list_id")
    private String listId;

    @Column(name="list_name")
    private String listName;

    @Column(name="created_at")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy="todoList")
    private Set<TodoItem> todoItems;




}
