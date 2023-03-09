package com.todo.sb.model;

	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	@Entity
	@Table(name = "todolist")
	public class ToDoList {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private long id;
	    private String userName;
	    private String description;
	    private String dueDate;
	    private String status;
	    
	    public ToDoList() {
	    }
	    
		public ToDoList(long id, String username, String description, String dueDate, String status) {
			super();
			this.id = id;
			this.userName = userName;
			this.description = description;
			this.dueDate = dueDate;
			this.status = status;
		}
		
		
		@Column(name = "id", nullable = false)
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		 @Column(name = "userName", nullable = false)
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		 @Column(name = "description", nullable = false)
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		 @Column(name = "dueDate",nullable = false)
		public String getDueDate() {
			return dueDate;
		}
		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}
		 @Column(name = "status", nullable = false)
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	}


