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
 * ����spring��Junit���ϣ�Junit����ʱ����springIOC����
 */
//Junit����ʱ����springIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BorrowedBookDaoTest {
	
	//ע��Daoʵ��������
	@Autowired
	private BorrowedBookDao borrowedBookDao;
	
	@Test
	public void testQueryBorrowedBookById() {
		BorrowedBook borrowbook=borrowedBookDao.queryBorrowedBookById(15);
		System.out.println(borrowbook);
	}
//���Խ��
//	borrowerBook [bookId=15, bookName=��TCP/IP��ϸ��һ��, bookDescription=˹����˹����е��ҵ������, borrowerPhone=18777837798, releaseTime=Tue May 23 00:00:00 CST 2017]

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
//���Խ��
//	borrowerBook [bookId=2, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=3, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, borrowerPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=4, bookName=��Java���ļ�����һ��, bookDescription=Horstmann����е��ҵ������, borrowerPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=9, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, borrowerPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=10, bookName=��Java���ļ�����һ��, bookDescription=Horstmann����е��ҵ������, borrowerPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	borrowerBook [bookId=2, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
	
	@Test
	public void testCountBorrowedBook() {
		System.out.println(borrowedBookDao.countBorrowedBook("",""));
		System.out.println("-----------------------------------------");
		System.out.println(borrowedBookDao.countBorrowedBook("�㷨", ""));
		System.out.println("-----------------------------------------");
		System.out.println(borrowedBookDao.countBorrowedBook("�㷨", "����"));	
	}
//���Խ��
//	15
//	-----------------------------------------
//	1
//	-----------------------------------------
//	0
	
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
//���Խ��
//	borrowerBook [bookId=1, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, borrowerPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=2, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, borrowerPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	borrowerBook [bookId=3, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, borrowerPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	borrowerBook [bookId=4, bookName=��Java���ļ�����һ��, bookDescription=Horstmann����е��ҵ������, borrowerPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]

	@Test
	public void testAddBorrowedBook() {
		BorrowedBook borrowedBook=new BorrowedBook();
		borrowedBook.setBookName("��׷���ݵ��ˡ�");
		borrowedBook.setBookDescription("�����ᣬ������漯��");
		borrowedBook.setBorrowerPhone("13487698574");
		borrowedBook.setReleaseTime(new Date());
		borrowedBookDao.addBorrowedBook(borrowedBook);
	}
//���Խ��
//	17:18:47.307 [main] DEBUG c.s.d.B.addBorrowedBook - <==    Updates: 1
	
	@Test
	public void testReduceBorrowedBook() {
		System.out.println(borrowedBookDao.reduceBorrowedBook(11));
	}
//���Խ��
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@158d255c]
//	1

	@Test
	public void testReduceSharedBookByBorrowed() {
		System.out.println(borrowedBookDao.reduceBorrowedBookByBorrowed("������ԭ��", "13878759898"));
		System.out.println("-----------------------------------------");
		System.out.println(borrowedBookDao.reduceBorrowedBookByBorrowed("������ԭ��", "13878759873"));
	}
//���Խ��
//	0
//	-----------------------------------------
//	1
	
	@Test
	public void testUpdateBorrowedBook() {
		System.out.println(borrowedBookDao.updateBorrowedBook("", "���յ¡�������", 16));
	}
//���Խ��
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@37d80fe7]
//	1
}
