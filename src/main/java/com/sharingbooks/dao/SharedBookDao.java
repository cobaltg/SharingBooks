package com.sharingbooks.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.SharedBook;

public interface SharedBookDao {
	/**
	 * 根据书籍Id查询可借书籍信息
	 * @param bookId
	 * @return 书籍信息
	 */
	public SharedBook querySharedBookById(long bookId);
	
	/**
	 * 根据书籍信息来模糊查询
	 * @param bookName 书名
	 * @param bookDescription 书籍描述
	 * @return 书籍信息列表
	 */
	public List<SharedBook> queryShareBookByBookInfo(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription);
	
	/**
	 * 根据书籍信息来查询符合信息的书籍列表的条数
	 * @param bookName 书名
	 * @param bookDescription 书籍描述
	 * @return 书籍信息的条数
	 */
	public int countSharedBook(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription);
	
	/**
	 * 根据偏移量查询书籍信息列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<SharedBook> querySharedBookList(@Param(value = "offset") int offset, @Param(value = "limit")  int limit);
	
	/**
	 * 查詢用戶自己的可借書籍的信息的條數
	 */
	public int countquerySharedBookListOfUser(@Param(value = "userPhone") String userPhone);
	
	/**
	 * 根据查询条件来查询用户的自己的可借书籍记录，按分页返回
	 * @param userName
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<SharedBook> querySharedBookListOfUserByPage(@Param(value = "userPhone") String userPhone,@Param(value = "offset") int offset, @Param(value = "limit")  int limit);
	
	/**
	 * 根据分页查询符合条件的书籍信息
	 * @param bookName
	 * @param bookDescription
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<SharedBook> querySharedBookListByPage(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription,@Param(value = "offset") int offset, @Param(value = "limit")  int limit);
	
	/**
	 * 添加可借书籍信息到可借书籍表中
	 * @param sharedbook 书籍的所有信息
	 * return 添加的行数
	 */
	public int addSharedBook(SharedBook sharedBook);
	
	/**
	 * 减书单上的记录
	 * @param bookId
	 * @param operatedTime
	 * @return 删除的行数
	 */
	public int reduceSharedBook(long bookId);
	
	/**
	 * 分享书籍时要相应的删除借出表中书籍的信息（若登记了）
	 * @param bookName 书籍名字
	 * @param userPhone 分享书籍用户的联系方式
	 * @return
	 */
	public  int reduceSharedBookByShared(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription, @Param(value = "userPhone") String userPhone);
	
	/**
	 * 更改可借书籍的信息
	 * @param bookName 书名
	 * @param bookDescription 书籍描述
	 * @return 更新行数
	 */
	public int updateSharedBook(@Param(value = "bookName") String bookName, @Param(value = "bookDescription") String bookDescription, @Param(value = "bookId") long bookId);
	
}
