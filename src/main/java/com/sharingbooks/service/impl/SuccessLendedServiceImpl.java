package com.sharingbooks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharingbooks.dao.SuccessLendedDao;
import com.sharingbooks.dto.Page;
import com.sharingbooks.entity.SuccessLended;
import com.sharingbooks.service.SuccessLendedService;

@Service
public class SuccessLendedServiceImpl implements SuccessLendedService {

	@Autowired
	private SuccessLendedDao successLendedDao;
	
	private Page page;
	
	public List<SuccessLended> getSuccessLendedListOfUserByPage(
			String userPhone, int currentPage) {
		// page对象是一个Bean,是有状态的，所以在这new一个Page对象
		page = new Page();
		// 设置当前页数
		page.setCurrentPage(currentPage);
		// 获取需要显示书籍信息总条数
		page.setTotalNumber(successLendedDao.countSuccessLendedOfUser(userPhone));
		// 根据偏移量显示分页书籍信息
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(page);
		System.out.println("++++++++++++++++++++++++++++++");
		return successLendedDao.querySuccessLendedListOfUserByPage(userPhone, page.getDbIndex(), page.getDbNumber());
	}

}
