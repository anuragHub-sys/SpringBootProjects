package com.tms.ECommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String msg){
        super(msg);
    }
}
