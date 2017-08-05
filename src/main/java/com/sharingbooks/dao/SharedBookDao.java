package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sharingbooks.entity.SharedBook;

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
	public int reduceSharedBook(long bookId, Date operatedTime);
	
	//修改可借书籍表的书籍信息
	public void updateSharedBook(SharedBook sharedbook);
	
	//查询可借书籍列表信息所需接口
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<SharedBook> querySharedBookList(Map<String,Object> parameter);
	
	/**
	 * 根据id查询所借书籍的信息
	 * @param bookid 书籍号
	 * @return
	 */
	public SharedBook querySharedBookById(long bookid);
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int countSharedBook(SharedBook sharedbook);
}
