package com.todo.sb.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.todo.sb.model.ToDoList;

public interface TodoListService {
	
	public List<ToDoList> findAll();
	
	public ToDoList getById(long id);
	
	ToDoList updateToDoList(long id,ToDoList toDoList);
		
	public ToDoList addUser(ToDoList toDoList);
	
	void deleteToDoById(long id);


}
