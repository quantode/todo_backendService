package com.shreeya.rest.webservices.restful_web_services.controller;

import com.shreeya.rest.webservices.restful_web_services.Model.todoModel;
import com.shreeya.rest.webservices.restful_web_services.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import com.shreeya.rest.webservices.restful_web_services.service.Todo;

import java.net.URI;
import java.util.List;
@RestController

public class todoController {
    private TodoHardcodedService todoHardcodedService;


    @GetMapping("users/{username}/todos")
public List <todoModel> getAllTodos(@PathVariable String username) {
return todoHardcodedService.findAll();
}

@GetMapping("users/{username}/todos/{id}")
public todoModel getTodo(@PathVariable String username, @PathVariable long id){
        return todoHardcodedService.findById(id);
}

@DeleteMapping("users/{username}/todos/{id}")
public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
       todoModel todo = todoHardcodedService.deleteById(id);
       if(todo != null){
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.notFound().build();
}

@PutMapping("users/{username}/todos/{id}")
public ResponseEntity<todoModel>updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody  todoModel todo){
      todoModel updatedTodo = todoHardcodedService.save(todo);
      return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
}

@PostMapping("users/{username}/todos")
public ResponseEntity<Void>postTodo(@PathVariable String username, @RequestBody todoModel todo){
        todoModel createTodo = todoHardcodedService.save(todo);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(createTodo.getId()).toUri();
    return ResponseEntity.created(uri).build();
}

    @Autowired
    public void setTodoHardcodedService(TodoHardcodedService todoHardcodedService) {
        this.todoHardcodedService = todoHardcodedService;
    }
}
