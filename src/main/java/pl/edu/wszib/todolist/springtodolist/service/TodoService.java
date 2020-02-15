package pl.edu.wszib.todolist.springtodolist.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.todolist.springtodolist.ToDoConverter;
import pl.edu.wszib.todolist.springtodolist.dao.TodoDao;
import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Todo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

public List<TodoDTO> findAll() {
        List<TodoDTO> results = new ArrayList<>();
        for(Todo todo : todoDao.findAll()) {
        results.add(ToDoConverter.convert(todo));
        }
        return results;
}
}
