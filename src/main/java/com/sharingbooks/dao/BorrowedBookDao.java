package com.sharingbooks.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.BorrowedBook;

public interface BorrowedBookDao {
	
		/**
		 * 根据书籍Id查询借书信息
		 * @param bookId
		 * @return 书籍信息
		 */
		public BorrowedBook queryBorrowedBookById(long bookId);
		
		/**
		 * 根据书籍信息来模糊查询
		 * @param bookName 书名
		 * @param bookDescription 书籍描述
		 * @return 借出信息列表
		 */
		public List<BorrowedBook> queryBorrowedBookByBookInfo(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription);
		
		/**
		 * 根据书籍信息来查询符合信息的书籍列表的条数
		 * @param bookName 书名
		 * @param bookDescription 书籍描述
		 * @return 借书信息的条数
		 */
		public int countBorrowedBook(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription);
		
		/**
		 * 根据偏移量查询借书籍信息列表
		 * @param offset
		 * @param limit
		 * @return
		 */
		public List<BorrowedBook> queryBorrowedBookList(@Param(value = "offset") int offset, @Param(value = "limit")  int limit);
		
		/**
		 * 添加一条需借书籍信息
		 * @param borrowedbook 书籍的所有信息
		 * return 插入的行数
		 */
		public int addBorrowedBook(BorrowedBook borrowedBook);
	
		/**
		 * 减借书登记表中的一条记录
		 * @param bookId
		 * @param operatedTime
		 * @return 删除的行数
		 */
		public int reduceBorrowedBook(long bookId);
		
		/**
		 * 当用户借书时，需要修改自身的借书信息（如登记了，则要减一）。
		 * @param bookName 书籍名字
		 * @param userPhone 借书用户的联系方式
		 */
		public  int reduceBorrowedBookByBorrowed(@Param(value = "bookName") String bookName, @Param(value = "userPhone") String userPhone);
	
		/**
		 * 更改借书信息
		 * @param bookName 书名
		 * @param bookDescription 书籍描述
		 * @return 更新行数
		 */
		public int updateBorrowedBook(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription, @Param(value = "bookId") long bookId);
	
}
