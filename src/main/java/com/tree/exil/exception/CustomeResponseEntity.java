package com.tree.exil.exception;

import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomeResponseEntity extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex,WebRequest req){
		
		ErrorObject object=new ErrorObject(new Date(),ex.getMessage(),req.getDescription(true));
		
		return new ResponseEntity<Object>(object,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<Object> HandleUserNotFound(Exception ex,WebRequest req){
		
		ErrorObject object=new ErrorObject(new Date(),ex.getMessage(),"SORRY USER NOT FOUND IN DB");
		
		return new ResponseEntity<Object>(object,HttpStatus.NOT_FOUND);
		
		
	}

}
