package com.example.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Table(name = "todo_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoItem {
    @Id
    @Column(name="item_id")
    private String itemId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="description")
    private String description;

    @Column(name="is_completed")
    private boolean isCompleted;

    @Column(name="created_at")
    private String createdAt;



    @ManyToOne
    @JoinColumn(name = "list_id")
    @JsonIgnore
    private TodoList todoList;





}
