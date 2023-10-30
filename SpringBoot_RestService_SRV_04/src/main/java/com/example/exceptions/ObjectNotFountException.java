package com.example.exceptions;

public class ObjectNotFountException extends RuntimeException {
	
	public ObjectNotFountException (String message) {
		super (message); //passa il messaggio alla superclasse
	}
}
