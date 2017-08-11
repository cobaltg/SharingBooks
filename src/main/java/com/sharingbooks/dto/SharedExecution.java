package com.sharingbooks.dto;

import java.util.Date;

import com.sharingbooks.enums.SharedStateEnum;

public class SharedExecution {
	
	//借出书籍id
	private long bookId;
	
	//借出状态状态״̬
	private int state;
	
	//״状态描述
	private String stateinfo;
	
	private Date createTime;

	//借出成功
	public SharedExecution(long bookId, SharedStateEnum stateEnum, Date createTime
			) {
		super();
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateinfo = stateEnum.getStateInfo();
		this.createTime= createTime;
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
		return "SharedExecution [bookId=" + bookId + ", state=" + state
				+ ", stateinfo=" + stateinfo + ", createTime=" + createTime
				+ "]";
	}	
}
