package com.oraclejava.homepage.service;

import com.oraclejava.homepage.repository.TodoRepository;
import com.oraclejava.homepage.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Todo> getTodoList() {
        return todoRepository.findAll(Sort.by("createdAt"));
    }

    @Override
    public Todo createTodo(Todo todo) {
        todo.setCreatedAt(new Date());
        todo.setFinished(false);
        todoRepository.save(todo);

        return todo;
    }

    @Override
    @Transactional(readOnly = true)
    public Todo findTodo(int todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> {
            return new RuntimeException("아이디를 찾을 수 없습니다.");
        });
    }

    @Override
    public Todo finishTodo(int todoId) {
        Todo todo = findTodo(todoId);
        if (todo.getFinished()) {
            throw new RuntimeException("이미 완료처리가 되어 있습니다!");
        }
        todo.setFinished(true);
        todoRepository.save(todo);
        return todo;
    }


    @Override
    public void removeTodo(int todoId) {
        Todo todo = findTodo(todoId);
        todoRepository.delete(todo);
    }
}
