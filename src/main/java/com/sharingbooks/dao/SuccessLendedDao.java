package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.SuccessLended;

/**
 * 借出图书成功明细
 * @author think
 */
public interface SuccessLendedDao {

	/**
	 * 插入成功借出书籍明细
	 * @param bookId
	 * @param bookName
	 * @param bookDescription
	 * @param bookMaster
	 * @param borrowerName
	 * @param createTime
	 * @return
	 */
	public int insertSuccessLended(@Param(value = "bookId") long bookId,
			@Param(value = "bookName") String bookName,
			@Param(value = "bookDescription") String bookDescription,
			@Param(value = "bookMaster") String bookMaster,
			@Param(value = "receiverName") String receiverName,
			@Param(value = "createTime") Date createTime);
		
	/**
	 * 根据查询条件查询用户的借出明细表的条数
	 * @param userName
	 * @return
	 */
	public int countSuccessLendedOfUser(String userName);
	
	/**
	 * 用户查询自己的成功借出明细，然后按页返回
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<SuccessLended> querySuccessLendedListOfUserByPage(
			@Param(value = "userName") String userName,
			@Param(value = "offset") int offset,
			@Param(value = "limit") int limit);
	
	
	/**
	 * 查询所有成功借出明细条数
	 * @return
	 */
	public int countSuccessLendedList();
	
	/**
	 * 查询所有的成功借出书籍明细表，然后按页返回
	 * @param offset 从哪开始取
	 * @param limit 取多少条
	 * @return
	 */
	public List<SuccessLended> querySuccessLendedListByPage(
			@Param(value = "offset") int offset,
			@Param(value = "limit") int limit);
}
