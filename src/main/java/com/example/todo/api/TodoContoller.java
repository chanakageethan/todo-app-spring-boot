package com.example.todo.api;


import com.example.todo.dto.request.TodoRequestDto;
import com.example.todo.service.TodoService;
import com.example.todo.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoContoller {

    private final TodoService todoListService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> saveTodoList(
            @RequestBody TodoRequestDto dto
    ) {

        todoListService.todoListSave(dto);

        return new ResponseEntity<>(
                StandardResponseDto.builder()
                        .code(201)
                        .message("Todo List saved!")
                        .data(null)
                        .build(),
                HttpStatus.CREATED
        );
    }


    @GetMapping
    public ResponseEntity<StandardResponseDto> getTodos(){




        return new ResponseEntity<>(
                StandardResponseDto.builder()
                        .code(200)
                        .message("Success")
                        .data(todoListService.getTodos())
                        .build(),
                HttpStatus.CREATED
        );

    }
}
