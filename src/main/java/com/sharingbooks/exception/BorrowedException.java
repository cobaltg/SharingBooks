package com.sharingbooks.exception;

/**
 * 执行借书相关业务异常（运行期异常）
 * @author think
 *
 */
public class BorrowedException extends RuntimeException {

	public BorrowedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BorrowedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BorrowedException(String message, String message2) {
		// TODO Auto-generated constructor stub
	}
	
}
