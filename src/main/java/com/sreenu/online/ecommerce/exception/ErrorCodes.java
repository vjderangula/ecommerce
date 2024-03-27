package com.sreenu.online.ecommerce.exception;

public enum ErrorCodes {

	/*
	 * INTERNAL_ERROR(5, "NoData found"), DATABASE_ERROR(3, "DATABASE_ERROR"),
	 * DUPLICATE_USERS (4, "DUPLICATE_USER"), DATABASE(1,
	 * "A database error has occured."), DUPLICATE_USER(5007,
	 * "This user already exists."), NO_File(2,"No file found. "); private final int
	 * id; private final String message; private ErrorCodes(int id, String value) {
	 * this.id = id; this.message = value; }
	 * 
	 * public int getId() { return id; } public String getMessage() { return
	 * message; }
	 */
	
	INTERNAL_ERROR( "NoData found"),
	 DATABASE_ERROR( "DATABASE_ERROR"),
    DUPLICATE_USERS ( "DUPLICATE_USER"),
	DATABASE( "A database error has occured."),
	  DUPLICATE_USER( "This user already exists."),
		NO_File("No file found. ");
	  private final String message;
		private ErrorCodes( String value) { 
		     this.message = value;
		    }
		
		  public String getMessage() { return message; }
};
