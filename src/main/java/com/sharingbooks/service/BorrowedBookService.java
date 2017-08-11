package com.sharingbooks.service;

import java.util.Date;
import java.util.List;

import com.sharingbooks.dto.SharedExecution;
import com.sharingbooks.entity.BorrowedBook;
import com.sharingbooks.exception.BorrowedBookIsNotExitException;
import com.sharingbooks.exception.RepeatSharedException;
import com.sharingbooks.exception.SharedException;

public interface BorrowedBookService {
	/**
	 * 根据id单条查询要借书籍记录
	 * @param bookId
	 * @return
	 */
	BorrowedBook getById(long bookId);
	
	/**
	 * ͨ根据书籍的书名和描述信息查询符合条件的需借书籍的记录
	 * @param bookName
	 * @param bookDescription
	 * @return
	 */
	List<BorrowedBook> getBorrowedBookByBookInfo(String bookName, String bookDescription);
	
	/**
	 *根据书籍的书名和描述信息查询符合条件的需借书籍的记录的条数
	 * @param bookName
	 * @param bookDescription
	 * @return
	 */
	int countBorrowedBookByBookInfo(String bookName, String bookDescription);
	
	/**
	 * 根据分页查询需借书籍记录
	 * @param bookName
	 * @param bookDescription
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<BorrowedBook> getBorrowedBookListByPage(String bookName, String bookDescription, int currentPage);

	/**
	 *执行借出操作
	 * @param bookId
	 * @param userPhone
	 */
	SharedExecution executeShared(long bookId, String userPhone)
			throws SharedException,RepeatSharedException,BorrowedBookIsNotExitException;
	
	/**
	 *根据书籍的书名和描述信息查询符合条件的需借书籍的记录的条数
	 * @param userPhone
	 * @return
	 */
	int countBorrowedBookOfUserByBookInfo(String userPhone);
	
	/**
	 * 根据分页查询用户的需借书籍记录
	 * @param currentPage
	 * @param userPhone
	 * @return
	 */
	List<BorrowedBook> getBorrowedBookListOfUserByPage(int currentPage,String userPhone);
	
	/**
	 * 添加一条需借书籍信息
	 * @param bookname
	 * @param bookDescription
	 * @param borrowerPhone
	 * @param releaseTime
	 * @return
	 */
	int addOneBorrowedBook(String bookName, String bookDescription, String borrowerPhone,Date releaseTime);
	
	/**
	 * 根据id删除一条需借书籍信息记录
	 * @param bookId
	 * @return
	 */
	int reduceOneBorrowedBook(long bookId);
	
	/**
	 * 更改书籍id的需借书籍信息
	 * @param bookName
	 * @param bookDescription
	 * @param bookId
	 * @return
	 */
	int updateBorrowedBook(String bookName, String bookDescription, long bookId);
}
