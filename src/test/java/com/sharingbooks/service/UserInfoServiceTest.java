package com.sharingbooks.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class UserInfoServiceTest {
	
	@Autowired
	private UserInfoService userInfoSerivce;
	
	@Test
	public void testSignIn() {
		System.out.println(userInfoSerivce.signIn("Mark", "mark", "13471427567"));

	}
//测试结果
//  [main] DEBUG c.s.dao.UserInfoDao.addUser - <==    Updates: 1
//	1
	
	@Test
	public void testLoginIn() {
		System.out.println(userInfoSerivce.loginIn("cobaltg", "714342"));
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println(userInfoSerivce.loginIn("18716039352", "714342"));		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println(userInfoSerivce.loginIn("cobaltg", "714342ed"));
	}
//测试结果
//	1
//	++++++++++++++++++++++++++++++++
//	1
//	++++++++++++++++++++++++++++++++
//	0
	
	@Test
	public void testQueryUserInfoById() {
		UserInfo user=userInfoSerivce.queryUserInfoById(24);
		System.out.println(user);
	}
//测试结果
//	UserInfo [userId=24, userName=Mark, userPwd=mark, userPhone=13471427567]
	
	@Test
	public void testUpdateUserInfo() {
		System.out.println(userInfoSerivce.updateUserInfo("", "mar3k", "", 24));
		UserInfo user=userInfoSerivce.queryUserInfoById(24);
		System.out.println(user);
	}
//测试结果
//	UserInfo [userId=24, userName=Mark, userPwd=mar3k, userPhone=13471427567]
	
	@Test
	public void testGetUserInfoListByPage() {
		List<UserInfo> list=userInfoSerivce.getUserInfoListByPage("", "", 1);
		List<UserInfo> list1=userInfoSerivce.getUserInfoListByPage("", "", 2);
		for(UserInfo u: list){
			System.out.println(u);
		}
		System.out.println("++++++++++++++++++++++++");
		for(UserInfo u: list1){
			System.out.println(u);
		}
	}
//测试结果
//	+++++++++++++++++++++++
//	Page [totalNumber=19, currentPage=1, totalPage=2, pageNumber=10, dbIndex=0, dbNumber=10]
//	+++++++++++++++++++++++
//	+++++++++++++++++++++++
//	Page [totalNumber=19, currentPage=2, totalPage=2, pageNumber=10, dbIndex=10, dbNumber=10]
//	+++++++++++++++++++++++
}
