package com.sharingbooks.dao;

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
	
	//注入对象
	@Autowired
	private SuccessLendedDao successLendedDao;
	
	@Test
	public void testInsertSuccessLended() {
		System.out.println(successLendedDao.insertSuccessLended(28, "18716039352"));
//		System.out.println(successLendedDao.insertSuccessLended(27, "18716039352"));
//		System.out.println(successLendedDao.insertSuccessLended(29, "18176048764"));
	}
//测试结果
//	[main] DEBUG c.s.d.S.insertSuccessLended - ==> Parameters: 28(Long), 18716039352(String)
//	[main] DEBUG c.s.d.S.insertSuccessLended - <==    Updates: 1
//	1
	
	@Test
	public void testQueryByIdWithBorrowedBook() {
		SuccessLended successLended=successLendedDao.queryByIdWithBorrowedBook(28);
		System.out.println(successLended);
	}
//测试结果
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
	@Test
	public void querySuccessLendedListByMasterPhone() {
		List<SuccessLended> list=successLendedDao.querySuccessLendedListByMasterPhone("18716039352");
		List<SuccessLended> list1=successLendedDao.querySuccessLendedListByMasterPhone("18716039353");
		for(SuccessLended sb: list){
			System.out.println(sb);
		}
		System.out.println("-----------------------------------------");
		for(SuccessLended sb: list1){
			System.out.println(sb);
		}
	}
//测试结果
//	SuccessLended [bookId=27, masterPhone=18716039352, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=27, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
	
	@Test
	public void countSuccessBorrowedByMasterPhone() {
		System.out.println(successLendedDao.countSuccessBorrowedByMasterPhone("18716039352"));
	}
//测试结果
//	[main] DEBUG c.s.d.S.countSuccessBorrowedByMasterPhone - ==> Parameters: 18716039352(String)
//	[main] DEBUG c.s.d.S.countSuccessBorrowedByMasterPhone - <==      Total: 1
//	2
	
	@Test
	public void testQuerySuccessLended() {
		List<SuccessLended> list=successLendedDao.querySuccessLended();
		for(SuccessLended s: list){
			System.out.println(s);
		}
	}
//测试结果
//	SuccessLended [bookId=27, masterPhone=18716039352, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=27, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=29, masterPhone=18176048764, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=29, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
	@Test
	public void testCountSuccessLended() {
		System.out.println(successLendedDao.countSuccessLended());
	}
//测试结果
//	3
	@Test
	public void testQuerySuccessLendedList() {
		List<SuccessLended> list=successLendedDao.querySuccessLendedList(0, 2);
		List<SuccessLended> list1=successLendedDao.querySuccessLendedList(2, 2);
		for(SuccessLended sb: list){
			System.out.println(sb);
		}
		System.out.println("-----------------------------------------");
		for(SuccessLended sb: list1){
			System.out.println(sb);
		}
	}
//测试结果
//	SuccessLended [bookId=27, masterPhone=18716039352, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=27, bookName=《算法导论》, bookDescription=Stein，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=29, masterPhone=18176048764, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=29, bookName=《深入理解Java Web技术内幕》, bookDescription=许令波，电子工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=《Think in Java》, bookDescription=Eckel，机械工业出版社, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
}
