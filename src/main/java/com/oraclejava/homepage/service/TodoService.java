package com.oraclejava.homepage.service;

import com.oraclejava.homepage.repository.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodoList();

    Todo createTodo(Todo todo);

    Todo findTodo(int todoId);

    Todo finishTodo(int todoId);

    void removeTodo(int todoId);
}
