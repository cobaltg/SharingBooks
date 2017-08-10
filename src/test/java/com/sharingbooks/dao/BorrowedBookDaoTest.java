package com.sharingbooks.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.BorrowedBook;

/**
 * 配置spring和Junit整合，Junit启动时加载springIOC容器
 */
//Junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BorrowedBookDaoTest {
	
	//注入Dao实现类依赖
	@Autowired   
	private BorrowedBookDao borrowedBookDao;
	
	@Test
	public void testQueryBorrowedBookById() {
		BorrowedBook borrowbook=borrowedBookDao.queryBorrowedBookById(15);
		System.out.println(borrowbook);
	}
//测试结果
//	borrowerBook [bookId=15, bookName=《TCP/IP详细卷一》, bookDescription=斯蒂文斯，机械工业出版社, borrowerPhone=18777837798, releaseTime=Tue May 23 00:00:00 CST 2017]

	@Test
	public void testQueryBorrowedBookByBookInfo() {
		List<BorrowedBook> list=borrowedBookDao.queryBorrowedBookByBookInfo("Java", "");
		List<BorrowedBook> list2=borrowedBookDao.queryBorrowedBookByBookInfo("Java", "Eckel");
		for(BorrowedBook borrowedBook: list){
			System.out.println(borrowedBook);
		}
		System.out.println("-----------------------------------------");
		for(BorrowedBook borrowedBook: list2){
			System.out.println(borrowedBook);
		}
	}
//测试结果
//	borrowerBook [bookId=2, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=3, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, borrowerPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=4, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, borrowerPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=9, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, borrowerPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=10, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, borrowerPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	borrowerBook [bookId=2, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testCountBorrowedBook() {
		System.out.println(borrowedBookDao.countBorrowedBook("",""));
		System.out.println("-----------------------------------------");
		System.out.println(borrowedBookDao.countBorrowedBook("算法", ""));
		System.out.println("-----------------------------------------");
		System.out.println(borrowedBookDao.countBorrowedBook("算法", "电子"));	
	}
//测试结果
//	15
//	-----------------------------------------
//	1
//	-----------------------------------------
//	0
	
	@Test
	public void testtestCountqueryBorrowedBookListOfUser(){
		System.out.println(borrowedBookDao.countqueryBorrowedBookListOfUser("18716039352"));
	}
//测试结果
//	3
	
	@Test
	public void testQueryBorrowedBookListOfUserByPage(){
		List<BorrowedBook> list=borrowedBookDao.queryBorrowedBookListOfUserByPage("18716039352", 0, 2);
		List<BorrowedBook> list1=borrowedBookDao.queryBorrowedBookListOfUserByPage("18716039352", 2, 2);
		for(BorrowedBook b:list){
			System.out.println(b);
		}
		System.out.println("++++++++++++++++++++++++++++++");
		for(BorrowedBook b:list1){
			System.out.println(b);
		}
	}
//测试结果
//	borrowerBook [bookId=27, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=28, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]
//	++++++++++++++++++++++++++++++
//	borrowerBook [bookId=29, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testQueryBorrowedBookList() {
		List<BorrowedBook> list=borrowedBookDao.queryBorrowedBookList(0, 2);
		List<BorrowedBook> list1=borrowedBookDao.queryBorrowedBookList(2, 2);
		for(BorrowedBook borrowedBook: list){
			System.out.println(borrowedBook);
		}
		System.out.println("-----------------------------------------");
		for(BorrowedBook borrowedBook: list1){
			System.out.println(borrowedBook);
		}
	}
//测试结果
//	borrowerBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=2, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	borrowerBook [bookId=3, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, borrowerPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=4, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, borrowerPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]

	@Test
	public void testAddBorrowedBook() {
		BorrowedBook borrowedBook=new BorrowedBook();
		borrowedBook.setBookName("《追风筝的人》");
		borrowedBook.setBookDescription("朗赛尼，世界出版集团");
		borrowedBook.setBorrowerPhone("13487698574");
		borrowedBook.setReleaseTime(new Date());
		borrowedBookDao.addBorrowedBook(borrowedBook);
	}
//测试结果
//	17:18:47.307 [main] DEBUG c.s.d.B.addBorrowedBook - <==    Updates: 1
	
	@Test
	public void testReduceBorrowedBook() {
		System.out.println(borrowedBookDao.reduceBorrowedBook(11));
	}
//测试结果
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@158d255c]
//	1

	@Test
	public void testReduceSharedBookByBorrowed() {
		System.out.println(borrowedBookDao.reduceBorrowedBookByBorrowed("《编译原理》","", "13878759898"));
		System.out.println("-----------------------------------------");
		System.out.println(borrowedBookDao.reduceBorrowedBookByBorrowed("《编译原理》","","13878759873"));
	}
//测试结果
//	0
//	-----------------------------------------
//	1
	
	@Test
	public void testUpdateBorrowedBook() {
		System.out.println(borrowedBookDao.updateBorrowedBook("", "卡勒德·朗赛尼", 16));
	}
//测试结果
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@37d80fe7]
//	1
}