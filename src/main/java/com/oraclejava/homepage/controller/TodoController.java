package com.oraclejava.homepage.controller;

import com.oraclejava.homepage.repository.entity.Todo;
import com.oraclejava.homepage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping("/api/todos")
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }
}
