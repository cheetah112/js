package App2.app2.service;

import App2.app2.Request.CreateTodoRequest;
import App2.app2.Request.UpdateTodoRequest;
import App2.app2.entity.Todo;
import App2.app2.exception.NotFoundException;
import App2.app2.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    private List<Todo> todos;

    public TodoService() {
        todos =  new ArrayList<>();
        todos.add(new Todo(1, "Làm bài tập", true));
        todos.add(new Todo(2, "Đá bóng", true));
        todos.add(new Todo(3, "Đi chơi", false));
    }

    private int generateId() {
        Random rd = new Random();
        return rd.nextInt(1000 - 100 + 1) + 100;
    }

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Integer id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            return optionalTodo.get();
        }else{
        throw new NotFoundException("Not found todo with id = " + id);}
    }

    public Todo createTodo(CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .id(generateId())
                .title(request.getTitle())
                .status(false)
                .build();

        todoRepository.save(todo);
        return todo;
    }

    public Todo updateTodo(Integer id, UpdateTodoRequest request) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
           Todo todo = optionalTodo.get();
           todo.setTitle(request.getTitle());
           todo.setStatus(request.getStatus());
           todoRepository.save(todo);
           return todo;
        }else{
            throw new NotFoundException("Not found todo with id = " + id);}
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }
}