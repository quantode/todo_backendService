package com.shreeya.rest.webservices.restful_web_services.service;

import com.shreeya.rest.webservices.restful_web_services.Model.todoModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TodoHardcodedService {
    private static List<todoModel> todos = new ArrayList<todoModel>();
    private static long idCounter = 0;
    static {
        todos.add(new todoModel(++idCounter, "shreeya","learn java", new Date(), false));
        todos.add(new todoModel(++idCounter, "anisha","learn coding", new Date(), false));
        todos.add(new todoModel(++idCounter, "flower","learn hibernate", new Date(), false));
    }


    public List<todoModel>findAll(){
        return todos;
    }

    public todoModel save(todoModel todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }
        else{

            for(int i=0; i<todos.size(); i++){
                if(Objects.equals(todos.get(i).getId(), todo.getId())){
                    todos.set(i, todo);
                    break;
                }
            }

        }
        return todo;
    }


    public todoModel deleteById(Long id){
        todoModel Todo = findById(id);
        if(Todo == null){
            return null;
        }
     if (   todos.remove(Todo)) {
         return Todo;
     }
        return null;
    }



    public todoModel findById(Long id) {

        for (todoModel Todo : todos) {
            if(Todo.getId()==id){
                return Todo;
            }
        }
        return null;
    }


}
