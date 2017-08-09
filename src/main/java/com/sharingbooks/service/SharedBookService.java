package com.sharingbooks.service;

import java.util.List;

import com.sharingbooks.dto.BorrowedBookExecution;
import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.exception.BorrowedBookException;
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
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<SharedBook> getSharedBookListByPage(String bookName, String bookDescription, int currentPage);

	/**
	 *执行借书操作
	 * @param bookId
	 * @param userPhone
	 */
	BorrowedBookExecution executeBorrowedBook(long bookId, String userPhone)
			throws BorrowedBookException,RepeatBorrowedException,SharedBookIsNotExitException;
}
