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

import com.sharingbooks.dto.BorrowedExecution;
import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.exception.RepeatBorrowedException;
import com.sharingbooks.exception.SharedBookIsNotExitException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class SharedBookServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SharedBookService sharedBookService;
	
	@Test
	public void testGetById() {
		SharedBook sharedBook = sharedBookService.getById(10);
		logger.info("sharedBook{}", sharedBook);
	}
//测试结果
//	[main] INFO  c.s.service.SharedBookServiceTest - sharedBooSharedBook [bookId=10, bookName=《Java核心技术卷一》, bookDescription=Horstmann，机械工业出版社, masterPhone=13748475867, releaseTime=Tue May 23 00:00:00 CST 2017]

	@Test
	public void testGetSharedBookListByPage() {
		List<SharedBook> list = sharedBookService.getSharedBookListByPage("算法",
				"", 1);
		logger.info("list={}",list);
	}
//测试结果
//	[main] INFO  c.s.service.SharedBookServiceTest - list=
//	[SharedBook [bookId=1, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017],
//	 SharedBook [bookId=7, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=Tue May 23 00:00:00 CST 2017],
//	 SharedBook [bookId=8, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=Tue May 23 00:00:00 CST 2017],
//	 SharedBook [bookId=13, bookName=《算法竞赛入门经典》, bookDescription=刘汝佳，清华大学出版社, masterPhone=13476587387, releaseTime=Tue May 23 00:00:00 CST 2017], 
//	 SharedBook [bookId=14, bookName=《计算机算法设计与分析》, bookDescription=王晓东，电子工业出版社, masterPhone=18716576498, releaseTime=Tue May 23 00:00:00 CST 2017],
//	 SharedBook [bookId=27, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, masterPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	@Test
	public void testExecuteBorrowed() {
		try{
		//	BorrowedExecution borrowedExecution=sharedBookService.executeBorrowed(20, "18716039352");
			BorrowedExecution borrowedExecution=sharedBookService.executeBorrowed(258, "18716039352");
			logger.info("result={}",borrowedExecution);
		}catch(SharedBookIsNotExitException e){
			logger.error(e.getMessage());
		}catch(RepeatBorrowedException e){
			logger.error(e.getMessage());
		}
	}
//测试结果
//	[main] INFO  c.s.service.SharedBookServiceTest - result=BorrowedExecution [bookId=20, state=1, stateinfo=借阅成功, createTime=Fri Aug 11 00:34:47 CST 2017]
//	[main] ERROR c.s.service.SharedBookServiceTest - SharedBook is not avaliable!
		
	@Test
	public void testgetSharedBookListOfUserByPage(){
		List<SharedBook> list=sharedBookService.getSharedBookListOfUserByPage(1, "18176039352");
		List<SharedBook> list1=sharedBookService.getSharedBookListOfUserByPage(2, "18176039352");
		for(SharedBook s:list){
			System.out.println(s);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		for(SharedBook s:list1){
			System.out.println(s);
		}
	}
//测试结果
//	+++++++++++++++++++++++++++++++++++++++
//	Page [totalNumber=11, currentPage=1, totalPage=2, pageNumber=10, dbIndex=0, dbNumber=10]
//	+++++++++++++++++++++++++++++++++++++++
//	
//	+++++++++++++++++++++++++++++++++++++++
//	Page [totalNumber=11, currentPage=2, totalPage=2, pageNumber=10, dbIndex=10, dbNumber=10]
//	+++++++++++++++++++++++++++++++++++++++
	
	@Test
	public void testAddOneSharedBook(){
		System.out.println(sharedBookService.addOneSharedBook("软件工程导论", "张海藩，清华大学出版社", "18716039352", new Date()));
	}
//测试结果
//	[main] DEBUG c.s.dao.SharedBookDao.addSharedBook - <==    Updates: 1
//	1
	
	@Test
	public void testReduceOneSharedbook(){
		System.out.println(sharedBookService.reduceOneSharedBook(57));
	}
//测试结果
//	[main] DEBUG c.s.d.SharedBookDao.reduceSharedBook - <==    Updates: 1
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@238ad8c]
//	1 
	
	@Test
	public void testUpdateSharedBook(){
		System.out.println(sharedBookService.updateSharedBook("", "张海藩，机械工业出版社", 58));
	}
//测试结果
//	[main] DEBUG c.s.d.SharedBookDao.updateSharedBook - ==>  Preparing: update sharedbook SET book_description = ? where book_id=? 
//	[main] DEBUG c.s.d.SharedBookDao.updateSharedBook - ==> Parameters: 张海藩，机械工业出版社(String), 58(Long)
//	[main] DEBUG c.s.d.SharedBookDao.updateSharedBook - <==    Updates: 1
	
}
