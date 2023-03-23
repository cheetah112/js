package App2.app2.controller;

import App2.app2.Request.CreateTodoRequest;
import App2.app2.Request.UpdateTodoRequest;
import App2.app2.entity.Todo;
import App2.app2.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @GetMapping("todos/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable Integer id) {
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping("todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@Valid @RequestBody CreateTodoRequest request) {
        return todoService.createTodo(request);
    }

    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody UpdateTodoRequest request) {
        return todoService.updateTodo(id, request);
    }

    @DeleteMapping("todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
    }
}
