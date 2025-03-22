package com.example.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "todo_list")
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

    @ManyToOne(fetch = FetchType.LAZY)   //prevent user data
    @JoinColumn(name = "user_id")
    @JsonIgnore  //prevent user data
    private User user;


    @OneToMany(mappedBy="todoList")
    private Set<TodoItem> todoItems;




}
