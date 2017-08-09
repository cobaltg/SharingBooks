package com.sharingbooks.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SharedBook;
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
		System.out.println(successBorrowedDao.insertSuccessBorrowed(19, "18716039352"));
		//System.out.println(successBorrowedDao.insertSuccessBorrowed(20, "18716039352"));
		//System.out.println(successBorrowedDao.insertSuccessBorrowed(25, "18176048764"));
	}
//测试结果：
//	[main] DEBUG c.s.d.S.insertSuccessBorrowed - ==>  Preparing: insert into success_borrowed (book_id,borrower_phone) values (?,?) 
//	[main] DEBUG c.s.d.S.insertSuccessBorrowed - ==> Parameters: 19(Long), 18716039352(String)
//	[main] DEBUG c.s.d.S.insertSuccessBorrowed - <==    Updates: 1
	
	@Test
	public void testQueryByIdWithSharedBook() {
		SuccessBorrowed successBorrowed=successBorrowedDao.queryByIdWithSharedBook(19);
		System.out.println(successBorrowed);
		SharedBook sbook=successBorrowed.getSharedBook();
		System.out.println("-----------------------------------------");
		System.out.println(sbook);
	}
//测试结果：
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=《汇编语言》, bookDescription=王爽，清华大学出版社, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
//	SharedBook [bookId=19, bookName=《汇编语言》, bookDescription=王爽，清华大学出版社, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testQuerySuccessBorrowedListByBorrowerPhone() {
		List<SuccessBorrowed> list=successBorrowedDao.querySuccessBorrowedListByBorrowerPhone("18716039352");
		List<SuccessBorrowed> list1=successBorrowedDao.querySuccessBorrowedListByBorrowerPhone("18716039353");
		for(SuccessBorrowed sb: list){
			System.out.println(sb);
		}
		System.out.println("-----------------------------------------");
		for(SuccessBorrowed sb: list1){
			System.out.println(sb);
		}
	}
//测试结果
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=《汇编语言》, bookDescription=王爽，清华大学出版社, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessBorrowed [listId=20, borrowerPhone=18716039352, createTime=Tue Aug 08 09:31:28 CST 2017, sharedBook=SharedBook [bookId=20, bookName=《数值分析》, bookDescription=李庆杨，清华大学出版社, masterPhone=18777837887, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
	
	@Test
	public void testCountSuccessBorrowedByBorrowerPhone() {
		System.out.println(successBorrowedDao.countSuccessBorrowedByBorrowerPhone("18716039352"));
	}
//测试结果
//	[main] DEBUG c.s.d.S.countSuccessBorrowedByBorrowerPhone - ==>  Preparing: select count(*) from success_borrowed where borrower_phone=? 
//	[main] DEBUG c.s.d.S.countSuccessBorrowedByBorrowerPhone - ==> Parameters: 18716039352(String)
//	2
	
	@Test
	public void testQuerySuccessBorrowed() {
		List<SuccessBorrowed> list=successBorrowedDao.querySuccessBorrowed();
		for(SuccessBorrowed s: list){
			System.out.println(s);
		}
	}
//测试结果
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=《汇编语言》, bookDescription=王爽，清华大学出版社, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessBorrowed [listId=20, borrowerPhone=18716039352, createTime=Tue Aug 08 09:31:28 CST 2017, sharedBook=SharedBook [bookId=20, bookName=《数值分析》, bookDescription=李庆杨，清华大学出版社, masterPhone=18777837887, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessBorrowed [listId=25, borrowerPhone=18176048764, createTime=Tue Aug 08 09:32:45 CST 2017, sharedBook=SharedBook [bookId=25, bookName=《追风筝的人》, bookDescription=朗赛尼，世界出版集团, masterPhone=13487698574, releaseTime=Mon Aug 07 17:14:54 CST 2017]]
	
	@Test
	public void testCountSuccessBorrowed() {
		System.out.println(successBorrowedDao.countSuccessBorrowed());
	}
//测试结果
//	3
	
	@Test
	public void testQuerySuccessBorrowedList() {
		List<SuccessBorrowed> list=successBorrowedDao.querySuccessBorrowedList(0, 2);
		List<SuccessBorrowed> list1=successBorrowedDao.querySuccessBorrowedList(2, 2);
		for(SuccessBorrowed sb: list){
			System.out.println(sb);
		}
		System.out.println("-----------------------------------------");
		for(SuccessBorrowed sb: list1){
			System.out.println(sb);
		}
	}
//测试结果
//	SuccessBorrowed [listId=25, borrowerPhone=18176048764, createTime=Tue Aug 08 09:32:45 CST 2017, sharedBook=SharedBook [bookId=25, bookName=《追风筝的人》, bookDescription=朗赛尼，世界出版集团, masterPhone=13487698574, releaseTime=Mon Aug 07 17:14:54 CST 2017]]
//	SuccessBorrowed [listId=20, borrowerPhone=18716039352, createTime=Tue Aug 08 09:31:28 CST 2017, sharedBook=SharedBook [bookId=20, bookName=《数值分析》, bookDescription=李庆杨，清华大学出版社, masterPhone=18777837887, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=《汇编语言》, bookDescription=王爽，清华大学出版社, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
}