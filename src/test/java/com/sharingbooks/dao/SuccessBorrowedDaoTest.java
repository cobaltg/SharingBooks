package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SuccessBorrowed;

/**
 * 配置spring和Junit整合，Junit启动时加载springIOC容器
 */
//Junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessBorrowedDaoTest {
	
	@Autowired 
	private SuccessBorrowedDao successBorrowedDao;
	
	@Test
	public void testInsertSuccessBorrowed() {
		int count=successBorrowedDao.insertSuccessBorrowed(28, "书籍28", "书籍描述28", "书籍主人28", "借书人28", new Date());
		System.out.println(count);
	}
//测试结果
//	[main] DEBUG c.s.d.S.insertSuccessBorrowed - <==    Updates: 1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6548bb7d]
//	1

	
	@Test
	public void testCountSuccessBorrowedOfUser() {
		System.out.println(successBorrowedDao.countSuccessBorrowedOfUser("借书人15"));
	}
//测试结果
//	2
	
	@Test
	public void testQuerySuccessBorrowedListOfUserByPage() {
		List<SuccessBorrowed> list=successBorrowedDao.querySuccessBorrowedListOfUserByPage("借书人13", 0, 3);
		List<SuccessBorrowed> list2=successBorrowedDao.querySuccessBorrowedListOfUserByPage("借书人13", 3, 3);
		List<SuccessBorrowed> list3=successBorrowedDao.querySuccessBorrowedListOfUserByPage("借书人13", 6, 3);
		for(SuccessBorrowed s: list){
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++");
		for(SuccessBorrowed s: list2){
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++");
		for(SuccessBorrowed s: list3){
			System.out.println(s);
		}
	}
//测试结果
//	SuccessBorrowed [bookId=13, bookName=书名13, bookDescription=书籍描述13, bookMaster=书籍主人13, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=18, bookName=书名18, bookDescription=书籍描述18, bookMaster=书籍主人13, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=23, bookName=书名23, bookDescription=书籍描述23, bookMaster=书籍主人23, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]
//	++++++++++++++++++++++++++++
//	SuccessBorrowed [bookId=24, bookName=书名24, bookDescription=书籍描述24, bookMaster=书籍主人24, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=25, bookName=书名25, bookDescription=书籍描述25, bookMaster=书籍主人25, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=26, bookName=书名26, bookDescription=书籍描述26, bookMaster=书籍主人26, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]
//	++++++++++++++++++++++++++++
//	SuccessBorrowed [bookId=27, bookName=书名27, bookDescription=书籍描述27, bookMaster=书籍主人27, borrowerName=借书人13, createTime=Tue May 23 00:00:00 CST 2017]

	@Test
	public void testCountSuccessBorrowedList() {
		System.out.println(successBorrowedDao.countSuccessBorrowedList());
	}
//测试结果
//	22
	
	@Test
	public void testQuerySuccessBorrowedListByPage() {
		List<SuccessBorrowed> list=successBorrowedDao.querySuccessBorrowedListByPage(0,3);
		List<SuccessBorrowed> list2=successBorrowedDao.querySuccessBorrowedListByPage(3,3);
		for(SuccessBorrowed s: list){
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++");
		for(SuccessBorrowed s: list2){
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++");
	}
//测试结果
//	SuccessBorrowed [bookId=1, bookName=书名1, bookDescription=书籍描述1, bookMaster=书籍主人1, borrowerName=借书人1, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=2, bookName=书名2, bookDescription=书籍描述2, bookMaster=书籍主人2, borrowerName=借书人2, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=3, bookName=书名3, bookDescription=书籍描述3, bookMaster=书籍主人3, borrowerName=借书人3, createTime=Tue May 23 00:00:00 CST 2017]
//	++++++++++++++++++++++++++++
//	SuccessBorrowed [bookId=4, bookName=书名4, bookDescription=书籍描述4, bookMaster=书籍主人4, borrowerName=借书人4, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=5, bookName=书名5, bookDescription=书籍描述5, bookMaster=书籍主人5, borrowerName=借书人5, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessBorrowed [bookId=6, bookName=书名6, bookDescription=书籍描述6, bookMaster=书籍主人6, borrowerName=借书人6, createTime=Tue May 23 00:00:00 CST 2017]
}
