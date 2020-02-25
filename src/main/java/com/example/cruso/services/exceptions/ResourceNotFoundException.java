package com.example.cruso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super ("Resouce nott foundd meu erro. Id = " + id);		
	}

}
