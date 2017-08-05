package com.sharingbooks.entity;

import java.util.Date;

/**
 * 借阅成功明细表
 * @author think
 */
public class SuccessBorrowed {
	private long listId;
	
	private String bookName;
	
	private String bookMaster;
	
	private String state;
	
	private Date createTime;

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(String bookMaster) {
		this.bookMaster = bookMaster;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SuccessBorrowed [listId=" + listId + ", bookName=" + bookName
				+ ", bookMaster=" + bookMaster + ", state=" + state
				+ ", createTime=" + createTime + "]";
	}
}
