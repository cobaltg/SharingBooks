package com.sharingbooks.exception;

/**
 * 执行借出书籍业务所发生的异常
 * @author think
 *
 */
public class SharedException extends RuntimeException{

	public SharedException(String message) {
		super(message);
	}

	public SharedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SharedException(String message, String message2) {
		// TODO Auto-generated constructor stub
	}

	public SharedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
