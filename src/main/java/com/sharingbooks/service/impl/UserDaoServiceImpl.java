package com.sharingbooks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharingbooks.dao.UserInfoDao;
import com.sharingbooks.dto.Page;
import com.sharingbooks.entity.UserInfo;
import com.sharingbooks.service.UserInfoService;

@Service
public class UserDaoServiceImpl implements UserInfoService {
	
	private Page page;
		
	//注入依赖
	@Autowired
	private UserInfoDao userInfoDao;
	
	public int signIn(String userName, String userPwd, String userPhone) {
		int count= userInfoDao.addUser(userName, userPwd, userPhone);
		return count;
	}

	public int loginIn(String userNameOrPhone, String userPwd) {
		int count = userInfoDao.getUser(userNameOrPhone, userPwd, userNameOrPhone);
		return count;
	}

	public UserInfo queryUserInfoById(long userId) {
		return userInfoDao.getUserById(userId);
	}

	public int updateUserInfo(String userName, String userPwd,
			String userPhone, long userId) {
		int count= userInfoDao.updateUser(userName, userPwd, userPhone, userId);
		return count;
	}

	public List<UserInfo> getUserInfoListByPage(String userName,
			String userPhone, int currentPage) {
		page=new Page();
		page.setCurrentPage(currentPage);
		page.setTotalNumber(userInfoDao.countqueryUserInfoList(userName, userPhone));	
		System.out.println("+++++++++++++++++++++++");
		System.out.println(page);
		System.out.println("+++++++++++++++++++++++");
		return userInfoDao.queryUserInfoListByPage(userName, userPhone, page.getDbIndex(), page.getDbNumber());
	}
}
