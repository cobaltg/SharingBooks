package com.sharingbooks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.SuccessLended;

/**
 * 借出图书成功明细
 * @author think
 */
public interface SuccessLendedDao {

	/**
	 * 插入借出明细
	 * @param bookId 书籍id
	 * @param masterPhone 借出人电话号码
	 * @return
	 */
	public int insertSuccessLended(@Param(value = "bookId") long bookId, @Param(value = "masterPhone") String masterPhone);
	
	/**
	 * 根据id查询SuccessLended并携带借出书籍对象实体
	 * @param bookId
	 * @return
	 */
	public SuccessLended queryByIdWithBorrowedBook(long bookId);
	/**
	 * 用户查询自己的借出成功明细表
	 * @param masterPhone 用户电话号码
	 * @return
	 */
	public List<SuccessLended> querySuccessLendedListByMasterPhone(String masterPhone);
	
	/**
	 * 根据查询条件查询用户的借出明细表的条数
	 */
	public int countSuccessBorrowedByMasterPhone(String masterPhone);
	
	/**
	 * 查询所有成功借出明细信息
	 * @return
	 */
	public List<SuccessLended> querySuccessLended();
	
	/**
	 * 查询所有成功借出明细条数
	 * @return
	 */
	public int countSuccessLended();
	
	/**
	 * 根据偏移量来查询成功借出明细列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<SuccessLended> querySuccessLendedList(@Param(value = "offset") int offset, @Param(value = "limit") int limit);
}
