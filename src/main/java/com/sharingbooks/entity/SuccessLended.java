package com.sharingbooks.entity;

import java.util.Date;

/**
 * 借出书籍成功明细表
 * @author think
 *
 */
public class SuccessLended {
	
	private long listId;
	
	private String bookName;
	
	private String bookBorrower;
	
	private String masterPhone;
	
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

	public String getBookBorrower() {
		return bookBorrower;
	}

	public void setBookBorrower(String bookBorrower) {
		this.bookBorrower = bookBorrower;
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

	@Override
	public String toString() {
		return "SuccessLended [listId=" + listId + ", bookName=" + bookName
				+ ", bookBorrower=" + bookBorrower + ", masterPhone="
				+ masterPhone + ", createTime=" + createTime + "]";
	}


}
