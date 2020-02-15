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

//    @GetMapping("/todos/upcoming")
//    public List<TodoDTO> upcomming(){
//        return ToDoDB.upcoming().stream().map(ToDoConverter::convert).collect(Collectors.toList());
//    }
//
//    @GetMapping("/todos/search/{status}")
//    public List<TodoDTO> search(@PathVariable String status){
//        return ToDoDB.search(Status.valueOf(status)).stream().map(ToDoConverter::convert).collect(Collectors.toList());
//    }
//
//    @GetMapping("/todos/count/{status}")
//    public int count(@PathVariable String status){
//        return ToDoDB.search(Status.valueOf(status)).size();
//    }
//
//    @GetMapping("/todo/{id}")
//    public TodoDTO get(@PathVariable long id){
//        return ToDoConverter.convert(ToDoDB.get(id));
//    }
//
//    @PostMapping("/todo")
//    public TodoDTO add(@RequestBody TodoDTO todoDTO){
//        return ToDoConverter.convert(ToDoDB.add(ToDoConverter.convert(todoDTO)));
//    }
//
//    @PutMapping("/todo")
//    public TodoDTO update(@RequestBody TodoDTO todoDTO){
//        return ToDoConverter.convert(ToDoDB.update(ToDoConverter.convert(todoDTO)));
//    }
//
//    @DeleteMapping("/todo/{id}")
//    public TodoDTO remove(@PathVariable long id){
//        return ToDoConverter.convert(ToDoDB.remove(id));
//    }

}
