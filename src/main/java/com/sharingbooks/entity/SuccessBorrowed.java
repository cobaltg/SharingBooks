package com.sharingbooks.entity;

import java.util.Date;

/**
 * 借阅成功明细表
 * @author think
 */
public class SuccessBorrowed {
	
	private long bookId;
	
	private String bookName;
	
	private String bookDescription;
	
	private String bookMaster;
	
	private String borrowerName;
	
	private Date createTime;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(String bookMaster) {
		this.bookMaster = bookMaster;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SuccessBorrowed [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookDescription=" + bookDescription + ", bookMaster="
				+ bookMaster + ", borrowerName=" + borrowerName
				+ ", createTime=" + createTime + "]";
	}

}
