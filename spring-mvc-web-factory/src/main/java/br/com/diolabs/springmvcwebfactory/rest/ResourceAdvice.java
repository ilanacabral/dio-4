package br.com.diolabs.springmvcwebfactory.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.diolabs.springmvcwebfactory.exception.JediException;
import br.com.diolabs.springmvcwebfactory.exception.JediNotFoundException;

@ControllerAdvice
public class ResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JediNotFoundException.class)
    public void notFound() {
        
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JediException.class)
    public void badRequest() {
        
    }
    
}
