package com.sharingbooks.dao;

import com.sharingbooks.entity.UserInfo;

public interface UserInfoDao {
	/**
	 * 根据用户名、密码查询用户，用于登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 查询到的唯一用户实体
	 */
	public UserInfo getUser(String name, String pwd);
	
	/**
	 * 根据用户id查询用户信息
	 * @param userId 用户id
	 * @return 查询到的唯一用户实体
	 */
	public UserInfo queryById(long userId);
	
}
