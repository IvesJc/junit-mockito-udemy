package com.udemy.junitmockito.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(){
        super("Object not found!");
    }
}
