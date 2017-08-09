package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SharedBook;

/**
 * 配置spring和Junit整合，Junit启动时加载springIOC容器
 */
//Junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SharedBookDaoTest {
	
	//注入Dao实现类依赖
	@Autowired
	private SharedBookDao sharedBookDao;
	
	@Test
	public void testQuerySharedBookById() {
		SharedBook sharedBook = sharedBookDao.querySharedBookById(1);
		System.out.println(sharedBook);
	}
//测试结果
//	SharedBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=13476587398, releaseTime=2017-05-23]

	@Test
	public void testQueryShareBookByBookInfo() {
		List<SharedBook> list=sharedBookDao.queryShareBookByBookInfo("算法", "");
		List<SharedBook> list2=sharedBookDao.queryShareBookByBookInfo("算法", "机械");
		for(SharedBook sharedBook: list){
			System.out.println(sharedBook);
		}
		System.out.println("-----------------------------------------");
		for(SharedBook sharedBook: list2){
			System.out.println(sharedBook);
		}
	}
//测试结果
//	SharedBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=13476587398, releaseTime=2017-05-23]
//	SharedBook [bookId=7, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=2017-05-23]
//	SharedBook [bookId=8, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=2017-05-23]
//	SharedBook [bookId=13, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=2017-05-23]
//	SharedBook [bookId=14, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=2017-05-23]
//	-----------------------------------------
//	SharedBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=13476587398, releaseTime=2017-05-23]
	
	@Test
	public void testCountSharedBook() {
		System.out.println(sharedBookDao.countSharedBook("", ""));
		System.out.println("-----------------------------------------");
		System.out.println(sharedBookDao.countSharedBook("算法", ""));
		System.out.println("-----------------------------------------");
		System.out.println(sharedBookDao.countSharedBook("算法", "机械"));	
	}
//测试结果
//	21
//	-----------------------------------------
//	5
//	-----------------------------------------
//	1

	@Test
	public void testQuerySharedBookList() {
		List<SharedBook> list=sharedBookDao.querySharedBookList(0, 5);
		List<SharedBook> list1=sharedBookDao.querySharedBookList(5, 5);
		for(SharedBook sharedBook: list){
			System.out.println(sharedBook);
		}
		System.out.println("-----------------------------------------");
		for(SharedBook sharedBook: list1){
			System.out.println(sharedBook);
		}
	}
//测试结果
//	SharedBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=2, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, masterPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=3, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, masterPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=4, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, masterPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=5, bookName=《编译原理》, bookDescription=张素琴，清华大学出版社, masterPhone=13878759873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	SharedBook [bookId=6, bookName=《计算机操作系统》, bookDescription=汤小丹，西安电子科技大学出版社, masterPhone=18777837798, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=7, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=8, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=9, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, masterPhone=18715367865, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=10, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, masterPhone=13748475867, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testQuerySharedBookListByPage(){
		List<SharedBook> list=sharedBookDao.querySharedBookListByPage("算","",0, 5);
		List<SharedBook> list1=sharedBookDao.querySharedBookListByPage("","",5, 5);
		for(SharedBook sharedBook: list){
			System.out.println(sharedBook);
		}
		System.out.println("-----------------------------------------");
		for(SharedBook sharedBook: list1){
			System.out.println(sharedBook);
		}
	}
//测试结果
//	SharedBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=6, bookName=《计算机操作系统》, bookDescription=汤小丹，西安电子科技大学出版社, masterPhone=18777837798, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=7, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=8, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=12, bookName=《计算机操作系统》, bookDescription=汤小丹，西安电子科技大学出版社, masterPhone=18777837789, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	SharedBook [bookId=6, bookName=《计算机操作系统》, bookDescription=汤小丹，西安电子科技大学出版社, masterPhone=18777837798, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=7, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=8, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=9, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, masterPhone=18715367865, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=10, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, masterPhone=13748475867, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testAddSharedBook() {
		SharedBook sharedBook=new SharedBook();
		sharedBook.setBookName("《追风筝的人》");
		sharedBook.setBookDescription("朗赛尼，世界出版集团");
		sharedBook.setMasterPhone("13487698574");
		sharedBook.setReleaseTime(new Date());
		sharedBookDao.addSharedBook(sharedBook);
	}
//测试结果
//	[main] DEBUG c.s.dao.SharedBookDao.addSharedBook - <==    Updates: 1

	@Test
	public void testReduceSharedBook() {
		System.out.println(sharedBookDao.reduceSharedBook(23));
	}
//测试结果
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@67af833b]
//	1
	
	@Test
	public void testReduceSharedBookByShared() {
		System.out.println(sharedBookDao.reduceSharedBookByShared("《编译原理》", "13878759898"));
	}
//测试结果：
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@287f94b1]
//	2 （测试数据中有两条一样的数据）
	@Test
	public void testUpdateSharedBook() {
		System.out.println(sharedBookDao.updateSharedBook("", "卡勒德·朗赛尼", 24));
	}
//测试结果
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7646731d]
//	1

}