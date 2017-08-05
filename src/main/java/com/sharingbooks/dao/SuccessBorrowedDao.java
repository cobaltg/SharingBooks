package com.sharingbooks.dao;

import com.sharingbooks.entity.SuccessBorrowed;

/**
 * 成功借阅书籍明细表的接口
 * @author think
 *
 */
public interface SuccessBorrowedDao {
	/**
	 * 插入借阅明细
	 * @param sharedbookid
	 * @return 返回表格更新行数
	 */
	public int insertSuccessBorrowed(SuccessBorrowed SuccessBorrowed);	
}
