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
 * ����spring��Junit���ϣ�Junit����ʱ����springIOC����
 */
//Junit����ʱ����springIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SharedBookDaoTest {
	
	//ע��Daoʵ��������
	@Autowired
	private SharedBookDao sharedBookDao;
	
	@Test
	public void testQuerySharedBookById() {
		SharedBook sharedBook = sharedBookDao.querySharedBookById(1);
		System.out.println(sharedBook);
	}
//���Խ��
//	SharedBook [bookId=1, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, masterPhone=13476587398, releaseTime=2017-05-23]

	@Test
	public void testQueryShareBookByBookInfo() {
		List<SharedBook> list=sharedBookDao.queryShareBookByBookInfo("�㷨", "");
		List<SharedBook> list2=sharedBookDao.queryShareBookByBookInfo("�㷨", "��е");
		for(SharedBook sharedBook: list){
			System.out.println(sharedBook);
		}
		System.out.println("-----------------------------------------");
		for(SharedBook sharedBook: list2){
			System.out.println(sharedBook);
		}
	}
//���Խ��
//	SharedBook [bookId=1, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, masterPhone=13476587398, releaseTime=2017-05-23]
//	SharedBook [bookId=7, bookName=���㷨�������ž��䡷, bookDescription=����ѣ��廪��ѧ������, masterPhone=13476587387, releaseTime=2017-05-23]
//	SharedBook [bookId=8, bookName=��������㷨����������, bookDescription=�����������ӹ�ҵ������, masterPhone=18716576498, releaseTime=2017-05-23]
//	SharedBook [bookId=13, bookName=���㷨�������ž��䡷, bookDescription=����ѣ��廪��ѧ������, masterPhone=13476587387, releaseTime=2017-05-23]
//	SharedBook [bookId=14, bookName=��������㷨����������, bookDescription=�����������ӹ�ҵ������, masterPhone=18716576498, releaseTime=2017-05-23]
//	-----------------------------------------
//	SharedBook [bookId=1, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, masterPhone=13476587398, releaseTime=2017-05-23]
	
	@Test
	public void testCountSharedBook() {
		System.out.println(sharedBookDao.countSharedBook("", ""));
		System.out.println("-----------------------------------------");
		System.out.println(sharedBookDao.countSharedBook("�㷨", ""));
		System.out.println("-----------------------------------------");
		System.out.println(sharedBookDao.countSharedBook("�㷨", "��е"));	
	}
//���Խ��
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
//���Խ��
//	SharedBook [bookId=1, bookName=���㷨���ۡ�, bookDescription=Stein����е��ҵ������, masterPhone=13476587398, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=2, bookName=��Think in Java��, bookDescription=Eckel����е��ҵ������, masterPhone=18716576483, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=3, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, masterPhone=18775367896, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=4, bookName=��Java���ļ�����һ��, bookDescription=Horstmann����е��ҵ������, masterPhone=13748475873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=5, bookName=������ԭ��, bookDescription=�����٣��廪��ѧ������, masterPhone=13878759873, releaseTime=Tue May 23 00:00:00 CST 2017]
//	-----------------------------------------
//	SharedBook [bookId=6, bookName=�����������ϵͳ��, bookDescription=��С�����������ӿƼ���ѧ������, masterPhone=18777837798, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=7, bookName=���㷨�������ž��䡷, bookDescription=����ѣ��廪��ѧ������, masterPhone=13476587387, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=8, bookName=��������㷨����������, bookDescription=�����������ӹ�ҵ������, masterPhone=18716576498, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=9, bookName=���������Java Web������Ļ��, bookDescription=��������ӹ�ҵ������, masterPhone=18715367865, releaseTime=Tue May 23 00:00:00 CST 2017]
//	SharedBook [bookId=10, bookName=��Java���ļ�����һ��, bookDescription=Horstmann����е��ҵ������, masterPhone=13748475867, releaseTime=Tue May 23 00:00:00 CST 2017]
			
	@Test
	public void testAddSharedBook() {
		SharedBook sharedBook=new SharedBook();
		sharedBook.setBookName("��׷���ݵ��ˡ�");
		sharedBook.setBookDescription("�����ᣬ������漯��");
		sharedBook.setMasterPhone("13487698574");
		sharedBook.setReleaseTime(new Date());
		sharedBookDao.addSharedBook(sharedBook);
	}
//���Խ��
//	[main] DEBUG c.s.dao.SharedBookDao.addSharedBook - <==    Updates: 1

	@Test
	public void testReduceSharedBook() {
		System.out.println(sharedBookDao.reduceSharedBook(23));
	}
//���Խ��
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@67af833b]
//	1
	
	@Test
	public void testReduceSharedBookByShared() {
		System.out.println(sharedBookDao.reduceSharedBookByShared("������ԭ��", "13878759898"));
	}
//���Խ����
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@287f94b1]
//	2 ������������������һ�������ݣ�
	@Test
	public void testUpdateSharedBook() {
		System.out.println(sharedBookDao.updateSharedBook("", "���յ¡�������", 24));
	}
//���Խ��
//	[main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7646731d]
//	1

}
