package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name ="user" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="created_at")
    private String createdAt;


    @OneToMany(mappedBy="user")
    private Set<TodoList> todoList;
}
