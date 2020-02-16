package pl.edu.wszib.todolist.springtodolist;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<TodoDTO> all(){
        //return ToDoDB.getAll().stream().map(ToDoConverter::convert).collect(Collectors.toList());
        return todoService.findAll();
    }

    @GetMapping("/todos/upcoming")
    public List<TodoDTO> upcomming(){
        return todoService.upcomming();
    }

    @GetMapping("/todos/search/{status}")
    public List<TodoDTO> search(@PathVariable String status){
        return todoService.search(status);
    }

    @GetMapping("/todos/count/{status}")
    public int count(@PathVariable String status){
        return todoService.count(status);
    }

    @GetMapping("/todo/{id}")
    public TodoDTO get(@PathVariable long id){
        return todoService.get(id);
    }

    @PostMapping("/todo")
    public TodoDTO add(@RequestBody TodoDTO todoDTO){
        return todoService.add(todoDTO);
    }

    @PutMapping("/todo")
    public TodoDTO update(@RequestBody TodoDTO todoDTO){
        return ToDoConverter.convert(ToDoDB.update(ToDoConverter.convert(todoDTO)));
    }

    @DeleteMapping("/todo/{id}")
    public TodoDTO remove(@PathVariable long id){
        return ToDoConverter.convert(ToDoDB.remove(id));
    }

}
