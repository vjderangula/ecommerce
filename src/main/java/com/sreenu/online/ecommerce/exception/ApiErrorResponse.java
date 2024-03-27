package com.sreenu.online.ecommerce.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@Setter
@Getter
public class ApiErrorResponse {

	public ApiErrorResponse(String guid, ErrorCodes internalError, int value, String name, String requestURI,
			String method2, LocalDateTime now) {
		this.guid=guid;
		this.errorCode = "";
		this.message = "";
		this.statusCode = null;
		this.statusName = "";
		this.path = "";
		this.method = "";
		this.timestamp = null;
	}
	private final String guid;
    private final String errorCode;
    private final String message;
    private final Integer statusCode;
    private final String statusName;
    private final String path;
    private final String method;
    private final LocalDateTime timestamp;
}
