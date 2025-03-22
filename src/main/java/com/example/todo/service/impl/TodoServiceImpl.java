package com.example.todo.service.impl;

import com.example.todo.dto.request.TodoRequestDto;
import com.example.todo.dto.response.ApiResponse;
import com.example.todo.dto.response.TodoListResponseDto;
import com.example.todo.entity.TodoItem;
import com.example.todo.entity.TodoList;
import com.example.todo.entity.User;
import com.example.todo.enums.ResponseMessageEnum;
import com.example.todo.repo.TodoItemRepo;
import com.example.todo.repo.TodoListRepo;
import com.example.todo.repo.UserRepo;
import com.example.todo.service.TodoService;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoListRepo todoListRepo;
    private final TodoItemRepo todoItemRepo;
    private final UserRepo userRepo;

    @Override
    public ApiResponse<Object> todoListSave(TodoRequestDto dto) {
        try {
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


            Map<String, Object> response = new HashMap<>();

            response.put("data", todoItemRepo.saveAll(todoItems));


            return new ApiResponse<>(true, ResponseMessageEnum.SUCCESS, response);

        } catch (PersistenceException e) {
            return new ApiResponse<>(false, ResponseMessageEnum.DATABASE_ERROR, "");
        }


    }

    @Override
    public ApiResponse<Object> getTodos() {

        try {

            Set<TodoList> todoItems = todoListRepo.getAllTodos();

            Map<String, Object> response = new HashMap<>();

            response.put("data", todoItems);


            return new ApiResponse<>(true, ResponseMessageEnum.SUCCESS, response);

        } catch (PersistenceException e) {
            return new ApiResponse<>(false, ResponseMessageEnum.DATABASE_ERROR, "");
        }

//        return todoItems;

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
