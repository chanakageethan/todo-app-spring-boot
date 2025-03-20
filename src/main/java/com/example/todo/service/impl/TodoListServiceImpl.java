package com.example.todo.service.impl;

import com.example.todo.dto.request.TodoListRequestDto;
import com.example.todo.entity.TodoList;
import com.example.todo.entity.User;
import com.example.todo.repo.TodoListRepo;
import com.example.todo.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepo todoListRepo;

    @Override
    public void todoListSave(TodoListRequestDto dto) {

        TodoList todoList = new TodoList();



        User user = new User();
        user.setUserId(dto.getUserId());


        todoList.setListId("0202020");
        todoList.setListName(dto.getListName());
        todoList.setCreatedAt(dto.getCreatedAt());
        todoList.setCreatedAt(dto.getCreatedAt());
        todoList.setUser(user);



//        todoListRepo.save(toTodoList(dto));
        todoListRepo.save(todoList);
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
