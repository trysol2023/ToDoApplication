package com.todo.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.sb.model.ToDoList;

public interface TodoListRepository extends JpaRepository<ToDoList,Long> {

}
