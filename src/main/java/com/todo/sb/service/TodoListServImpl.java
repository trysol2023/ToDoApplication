package com.todo.sb.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todo.sb.customExceptions.UserInputException;
import com.todo.sb.customExceptions.UserNotFoundException;
import com.todo.sb.model.ToDoList;
import com.todo.sb.repository.TodoListRepository;

@Service
public class TodoListServImpl implements TodoListService {
	
	@Autowired
	private TodoListRepository todoListRepository;
	
	@Override
	public List<ToDoList> findAll() {
		return todoListRepository.findAll();
	}

	@Override
	public ToDoList getById(long id) {
		Optional<ToDoList> result = todoListRepository.findById(id);
		ToDoList todo = null;
		
		if(result.isPresent()) {
			return result.get();
		}
		else {
			throw new UserNotFoundException("User with id:" + id + "not found");
		}
	}

	@Override
	public ToDoList updateToDoList(long id, ToDoList toDoList) {
			   ToDoList items = getById(id);
			      items.setUserName(toDoList.getUserName());
			      items.setDescription(toDoList.getDescription());
			      items.setDueDate(toDoList.getDueDate());
			      items.setStatus(toDoList.getStatus());

			return todoListRepository.save(items);
			}
	/*@Override
	public ToDoList addToDoList(ToDoList toDoList) {
		return todoListRepository.save(toDoList);
	}*/

	@Override
	public ToDoList addUser(ToDoList toDoList) {
		if(toDoList.getUserName().isEmpty()|| toDoList.getUserName().length()==0) {
			throw new UserInputException("Input Field is empty"+toDoList);
		}
		return todoListRepository.save(toDoList);
	}

	@Override
	public void deleteToDoById(long id) {
		todoListRepository.deleteById(id);
	}

}
