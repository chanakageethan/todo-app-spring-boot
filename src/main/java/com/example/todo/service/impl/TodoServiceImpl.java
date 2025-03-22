package com.example.todo.service.impl;

import com.example.todo.dto.request.TodoRequestDto;
import com.example.todo.dto.response.TodoListResponseDto;
import com.example.todo.entity.TodoItem;
import com.example.todo.entity.TodoList;
import com.example.todo.entity.User;
import com.example.todo.repo.TodoItemRepo;
import com.example.todo.repo.TodoListRepo;
import com.example.todo.repo.UserRepo;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoListRepo todoListRepo;
    private final TodoItemRepo todoItemRepo;
    private final UserRepo userRepo;

    @Override
    public void todoListSave(TodoRequestDto dto) {

        //Todo
        //need to get id from Token later
        User user = new User();
        user.setUserId(dto.getUserId());

        TodoList todoList = new TodoList();


        Set<TodoItem> todoItems = new HashSet<>();

        String listId = UUID.randomUUID().toString();

        todoList.setListId(listId);
        todoList.setListName(dto.getListName());
        todoList.setCreatedAt(dto.getCreatedAt());
        todoList.setUser(user);



        todoList.setTodoItems(todoItems);


//        todoListRepo.save(toTodoList(dto));




        todoListRepo.save(todoList);




        for (TodoItem object : dto.getTodoItems()) {
            TodoItem item = new TodoItem();
            item.setItemId(UUID.randomUUID().toString());
            item.setItemName(object.getItemName());
            item.setDescription(object.getDescription());
//            item.isCompleted(object.isCompleted());
            item.setCreatedAt(object.getCreatedAt());
            item.setTodoList(todoList);

            todoItems.add(item);

        }



        todoItemRepo.saveAll(todoItems);


    }

    @Override
    public Set<TodoList>   getTodos() {

//        return TodoListResponseDto.builder()
//                .todoItems(todoListRepo.getAllTodos())
//                .build();

        System.out.println("=============");

        Set<TodoList> todoItems = todoListRepo.getAllTodos();


        return todoItems;
    }

//
//    private TodoList toTodoList(TodoListRequestDto dto) {
//        if (dto == null) throw new RuntimeException("Null Data");
//
//        return TodoList.builder()
//                .listId(UUID.randomUUID().toString())
//                .listName(dto.getListName())
//                .createdAt(dto.getCreatedAt())
////                .user(dto.set())
//                .user(dto.u)
//                .build();
//    }
}
