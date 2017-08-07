package com.sharingbooks.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.UserInfo;

/**
 * ����spring��Junit���ϣ�Junit����ʱ����springIOC����
 * 
 */
//Junit����ʱ����springIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserInfoDaoTest {
	
	//ע��Daoʵ��������
	@Autowired
	private UserInfoDao userInfoDao;

	
	@Test
	public void testQueryById(){
		long id=6;
		UserInfo userinfo=userInfoDao.queryById(id);
		System.out.println(userinfo);		
	}
//���Խ����	
//	UserInfo [userId=6, userName=Vivian, userPwd=vivian, userPhone=18179868764]
	
	@Test
	public void testAddUser() {
		int result=userInfoDao.addUser("Monical","monical","18715647645");
		System.out.println(result);
	}
//���Խ����
//	[main] DEBUG c.s.dao.UserInfoDao.addUser - ==>  Preparing: insert into userinfo (user_name,user_pwd,user_phone) values (?,?,?) 
//	[main] DEBUG c.s.dao.UserInfoDao.addUser - ==> Parameters: Monical(String), monical(String), 18715647645(String)
//	[main] DEBUG c.s.dao.UserInfoDao.addUser - <==    Updates: 1
//  1	
	
	@Test
	public void testUpdateUser() {
		int i=userInfoDao.updateUser("", "monical", "",8);
		System.out.println(i);
	}
//���Խ��
//	[main] DEBUG c.s.dao.UserInfoDao.updateUser - ==>  Preparing: update userinfo set user_name=?, user_pwd=?, user_phone=? where user_id=? 
//	[main] DEBUG c.s.dao.UserInfoDao.updateUser - ==> Parameters: Monical(String), Monical(String), 18715647645(String), 8(Long)
//	[main] DEBUG c.s.dao.UserInfoDao.updateUser - <==    Updates: 1
//  1

	@Test
	public void testReduceUser() {
		int i=userInfoDao.reduceUser(7);
		System.out.println(i);
	}
//���Խ����
//	[main] DEBUG c.s.dao.UserInfoDao.reduceUser - ==>  Preparing: delete from userinfo where user_id=? 
//	[main] DEBUG c.s.dao.UserInfoDao.reduceUser - ==> Parameters: 7(Long)
//	[main] DEBUG c.s.dao.UserInfoDao.reduceUser - <==    Updates: 1
//	1

	@Test
	public void testGetUser() {		
		System.out.println(userInfoDao.getUser("Vivian", "vivian", ""));
		System.out.println(userInfoDao.getUser("", "vivian", "18179868764"));
		System.out.println(userInfoDao.getUser("Vivian", "vvian", "18179868764"));
	}
//���Խ��
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2e8ab815]
//	1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7bdf6bb7]
//	1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@4d0402b]
//	0
	
	@Test
	public void testGetUserById(){
		UserInfo userinfo=userInfoDao.getUserById(6);
		System.out.println(userinfo);
	}
//���Խ��
//	UserInfo [userId=6, userName=Vivian, userPwd=vivian, userPhone=18179868764]
	
	@Test
	public void testGetUserByName(){
		UserInfo userinfo=userInfoDao.getUserByName("Vivian");
		System.out.println(userinfo);
	}
//���Խ��
//	UserInfo [userId=6, userName=Vivian, userPwd=vivian, userPhone=18179868764]	
	
	@Test
	public void testGetUserByPhone(){
		UserInfo userinfo=userInfoDao.getUserByPhone("18179868764");
		System.out.println(userinfo);
	}
//���Խ��
//	UserInfo [userId=6, userName=Vivian, userPwd=vivian, userPhone=18179868764]		
	
	@Test 
	public void testCountUserInfo(){
		System.out.println(userInfoDao.countUserInfo());
	}
//���Խ��
//	3
	@Test
	public void testQueryUserInfoList() {
		List<UserInfo> list=userInfoDao.queryUserInfoList(0, 100);
		for(UserInfo userinfo:list){
			System.out.println(userinfo);
		}
	}
//���Խ��
//	UserInfo [userId=5, userName=Joey, userPwd=joey, userPhone=18176048764]
//	UserInfo [userId=6, userName=Vivian, userPwd=vivian, userPhone=18179868764]
//	UserInfo [userId=8, userName=Monical, userPwd=Monical, userPhone=18715647645]
}
