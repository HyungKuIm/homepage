package com.oraclejava.homepage.service;

import com.oraclejava.homepage.repository.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodoList();
}
