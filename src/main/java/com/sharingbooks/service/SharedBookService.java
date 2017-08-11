package com.sharingbooks.service;

import java.util.Date;
import java.util.List;

import com.sharingbooks.dto.BorrowedExecution;
import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.exception.BorrowedException;
import com.sharingbooks.exception.RepeatBorrowedException;
import com.sharingbooks.exception.SharedBookIsNotExitException;

public interface SharedBookService {

	/**
	 * 根据id单条查询可借书籍记录
	 * @param bookId
	 * @return
	 */
	SharedBook getById(long bookId);
	
	/**
	 * ͨ根据书籍的书名和描述信息查询符合条件的可借书籍的记录
	 * @param bookName
	 * @param bookDescription
	 * @return
	 */
	List<SharedBook> getSharedBookByBookInfo(String bookName, String bookDescription);
	
	/**
	 *根据书籍的书名和描述信息查询符合条件的可借书籍的记录的条数
	 * @param bookName
	 * @param bookDescription
	 * @return
	 */
	int countSharedBookByBookInfo(String bookName, String bookDescription);

	/**
	 * 根据分页查询可借书籍记录
	 * @param bookName
	 * @param bookDescription
	 * @param currentPage
	 * @return
	 */
	List<SharedBook> getSharedBookListByPage(String bookName, String bookDescription, int currentPage);

	/**
	 *执行借书操作
	 * @param bookId
	 * @param userPhone
	 */
	BorrowedExecution executeBorrowed(long bookId, String userPhone)
			throws BorrowedException,RepeatBorrowedException,SharedBookIsNotExitException;
		
	/**
	 * 根据分页查询用户的可借书籍记录
	 * @param currentPage
	 * @param userPhone
	 * @return
	 */
	List<SharedBook> getSharedBookListOfUserByPage(int currentPage,String userPhone);
	
	
	/**
	 * 添加一条可借书籍信息
	 * @param bookname
	 * @param bookDescription
	 * @param masterPhone
	 * @param releaseTime
	 * @return
	 */
	int addOneSharedBook(String bookname, String bookDescription, String masterPhone,Date releaseTime);
	
	/**
	 * 根据id删除一条可借书籍信息记录
	 * @param bookId
	 * @return
	 */
	int reduceOneSharedBook(long bookId);
	
	/**
	 * 更改书籍id的可借书籍信息
	 * @param bookName
	 * @param bookDescription
	 * @param bookId
	 * @return
	 */
	int updateSharedBook(String bookName, String bookDescription, long bookId);
}
