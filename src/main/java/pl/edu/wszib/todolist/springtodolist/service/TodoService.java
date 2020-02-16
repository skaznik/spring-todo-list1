package pl.edu.wszib.todolist.springtodolist.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.todolist.springtodolist.ToDoConverter;
import pl.edu.wszib.todolist.springtodolist.dao.TodoDao;
import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.model.Todo;

import java.util.ArrayList;
import java.util.Date;
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

public List<TodoDTO> upcomming() {
    List<TodoDTO> results = new ArrayList<>();
    for(Todo todo : todoDao.findTop5ByDueDateAfterOrderByDueDateAsc(new Date())) {
        results.add(ToDoConverter.convert(todo));
    }
    return results;
}

public List<TodoDTO> search(String status) {
    List<TodoDTO> results = new ArrayList<>();
    for(Todo todo : todoDao.findAllByStatus(Status.valueOf(status))) {
        results.add(ToDoConverter.convert(todo));
    }
    return results;
}
 public int count(String status) {
        return todoDao.countTodosByStatus(Status.valueOf(status));
 }
 public TodoDTO get(long id) {
        Todo todo = todoDao.findById((int)id).get();
        return ToDoConverter.convert(todo);
 }

    public TodoDTO add(TodoDTO todoDTO) {
        Todo todo = ToDoConverter.convert(todoDTO);
        todo.setId(null);
        todo.setStatus(Status.NEW);
        todo = todoDao.save(todo);
        return ToDoConverter.convert(todo);

    }

    public TodoDTO update(TodoDTO todoDTO) {
        Todo existing = todoDao.findById(todoDTO.id).get();
        Todo incoming = ToDoConverter.convert(todoDTO);
        existing.setDueDate(incoming.getDueDate());
        existing.setStatus(incoming.getStatus());
        existing.setTitle(incoming.getTitle());
        existing = todoDao.save(existing);
        return ToDoConverter.convert(existing);
    }

    public TodoDTO remove(long id) {
        Todo existing = todoDao.findById((int) id).get();
        todoDao.delete(existing);
        return ToDoConverter.convert(existing);
    }
}
