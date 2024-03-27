package com.sreenu.online.ecommerce.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sreenu.online.ecommerce.exception.ApiErrorResponse;
import com.sreenu.online.ecommerce.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductExceptionHandler {
	
	static LocalDateTime ldt =  LocalDateTime.now(); 
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    String formatDateTime = ldt.format(format);
	
    @ExceptionHandler(ProductNotFoundException.class)
	public ApiErrorResponse handleProductNotFoundException() {
		return ApiErrorResponse.builder()
				.guid("1253")
				.errorCode("No Product")
				.message("No Data available for Product")
				.statusCode(404)
				.statusName("Not Fount")
				.path("/product")
				.method("GetProduct")
				.timestamp(ldt).build();
	}

}
