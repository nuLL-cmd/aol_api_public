package com.automatodev.loa.domain.model.exceptionModel;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//Classe do tipo POJO que representarar os dados do retorno de erro caso aconteça durante as operações
public class ErrorHandlerEntity {
	
	//Atributos da classe incluindo uma lista do tipo FieldErrorEntity (classe que represetna os campos contendo os erros)
	private Integer status;
	private String title;
	private OffsetDateTime dateCreate;
	@JsonInclude(Include.NON_NULL)
	private List<FieldErrorEntity> fieldListError;
	
	//Construtor vazio 
	public ErrorHandlerEntity() {
		
	}
	
	//Construtor da classe contendo os atributos da classe
	public ErrorHandlerEntity(Integer status, String title, OffsetDateTime dateCreate, List<FieldErrorEntity> fieldListError, int codeEnum) {
		this.status = status;
		this.title = title;
		this.dateCreate = dateCreate;
		this.fieldListError = fieldListError;
	}
	
	
	//Nada novo. Metodos getters e setters

	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDateCreate(OffsetDateTime dateCreate) {
		this.dateCreate = dateCreate;
	}
	public void setFieldListError(List<FieldErrorEntity> fieldListError) {
		this.fieldListError = fieldListError;
	}
	public Integer getStatus() {
		return status;
	}
	public String getTitle() {
		return title;
	}
	public OffsetDateTime getDateCreate() {
		return dateCreate;
	}
	public List<FieldErrorEntity> getFieldListError(){
		return fieldListError;
	}
	
	
	

}
