package com.sharingbooks.dao;

import java.util.List;
import java.util.Map;

import com.sharingbooks.entity.SuccessBorrowed;

/**
 * 成功借阅书籍明细表的接口
 * @author think
 *
 */
public interface SuccessBorrowedDao {
	/**
	 * 插入借阅明细
	 * @param successBorrowed
	 * @return 返回表格更新行数
	 */
	public int insertSuccessBorrowed(SuccessBorrowed successBorrowed);	
	
	/**
	 * 用户查询自己的借阅成功明细表
	 * @param parameter 封装了UserInfo对象和Page对象
	 * @return
	 */
	public List<SuccessBorrowed> querySuccessBorrowedList(Map<String,Object> parameter);
	
	/**
	 * 根据查询条件查询明细表的条数
	 */
	public int countSuccessBorrowed(String userPhone);
}
