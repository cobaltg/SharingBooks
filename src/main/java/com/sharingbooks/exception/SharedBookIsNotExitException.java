package com.sharingbooks.exception;

public class SharedBookIsNotExitException extends BorrowedException {

	public SharedBookIsNotExitException(String message, String message2) {
		super(message, message2);
	}

	public SharedBookIsNotExitException(String message) {
		super(message);
	}

}
