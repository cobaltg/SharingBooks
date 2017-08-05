package com.sharingbooks.dao;

import java.util.List;
import java.util.Map;

import com.sharingbooks.entity.BorrowedBook;
import com.sharingbooks.util.BooknameUserphone;

public interface BorrowedBookDao {
	
	//向借书登记表中添加需借书籍所需接口
			/**
			 * 添加一条需借书籍信息
			 * @param borrowedbook 书籍的所有信息
			 * return 插入的行数
			 */
			public int addBorrowedBook(BorrowedBook borrowedbook);
	
	//删除信息操作所需的接口，或
	//分享书籍操作所需接口
		/**
		 * 减借书登记表中的一条记录
		 * @param bookId
		 * @param operatedTime
		 * @return 删除的行数
		 */
		public int reduceBorrowedBook(long bookId);
		
		/**
		 * 当用户借书时，需要修改自身的借书信息（如登记了，则要减一）。
		 * @param parameter 书名和借书人的联系方式
		 * @return
		 */
		public int reduceBorrowedBookByUserInfo(BooknameUserphone booknameUserphone);
	
		//修改表中书籍的信息
		public int updateBorrowedBook(BorrowedBook borrowedbook);
			
		//查询可借书籍列表信息所需接口
		/**
		 * 根据查询条件查询借书登记表中的所有信息(把BorrowedBookDao对象、Page对象封装在Map中。根据书名、书籍描述、第几条开始取、总共去多少条信息)
		 */
		public List<BorrowedBook> queryBorrowedBookList(Map<String,Object> parameter);
				
		/**
		 * 根据查询条件查询书籍信息的条数
		 */
		public int countBorrowedBook(BorrowedBook borrowedbook);
}
