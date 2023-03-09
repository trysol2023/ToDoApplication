package com.todo.sb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.sb.model.ToDoList;
import com.todo.sb.service.TodoListService;

@RestController
@RequestMapping("/TodoList")
public class TodoListController {
  
	@Autowired
	private TodoListService todoListService;
	
	@GetMapping("/todousers")
	public ResponseEntity<List<ToDoList>> getAllTodos(){
		List<ToDoList> todos = todoListService.findAll();
		return new ResponseEntity<List<ToDoList>>(todos, HttpStatus.OK) ;
	}
	
	@GetMapping("ToDo/{id}")
	public ResponseEntity<ToDoList> getToDoId(@PathVariable long id) {
		ToDoList todoRetrieved = todoListService.getById(id);
		return new ResponseEntity<ToDoList>(todoRetrieved, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<ToDoList> addUser(@Valid @RequestBody ToDoList toDoList) {
		ToDoList add = todoListService.addUser(toDoList);
	  return new ResponseEntity<ToDoList>(add,HttpStatus.CREATED);
	}
	/*@PostMapping("add-todo")
	public ResponseEntity<ToDoList> addToDoList(@Valid @RequestBody ToDoList toDoList) {
		ToDoList addtodo = todoListService.addToDoList(toDoList);
		  return new ResponseEntity<ToDoList>(addtodo,HttpStatus.CREATED);
	}*/
	
    @PutMapping("/update-todo/{id}")
    public ResponseEntity<ToDoList> updateToDo(@PathVariable long id,@RequestBody ToDoList toDoList) {
    	ToDoList upd =  todoListService.updateToDoList(id,toDoList);
    	return new ResponseEntity<ToDoList>(upd,HttpStatus.CREATED);	
   
    }
    
    @DeleteMapping("/del-todo/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable("id") Long id){
    	todoListService.deleteToDoById(id);
    	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    
    
  
}
