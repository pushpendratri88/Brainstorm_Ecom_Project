package com.brainstorm.customer.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException(String message){
        super(message);

    }
}
