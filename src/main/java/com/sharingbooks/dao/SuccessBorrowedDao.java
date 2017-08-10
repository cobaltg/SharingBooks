package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.SuccessBorrowed;

/**
 * 成功借阅书籍明细表的接口
 * 
 * @author think
 */
public interface SuccessBorrowedDao {
	
	/**
	 * 插入成功借阅明细
	 * @param bookId
	 * @param bookName
	 * @param bookDescription
	 * @param bookMaster
	 * @param borrowerName
	 * @param createTime
	 * @return 
	 */
	public int insertSuccessBorrowed(@Param(value = "bookId") long bookId,
			@Param(value = "bookName") String bookName,
			@Param(value = "bookDescription") String bookDescription,
			@Param(value = "bookMaster") String bookMaster,
			@Param(value = "borrowerName") String borrowerName,
			@Param(value = "createTime") Date createTime);

	/**
	 * 根据查询条件查询用户的借阅明细表的条数
	 * @param userName
	 * @return
	 */
	public int countSuccessBorrowedOfUser(String userName);

	/**
	 * 用户查询自己的成功借阅明细，然后按页返回
	 * @param userName
	 * @param offset 从哪开始取
	 * @param limit 取多少条
	 * @return
	 */
	public List<SuccessBorrowed> querySuccessBorrowedListOfUserByPage(
			@Param(value = "userName") String userName,
			@Param(value = "offset") int offset,
			@Param(value = "limit") int limit);
	

	/**
	 * 查询所有成功借阅明细条数
	 * @return
	 */
	public int countSuccessBorrowedList();

	/**
	 * 查询所有的成功借阅书籍明细表，然后按页返回
	 * @param offset 从哪开始取
	 * @param limit 取多少条
	 * @return
	 */
	public List<SuccessBorrowed> querySuccessBorrowedListByPage(
			@Param(value = "offset") int offset,
			@Param(value = "limit") int limit);
}
