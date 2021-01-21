package com.automatodev.loa.api.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import com.automatodev.loa.domain.model.exceptionModel.ErrorHandlerEntity;
import com.automatodev.loa.domain.model.exceptionModel.FieldErrorEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//Classe usada no tratamento de erros nos retornos da api, evitando aqueles erros grotescos de 500 internal server error 
@ControllerAdvice //Indica que esta classe é um componente do Spring usado para tratamento de exceçoes de forma global
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RulesException.class) //A anotação ExceptionHandler fara a captação de todas as exceçoes geradas e passar a mensagem para RelesException
	public ResponseEntity<Object> rulesException(RulesException ex,WebRequest request){
		var status = HttpStatus.NOT_FOUND;
		var error = new ErrorHandlerEntity();
		switch(ex.getStatus()){
			case 404: 
				status = HttpStatus.NOT_FOUND;
				break;
			case 400:
				status = HttpStatus.BAD_REQUEST;
				break;
			case 201:
				status = HttpStatus.NO_CONTENT;
				break;
			case 422:
				status = HttpStatus.UNPROCESSABLE_ENTITY;
				break;
			case 200:
				status = HttpStatus.OK;
				break;
			
		}
		error.setStatus(status.value());
		error.setTitle(ex.getMessage());
		error.setDateCreate(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status,request);
		
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	HttpHeaders headers, HttpStatus status, WebRequest request) {
		var fields = new ArrayList<FieldErrorEntity>();
		var entityHandler = new ErrorHandlerEntity();
		
		for(ObjectError error: ex.getBindingResult().getAllErrors())
		fields.add(new FieldErrorEntity(((FieldError)error).getField(), error.getDefaultMessage()));
		
		
		entityHandler.setStatus(status.value());
		entityHandler.setTitle("Um ou mais campos são invalidos!");
		entityHandler.setDateCreate(OffsetDateTime.now());
		entityHandler.setFieldListError(fields);
		
		return super.handleExceptionInternal(ex, entityHandler, headers, status, request);
	}
	
	
	
	
}