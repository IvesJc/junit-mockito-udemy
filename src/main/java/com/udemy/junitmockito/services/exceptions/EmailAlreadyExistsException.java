package com.udemy.junitmockito.services.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(){
        super("Email already registered!");
    }
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
