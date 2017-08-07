package com.sharingbooks.entity;

import java.util.Date;

/**
 * 借阅成功明细表
 * @author think
 */
public class SuccessBorrowed {
	private long bookId;
	
	private String borrowerPhone;
	
	private Date createTime=new Date();
	
	private SharedBook sharedBook;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBorrowerPhone() {
		return borrowerPhone;
	}

	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SharedBook getSharedBook() {
		return sharedBook;
	}

	public void setSharedBook(SharedBook sharedBook) {
		this.sharedBook = sharedBook;
	}

	@Override
	public String toString() {
		return "SuccessBorrowed [listId=" + bookId + ", borrowerPhone="
				+ borrowerPhone + ", createTime=" + createTime
				+ ", sharedBook=" + sharedBook + "]";
	}
}
