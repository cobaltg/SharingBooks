package com.sharingbooks.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharingbooks.entity.SuccessBorrowed;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class SuccessBorrowedServiceTest {
	
	@Autowired
	private SuccessBorrowedService successBorrowedService;
	
	@Test
	public void testGetSuccessBorrowedListOfUserByPage() {
		List<SuccessBorrowed> list=successBorrowedService.getSuccessBorrowedListOfUserByPage("借书人13", 1);
		for(SuccessBorrowed s: list){
			System.out.println(s);
		}
	}
//测试结果
//	++++++++++++++++++++++++++++++
//	Page [totalNumber=7, currentPage=1, totalPage=1, pageNumber=10, dbIndex=0, dbNumber=10]
//	++++++++++++++++++++++++++++++
}
