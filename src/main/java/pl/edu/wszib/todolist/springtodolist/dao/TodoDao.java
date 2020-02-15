package pl.edu.wszib.todolist.springtodolist.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.model.Todo;

import java.util.Date;
import java.util.List;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {

    int countTodosByStatus(Status status);
    List<Todo> findAllByStatus(Status status);
    List<Todo> findTop5ByDueDateAfterOrderByDueDateAsc(Date date);

    @Override
    List<Todo> findAll();
}
