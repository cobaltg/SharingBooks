package com.sharingbooks.entity;

import java.util.Date;

public class BorrowedBook {
	
		private long bookId;
		
		private String bookName;
		
		private String bookDescription;
		
		private String borrowerPhone;
			
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

		public String getBorrowerPhone() {
			return borrowerPhone;
		}

		public void setBorrowerPhone(String borrowerPhone) {
			this.borrowerPhone = borrowerPhone;
		}

		public Date getReleaseTime() {
			return releaseTime;
		}

		public void setReleaseTime(Date releaseTime) {
			this.releaseTime = releaseTime;
		}

		@Override
		public String toString() {
			return "borrowerBook [bookId=" + bookId + ", bookName=" + bookName
					+ ", bookDescription=" + bookDescription + ", borrowerPhone="
					+ borrowerPhone + ", releaseTime=" + releaseTime + "]";
		}
}
