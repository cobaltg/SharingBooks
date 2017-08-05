package com.sharingbooks.entity;

import java.sql.Date;

public class SharedBook {
	
	private long bookId;
	
	private String bookName;
	
	private String bookDescription;
	
	private String masterPhone;
	
	private Date releaseTime;

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

	public String getMasterPhone() {
		return masterPhone;
	}

	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Override
	public String toString() {
		return "SharedBook [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookDescription=" + bookDescription + ", masterPhone="
				+ masterPhone + ", releaseTime=" + releaseTime + "]";
	}
	
	
	
}
