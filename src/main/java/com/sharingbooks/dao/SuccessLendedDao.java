package com.sharingbooks.dao;

import com.sharingbooks.entity.SuccessLended;

/**
 * 借出图书成功明细
 * @author think
 * return 返回表格更新行数
 */
public interface SuccessLendedDao {
	
	public int insertSuccessLended(SuccessLended successlended);
}
