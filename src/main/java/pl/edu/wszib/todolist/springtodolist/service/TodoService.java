package pl.edu.wszib.todolist.springtodolist.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.todolist.springtodolist.dao.TodoDao;

@Service
public class TodoService {
    private TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }


}
