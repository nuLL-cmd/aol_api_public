package com.automatodev.loa.api.exceptionHandler;

public class RulesException extends RuntimeException {
  
    private static final long serialVersionUID = 1L;
    private final Integer status;
    public RulesException(String message, Integer status) {
        super(message);

        this.status = status;
    }

    public Integer getStatus(){
        return this.status;
    }

}