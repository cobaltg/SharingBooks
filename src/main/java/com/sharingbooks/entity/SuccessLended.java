package com.sharingbooks.entity;

import java.util.Date;

/**
 * 借出书籍成功明细表
 * @author think
 *
 */
public class SuccessLended {
	
	private long bookId;
		
	private String masterPhone;
	
	private Date createTime=new Date();

	private BorrowedBook borrowedBook;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getMasterPhone() {
		return masterPhone;
	}

	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BorrowedBook getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(BorrowedBook borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	@Override
	public String toString() {
		return "SuccessLended [bookId=" + bookId + ", masterPhone="
				+ masterPhone + ", createTime=" + createTime
				+ ", borrowedBook=" + borrowedBook + "]";
	}
}
