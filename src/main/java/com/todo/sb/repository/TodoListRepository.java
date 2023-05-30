package com.todo.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.sb.model.ToDoList;

@Repository
public interface TodoListRepository extends JpaRepository<ToDoList,Long> {

}
