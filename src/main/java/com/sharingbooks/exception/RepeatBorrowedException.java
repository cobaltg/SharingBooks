package com.sharingbooks.exception;

public class RepeatBorrowedException extends BorrowedBookException {

	public RepeatBorrowedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RepeatBorrowedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
