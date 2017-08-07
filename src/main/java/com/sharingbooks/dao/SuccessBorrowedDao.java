package com.sharingbooks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.SuccessBorrowed;

/**
 * 成功借阅书籍明细表的接口
 * @author think
 */
public interface SuccessBorrowedDao {
	
	/**
	 * 插入借阅成功明细
	 * @param bookId 书籍id
	 * @param borrowerPhone 借书人电话号码
	 * @return
	 */
	public int insertSuccessBorrowed(@Param(value = "bookId") long bookId, @Param(value = "borrowerPhone") String borrowerPhone);	
	
	/**
	 * 根据id查询SuccessBorrowed并携带借阅书籍对象实体
	 * @param bookId
	 * @return
	 */
	public SuccessBorrowed queryByIdWithSharedBook(long bookId);
	
	/**
	 * 用户查询自己的借阅成功明细表
	 * @param borrowerPhone 用户自己的电话号码
	 * @return 明细信息列表
	 */
	public List<SuccessBorrowed> querySuccessBorrowedListByBorrowerPhone(String borrowerPhone);
	
	/**
	 * 根据查询条件查询用户的借阅明细表的条数
	 */
	public int countSuccessBorrowedByBorrowerPhone(String borrowerPhone);
	
	/**
	 * 查询所有成功借阅明细信息
	 * @return
	 */
	public List<SuccessBorrowed> querySuccessBorrowed();
	/**
	 * 查询所有成功借阅明细条数
	 * @return
	 */
	public int countSuccessBorrowed();
	
	/**
	 * 根据偏移量来查询成功借阅明细列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<SuccessBorrowed> querySuccessBorrowedList(@Param(value = "offset") int offset, @Param(value = "limit") int limit);
}
