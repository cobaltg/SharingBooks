package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SuccessLended;
/**
 * 配置spring和Junit整合，Junit启动时加载springIOC容器
 */
//Junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessLendedDaoTest {
	
	@Autowired
	private SuccessLendedDao successLendedDao;
	
	@Test
	public void testInsertSuccessLended() {
//		int count=successLendedDao.insertSuccessLended(22, "书籍名字22", "书籍描述22", "书籍主人", "借书人", new Date());
		int count=successLendedDao.insertSuccessLended(27, "书名27", "书籍描述27", "书籍主人", "借书人27", new Date());
		System.out.println(count);
	}
//测试结果
//	[main] DEBUG c.s.d.S.insertSuccessLended - <==    Updates: 1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@79c4715d]
//	1
	
	@Test
	public void testCountSuccessLendedOfUser() {
		System.out.println(successLendedDao.countSuccessLendedOfUser("书籍主人18"));
	}
//测试结果
//	5
	
	@Test
	public void testQuerySuccessLendedListOfUserByPage() {
		List<SuccessLended> list=successLendedDao.querySuccessLendedListOfUserByPage("书籍主人18", 0, 3);
		List<SuccessLended> list2=successLendedDao.querySuccessLendedListOfUserByPage("书籍主人18", 3, 3);
		for(SuccessLended s: list){
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++");
		for(SuccessLended s: list2){
			System.out.println(s);
		}
	}
//测试结果
//	SuccessLended [bookId=18, bookName=书名18, bookDescription=书籍描述18, bookMaster=书籍主人18, ReceiverName=借书人14, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessLended [bookId=23, bookName=书名23, bookDescription=书籍描述23, bookMaster=书籍主人18, ReceiverName=借书人, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessLended [bookId=24, bookName=书名24, bookDescription=书籍描述24, bookMaster=书籍主人18, ReceiverName=借书人, createTime=Tue May 23 00:00:00 CST 2017]
//	++++++++++++++++++++++++++++
//	SuccessLended [bookId=25, bookName=书名25, bookDescription=书籍描述25, bookMaster=书籍主人18, ReceiverName=借书人, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessLended [bookId=26, bookName=书名26, bookDescription=书籍描述26, bookMaster=书籍主人18, ReceiverName=借书人14, createTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testCountSuccessLendedList() {
		System.out.println(successLendedDao.countSuccessLendedList());
	}
//测试结果
//	26
	
	@Test
	public void testQuerySuccessLendedListByPage() {
		List<SuccessLended> list=successLendedDao.querySuccessLendedListByPage(0,3);
		List<SuccessLended> list2=successLendedDao.querySuccessLendedListByPage(3,3);
		for(SuccessLended s: list){
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++");
		for(SuccessLended s: list2){
			System.out.println(s);
		}
	}
//测试结果
//	（按时间倒序输出）
//	SuccessLended [bookId=27, bookName=书名27, bookDescription=书籍描述27, bookMaster=书籍主人, ReceiverName=借书人27, createTime=Thu Aug 10 21:00:04 CST 2017]
//	SuccessLended [bookId=22, bookName=书籍名字22, bookDescription=书籍描述22, bookMaster=书籍主人, ReceiverName=借书人, createTime=Thu Aug 10 20:46:32 CST 2017]
//	SuccessLended [bookId=1, bookName=书名1, bookDescription=书籍描述1, bookMaster=书籍主人1, ReceiverName=借书人1, createTime=Tue May 23 00:00:00 CST 2017]
//	++++++++++++++++++++++++++++
//	SuccessLended [bookId=2, bookName=书名2, bookDescription=书籍描述2, bookMaster=书籍主人2, ReceiverName=借书人2, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessLended [bookId=3, bookName=书名3, bookDescription=书籍描述3, bookMaster=书籍主人3, ReceiverName=借书人3, createTime=Tue May 23 00:00:00 CST 2017]
//	SuccessLended [bookId=4, bookName=书名4, bookDescription=书籍描述4, bookMaster=书籍主人4, ReceiverName=借书人4, createTime=Tue May 23 00:00:00 CST 2017]

}
