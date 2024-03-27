package com.sreenu.online.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
	
    
	private static final long serialVersionUID = 1L;
	private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
