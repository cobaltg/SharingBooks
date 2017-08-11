package com.sharingbooks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharingbooks.entity.UserInfo;

public interface UserInfoDao {
	/**
	 * 根据Id号查询用户
	 * @param userId
	 * @return
	 */
	public UserInfo queryById(long userId);
	

	/**
	 * 注册一个用户
	 * @param 
	 * @return
	 */

	public int addUser(@Param(value = "userName") String userName,@Param(value = "userPwd") String userPwd,@Param(value = "userPhone")String userPhone);
	
	/**
	 * 删除一个用户
	 * @param 根据id
	 * @return 更新行数
	 */
	public int reduceUser(long userId);
	
	/**
	 * 修改用户信息
	 * @param 
	 * @return 更改行数
	 */
	public int updateUser(@Param(value = "userName") String userName,@Param(value = "userPwd") String userPwd,@Param(value = "userPhone")String userPhone,@Param(value = "userId") long userId);
	
	/**
	 * 根据用户名/电话号码、密码查询用户，用于登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 查询到的唯一用户实体
	 */
	public int getUser(@Param(value = "userName") String userName,@Param(value = "userPwd") String userPwd,@Param(value = "userPhone")String userPhone);
	
	/**
	 * 根据id查询用户信息
	 * @param userId
	 * @return
	 */
	public UserInfo getUserById(long userId);
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo getUserByName(String userName);
	
	/**
	 * 根据用户联系方式查询用户信息
	 * @param userPhone
	 * @return
	 */
	public UserInfo getUserByPhone(String userPhone);
	
	/**
	 * 根据查询条件查询符合的用户信息的条数
	 * @param userName
	 * @param userPhone
	 * @return
	 */
	public int countqueryUserInfoList(@Param(value = "userName") String userName, @Param(value = "userPhone") String userPhone);
	
	/**
	 * 根据偏移量查询条件查询用户信息列表
	 * @param userName
	 * @param userPhone
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<UserInfo> queryUserInfoListByPage(@Param(value = "userName") String userName, @Param(value = "userPhone") String userPhone, @Param(value = "offset") int offset, @Param(value = "limit") int limit);
}
