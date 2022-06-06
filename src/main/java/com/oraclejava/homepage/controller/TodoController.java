package com.oraclejava.homepage.controller;

import com.oraclejava.homepage.repository.entity.Todo;
import com.oraclejava.homepage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo postTodos(@RequestBody @Validated Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);

        return createdTodo;
    }

    @PutMapping("{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public Todo putTodo(@PathVariable("todoId") Integer todoId) {
        Todo finishedTodo = todoService.finishTodo(todoId);
        return finishedTodo;
    }

    @DeleteMapping("{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable("todoId") Integer todoId) {
        todoService.removeTodo(todoId);
    }

}
