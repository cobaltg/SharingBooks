package com.sharingbooks.dto;

import com.sharingbooks.entity.SuccessBorrowed;
import com.sharingbooks.enums.BorrowedBookStateEnum;

public class BorrowedBookExecution {
	
	//借阅书籍id
	private long bookId;
	
	//借阅状态状态״̬
	private int state;
	
	//״状态描述
	private String stateinfo;
	
	//所借书籍实体对象
	private SuccessBorrowed successBorrowed;

	public long getBookId() {
		return bookId;
	}

	//借阅成功
	public BorrowedBookExecution(long bookId, BorrowedBookStateEnum stateEnum,
			SuccessBorrowed successBorrowed) {
		super();
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateinfo = stateEnum.getStateInfo();
		this.successBorrowed = successBorrowed;
	}
	
	//借阅失败
	public BorrowedBookExecution(long bookId, BorrowedBookStateEnum stateEnum) {
		super();
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateinfo = stateEnum.getStateInfo();
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateinfo() {
		return stateinfo;
	}

	public void setStateinfo(String stateinfo) {
		this.stateinfo = stateinfo;
	}

	public SuccessBorrowed getSuccessBorrowed() {
		return successBorrowed;
	}

	public void setSuccessBorrowed(SuccessBorrowed successBorrowed) {
		this.successBorrowed = successBorrowed;
	}
}
