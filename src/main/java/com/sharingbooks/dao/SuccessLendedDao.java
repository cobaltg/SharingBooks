package com.sharingbooks.dao;

import java.util.List;
import java.util.Map;

import com.sharingbooks.entity.SuccessLended;

/**
 * 借出图书成功明细
 * @author think
 * return 返回表格更新行数
 */
public interface SuccessLendedDao {
	/**
	 * 插入借出明细
	 * @param successLended
	 * @return 返回表格更新行数
	 */
	public int insertSuccessLended(SuccessLended successLended);
	
	/**
	 * 用户查询自己的借出成功明细表
	 * @param parameter 封装了UserInfo对象和Page对象
	 * @return
	 */
	public List<SuccessLended> querySuccessLendedList(Map<String,Object> parameter);
	
	/**
	 * 根据查询条件查询明细表的条数
	 */
	public int countSuccessLended(String userPhone);
}
