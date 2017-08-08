package com.sharingbooks.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.entity.SuccessBorrowed;


/**
 * ����spring��Junit���ϣ�Junit����ʱ����springIOC����
 */
//Junit����ʱ����springIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�������ļ�
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
//���Խ����
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
//���Խ����
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=��������ԡ�, bookDescription=��ˬ���廪��ѧ������, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
//	SharedBook [bookId=19, bookName=��������ԡ�, bookDescription=��ˬ���廪��ѧ������, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]
	
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
//���Խ��
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=��������ԡ�, bookDescription=��ˬ���廪��ѧ������, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessBorrowed [listId=20, borrowerPhone=18716039352, createTime=Tue Aug 08 09:31:28 CST 2017, sharedBook=SharedBook [bookId=20, bookName=����ֵ������, bookDescription=������廪��ѧ������, masterPhone=18777837887, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
	
	@Test
	public void testCountSuccessBorrowedByBorrowerPhone() {
		System.out.println(successBorrowedDao.countSuccessBorrowedByBorrowerPhone("18716039352"));
	}
//���Խ��
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
//���Խ��
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=��������ԡ�, bookDescription=��ˬ���廪��ѧ������, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessBorrowed [listId=20, borrowerPhone=18716039352, createTime=Tue Aug 08 09:31:28 CST 2017, sharedBook=SharedBook [bookId=20, bookName=����ֵ������, bookDescription=������廪��ѧ������, masterPhone=18777837887, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessBorrowed [listId=25, borrowerPhone=18176048764, createTime=Tue Aug 08 09:32:45 CST 2017, sharedBook=SharedBook [bookId=25, bookName=��׷���ݵ��ˡ�, bookDescription=�����ᣬ������漯��, masterPhone=13487698574, releaseTime=Mon Aug 07 17:14:54 CST 2017]]
	
	@Test
	public void testCountSuccessBorrowed() {
		System.out.println(successBorrowedDao.countSuccessBorrowed());
	}
//���Խ��
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
//���Խ��
//	SuccessBorrowed [listId=25, borrowerPhone=18176048764, createTime=Tue Aug 08 09:32:45 CST 2017, sharedBook=SharedBook [bookId=25, bookName=��׷���ݵ��ˡ�, bookDescription=�����ᣬ������漯��, masterPhone=13487698574, releaseTime=Mon Aug 07 17:14:54 CST 2017]]
//	SuccessBorrowed [listId=20, borrowerPhone=18716039352, createTime=Tue Aug 08 09:31:28 CST 2017, sharedBook=SharedBook [bookId=20, bookName=����ֵ������, bookDescription=������廪��ѧ������, masterPhone=18777837887, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
//	SuccessBorrowed [listId=19, borrowerPhone=18716039352, createTime=Tue Aug 08 09:22:03 CST 2017, sharedBook=SharedBook [bookId=19, bookName=��������ԡ�, bookDescription=��ˬ���廪��ѧ������, masterPhone=18777837876, releaseTime=Tue May 23 00:00:00 CST 2017]]
}
