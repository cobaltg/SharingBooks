package com.sharingbooks.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.dto.BorrowedBookExecution;
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
		logger.info("sharedBoo{}", sharedBook);
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
	public void testExecuteBorrowedBook() {
		try{
			//BorrowedBookExecution borrowedBookExecution=sharedBookService.executeBorrowedBook(25, "18716039352");
			BorrowedBookExecution borrowedBookExecution=sharedBookService.executeBorrowedBook(258, "18716039352");
			logger.info("result={}",borrowedBookExecution);
		}catch(SharedBookIsNotExitException e){
			logger.error(e.getMessage());
		}catch(RepeatBorrowedException e){
			logger.error(e.getMessage());
		}
	}
//测试结果
//	[main] INFO  c.s.service.SharedBookServiceTest - result=com.sharingbooks.dto.BorrowedBookExecution@35e478f
//	[main] ERROR c.s.service.SharedBookServiceTest - SharedBook is not avaliable!
}
