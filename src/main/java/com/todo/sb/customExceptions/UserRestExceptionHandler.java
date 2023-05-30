package com.todo.sb.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {
	
	//Exception Handler to catch UserNotFoundException
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException excep){
		//Create a UserErrorResponse
		UserErrorResponse error = new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(excep.getMessage());
		error.setTimeStamp(System.currentTimeMillis());  
		//return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Exception Handler to catch UserNotFoundException
   public ResponseEntity<UserErrorResponse>handleException(UserInputException exception){
		//Create a UserErrorResponse
	   UserErrorResponse userError = new UserErrorResponse();
	   userError.setStatus(HttpStatus.BAD_REQUEST.value());
	   userError.setMessage(exception.getMessage());
	   userError.setTimeStamp(System.currentTimeMillis());
	   return new ResponseEntity<>(userError, HttpStatus.NOT_FOUND);
   }
   
	//Another Exception Handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse>handleException(Exception exp){
		//Create a UserErrorResponse
		UserErrorResponse err = new UserErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(exp.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		//return ResponseEntity
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
}
