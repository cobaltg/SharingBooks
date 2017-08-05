package com.sharingbooks.dao;

import java.util.List;
import java.util.Map;

import com.sharingbooks.entity.UserInfo;

public interface UserInfoDao {
	/**
	 * 注册一个用户
	 * @param userinfo
	 * @return
	 */
	public int addUser(UserInfo userinfo);
	
	/**
	 * 删除一个用户
	 * @param userinfo
	 * @return
	 */
	public int reduceUser(UserInfo userinfo);
	
	/**
	 * 修改用户信息
	 * @param userinfo
	 * @return
	 */
	public int updateUser(UserInfo userinfo);
	
	/**
	 * 根据用户名、密码查询用户，用于登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 查询到的唯一用户实体
	 */
	public int getUser(UserInfo userinfo);
	
	/**
	 * 根据查询条件查询用户信息表
	 */
	public List<UserInfo> queryUserInfoList(Map<String,Object> parameter);
}
