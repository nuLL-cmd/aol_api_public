package com.automatodev.loa.domain.model.exceptionModel;
//Classe que representa os campos nome do campo e a mensagem de erro para este campo
public class FieldErrorEntity {
	//Atributos
	private String fieldTitle;
	private String fieldMessage;
	
	//Construtor
	public FieldErrorEntity(String fieldTitle, String fieldMessage) {
		this.fieldTitle = fieldTitle;
		this.fieldMessage = fieldMessage;
	
		
	}
		
	//Nada novo. Metodos getters e setters
	public void setFieldtitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	
	public String getFieldTitle() {
		return fieldTitle;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	

}
