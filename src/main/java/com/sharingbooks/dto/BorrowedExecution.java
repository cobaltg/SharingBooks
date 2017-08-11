package com.sharingbooks.dto;

import java.util.Date;

import com.sharingbooks.enums.BorrowedStateEnum;

public class BorrowedExecution {
	
	//借阅书籍id
	private long bookId;
	
	//借阅状态
	private int state;
	
	//״状态描述
	private String stateinfo;
	
	private Date createTime;

	public BorrowedExecution(long bookId, BorrowedStateEnum stateEnum,
			Date createTime) {
		super();
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateinfo = stateEnum.getStateInfo();
		this.createTime = createTime;
	}

	public long getBookId() {
		return bookId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BorrowedExecution [bookId=" + bookId + ", state=" + state
				+ ", stateinfo=" + stateinfo + ", createTime=" + createTime
				+ "]";
	}
}
