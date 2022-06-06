package com.oraclejava.homepage.service;

import com.oraclejava.homepage.repository.TodoRepository;
import com.oraclejava.homepage.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll(Sort.by("createdAt"));
    }
}
