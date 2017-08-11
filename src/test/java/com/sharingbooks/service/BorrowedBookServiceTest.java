package com.sharingbooks.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.dto.SharedExecution;
import com.sharingbooks.entity.BorrowedBook;
import com.sharingbooks.exception.BorrowedBookIsNotExitException;
import com.sharingbooks.exception.RepeatSharedException;
import com.sharingbooks.exception.SharedException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class BorrowedBookServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BorrowedBookService borrowedBookService;
	
	@Test
	public void testGetById() {
		BorrowedBook borrowedBook=borrowedBookService.getById(28);
		logger.info("sharedBook{}", borrowedBook);
	}
//測試結果
//	[main] INFO  c.s.service.BorrowedBookServiceTest - sharedBookborrowerBook [bookId=28, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testGetBorrowedBookByBookInfo() {
		List<BorrowedBook> list = borrowedBookService.getBorrowedBookByBookInfo("算法导论", "");
		logger.info("list={}",list);
	}
//测试结果
//	[main] DEBUG c.s.d.B.queryBorrowedBookByBookInfo - <==      Total: 3
//	[main] INFO  c.s.service.BorrowedBookServiceTest - list=[borrowerBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017], borrowerBook
//	                                                         [bookId=17, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017], borrowerBook
//	                                                         [bookId=27, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
	
	@Test
	public void testCountBorrowedBookByBookInfo() {
		System.out.println(borrowedBookService.countBorrowedBookByBookInfo("算法", ""));
	}
//测试结果
//	3
	
	@Test
	public void testGetBorrowedBookListByPage() {
		List<BorrowedBook> list = borrowedBookService.getBorrowedBookListByPage("书名", "",1);
		logger.info("list={}",list);
		System.out.println("+++++++++++++++++++++++");
		List<BorrowedBook> list1 = borrowedBookService.getBorrowedBookListByPage("书名", "",2);
		logger.info("list={}",list1);
	}
//测试结果
//	+++++++++++++++++++++++
//	Page [totalNumber=11, currentPage=1, totalPage=2, pageNumber=10, dbIndex=0, dbNumber=10]
//	+++++++++++++++++++++++
//	+++++++++++++++++++++++
//	Page [totalNumber=11, currentPage=2, totalPage=2, pageNumber=10, dbIndex=10, dbNumber=10]
//	+++++++++++++++++++++++
	
	@Test
	public void testExecuteShared() {
		try{
		//	SharedExecution sharedExecution=borrowedBookService.executeShared(20, "18716039352");
			SharedExecution sharedExecution=borrowedBookService.executeShared(27, "13476587398");
			logger.info("result={}",sharedExecution);
		}catch(BorrowedBookIsNotExitException e){
			logger.error(e.getMessage());
		}catch(RepeatSharedException e){
			logger.error(e.getMessage());
		}catch(SharedException e){
			logger.error(e.getMessage());
		}
	}

	@Test
	public void testCountBorrowedBookOfUserByBookInfo() {
		System.out.println(borrowedBookService.countBorrowedBookOfUserByBookInfo("18176039352"));
	}
//测试结果
//	11
	
	@Test
	public void testGetBorrowedBookListOfUserByPage() {
		List<BorrowedBook> list=borrowedBookService.getBorrowedBookListOfUserByPage(1, "18176039352");
		List<BorrowedBook> list1=borrowedBookService.getBorrowedBookListOfUserByPage(2, "18176039352");
		for(BorrowedBook s:list){
			System.out.println(s);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		for(BorrowedBook s:list1){
			System.out.println(s);
		}
	}
	//测试结果
//	+++++++++++++++++++++++
//	Page [totalNumber=11, currentPage=1, totalPage=2, pageNumber=10, dbIndex=0, dbNumber=10]
//	+++++++++++++++++++++++
//	+++++++++++++++++++++++
//	Page [totalNumber=11, currentPage=2, totalPage=2, pageNumber=10, dbIndex=10, dbNumber=10]
//	+++++++++++++++++++++++

	@Test
	public void testAddOneBorrowedBook() {
		System.out.println(borrowedBookService.addOneBorrowedBook("软件工程导论", "张海藩，清华大学出版社", "18716039352", new Date()));
	}
//测试结果
//	[main] DEBUG c.s.d.B.addBorrowedBook - <==    Updates: 1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@78b236a0]
//	1
	
	@Test
	public void testReduceOneBorrowedBook() {
		System.out.println(borrowedBookService.reduceOneBorrowedBook(42));
	}
//测试结果
//	[main] DEBUG c.s.d.B.reduceBorrowedBook - <==    Updates: 1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1532c619]
//	1
	
	@Test
	public void testUpdateBorrowedBook() {
		System.out.println(borrowedBookService.updateBorrowedBook("《书籍》", "张海藩，机械工业出版社", 41));
	}
//测试结果
//	[main] DEBUG c.s.d.B.updateBorrowedBook - <==    Updates: 1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@42d236fb]
//	1
	
}
