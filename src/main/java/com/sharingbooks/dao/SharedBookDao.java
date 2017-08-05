package com.sharingbooks.dao;

import java.util.List;
import java.util.Map;

import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.util.BooknameUserphone;

public interface SharedBookDao {
	//向可借书籍信息表中添加书籍所需接口
	/**
	 * 添加可借书籍信息到可借书籍表中
	 * @param sharedbook 书籍的所有信息
	 * return 添加的行数
	 */
	public int addSharedBook(SharedBook sharedbook);
	
	//删除一条可借书籍信息，或
	//借书操作所需接口
	/**
	 * 减书单上的记录
	 * @param bookId
	 * @param operatedTime
	 * @return 删除的行数
	 */
	public int reduceSharedBook(long bookId);
	
	/**
	 * 当用户借出书时，需要修改自身的借出书籍信息（如登记了，则要减一）。
	 * @param parameter 书名和借书人的联系方式
	 * @return
	 */
	public  int reduceSharedBookByUserInfo(BooknameUserphone booknameUserphone);
	
	//修改表中书籍的信息
	public void updateSharedBook(SharedBook sharedbook);
	
	//查询可借书籍列表信息所需接口
	/**
	 * 根据查询条件查询可借书籍登记表中的所有信息(把BorrowedBookDao对象、Page对象封装在Map中。根据书名、书籍描述、第几条开始取、总共去多少条信息)
	 */
	public List<SharedBook> querySharedBookList(Map<String,Object> parameter);
	
	/**
	 * 根据查询条件查询书籍的条数
	 */
	public int countSharedBook(SharedBook sharedbook);
}
