package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BorrowedBookDao {
	
	//向借书登记表中添加需借书籍所需接口
			/**
			 * 添加一条需借书籍信息
			 * @param borrowedbook 书籍的所有信息
			 * return 插入的行数
			 */
			public int addBorrowedBook(BorrowedBookDao borrowedbook);
	
	//删除信息操作所需的接口，或
	//分享书籍操作所需接口
		/**
		 * 减借书登记表中的一条记录
		 * @param bookId
		 * @param operatedTime
		 * @return 删除的行数
		 */
		public int reduceBorrowedBook(long bookId, Date operatedTime);
		
		//修改表中书籍的信息
		public void updateBorrowedBook(BorrowedBookDao borrowedbook);
		
		
		
		//查询可借书籍列表信息所需接口
		/**
		 * 根据查询条件查询借书登记表中的所有信息
		 */
		public List<BorrowedBookDao> queryBorrowedBookList(Map<String,Object> parameter);
		
		/**
		 * 根据id查询借书登记表中书籍的信息
		 * @param bookid 书籍号
		 * @return
		 */
		public BorrowedBookDao queryBorrowedBookById(long bookid);
		
		/**
		 * 根据查询条件查询消息列表的条数
		 */
		public int countBorrowedBook(BorrowedBookDao borrowedbook);
}
