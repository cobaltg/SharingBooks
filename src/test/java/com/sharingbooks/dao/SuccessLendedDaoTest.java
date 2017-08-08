package com.sharingbooks.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SuccessLended;
/**
 * ����spring��Junit���ϣ�Junit����ʱ����springIOC����
 */
//Junit����ʱ����springIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessLendedDaoTest {
	
	//ע�����
	@Autowired
	private SuccessLendedDao successLendedDao;
	
	@Test
	public void testInsertSuccessLended() {
		System.out.println(successLendedDao.insertSuccessLended(28, "18716039352"));
//		System.out.println(successLendedDao.insertSuccessLended(27, "18716039352"));
//		System.out.println(successLendedDao.insertSuccessLended(29, "18176048764"));
	}
//���Խ��
//	[main] DEBUG c.s.d.S.insertSuccessLended - ==> Parameters: 28(Long), 18716039352(String)
//	[main] DEBUG c.s.d.S.insertSuccessLended - <==    Updates: 1
//	1
	
	@Test
	public void testQueryByIdWithBorrowedBook() {
		SuccessLended successLended=successLendedDao.queryByIdWithBorrowedBook(28);
		System.out.println(successLended);
	}
//���Խ��
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
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
//���Խ��
//	SuccessLended [bookId=27, masterPhone=18716039352, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=27, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
	
	@Test
	public void countSuccessBorrowedByMasterPhone() {
		System.out.println(successLendedDao.countSuccessBorrowedByMasterPhone("18716039352"));
	}
//���Խ��
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
//���Խ��
//	SuccessLended [bookId=27, masterPhone=18716039352, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=27, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=29, masterPhone=18176048764, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=29, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
	@Test
	public void testCountSuccessLended() {
		System.out.println(successLendedDao.countSuccessLended());
	}
//���Խ��
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
//���Խ��
//	SuccessLended [bookId=27, masterPhone=18716039352, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=27, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	SuccessLended [bookId=29, masterPhone=18176048764, createTime=Tue Aug 08 10:40:52 CST 2017, borrowedBook=borrowerBook [bookId=29, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
//	-----------------------------------------
//	SuccessLended [bookId=28, masterPhone=18716039352, createTime=Tue Aug 08 10:39:44 CST 2017, borrowedBook=borrowerBook [bookId=28, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716039352, releaseTime=Tue May 23 00:00:00 CST 2017]]
	
}
