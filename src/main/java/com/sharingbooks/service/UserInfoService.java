package com.sharingbooks.service;

import java.util.List;

import com.sharingbooks.entity.UserInfo;

public interface UserInfoService {
	
	/**
	 * 添加用戶信息
	 * @param userName 用户名
	 * @param userPwd 用户密码
	 * @param userPhone 联系方式
	 * @return
	 */
	public int signIn(String userName,String userPwd,String userPhone); 
	
	/**
	 * 登录验证
	 * @param userNameOrPhone 用户名或电话号码
	 * @param userPwd 用户密码
	 * @return
	 */
	public int loginIn(String userNameOrPhone, String userPwd);
	
	/**
	 * 查看用户信息
	 * @param userId
	 * @return
	 */
	public UserInfo queryUserInfoById(long userId);
	
	/**
	 * 修改用户信息
	 * @param userName
	 * @param userPwd
	 * @param userPhone
	 * @param userId
	 * @return
	 */
	public int updateUserInfo(String userName, String userPwd, String userPhone, long userId);
	
	/**
	 * 根据查询条件分页查询用户信息表，按页返回
	 * @param userName
	 * @param userPhone
	 * @param currentPage
	 * @return
	 */
	public List<UserInfo> getUserInfoListByPage(String userName, String userPhone, int currentPage);
}
