package com.sharingbooks.entity;

import java.util.Date;

/**
 * 借出书籍成功明细表
 * @author think
 *
 */
public class SuccessLended {
	
	private long bookId;
	
	private String bookName;
	
	private String bookDescription;
	
	private String bookMaster;
	
	private String ReceiverName;
	
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

	public String getReceiverName() {
		return ReceiverName;
	}

	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SuccessLended [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookDescription=" + bookDescription + ", bookMaster="
				+ bookMaster + ", ReceiverName=" + ReceiverName
				+ ", createTime=" + createTime + "]";
	}	
}
