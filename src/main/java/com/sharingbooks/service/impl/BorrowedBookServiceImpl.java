package com.sharingbooks.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharingbooks.dao.BorrowedBookDao;
import com.sharingbooks.dao.SharedBookDao;
import com.sharingbooks.dao.SuccessLendedDao;
import com.sharingbooks.dto.Page;
import com.sharingbooks.dto.SharedExecution;
import com.sharingbooks.entity.BorrowedBook;
import com.sharingbooks.enums.SharedStateEnum;
import com.sharingbooks.exception.BorrowedBookIsNotExitException;
import com.sharingbooks.exception.RepeatSharedException;
import com.sharingbooks.exception.SharedException;
import com.sharingbooks.service.BorrowedBookService;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService{
	
	private Logger logger= LoggerFactory.getLogger(getClass());
	
	//注入Service依赖
	@Autowired
	private BorrowedBookDao borrowedBookDao;
	
	@Autowired
	private SharedBookDao sharedBookDao;
	
	@Autowired
	private SuccessLendedDao successLendedDao;
	
	private Page page;
	
	public BorrowedBook getById(long bookId) {
		return borrowedBookDao.queryBorrowedBookById(bookId);
	}

	public List<BorrowedBook> getBorrowedBookByBookInfo(String bookName,
			String bookDescription) {
		return borrowedBookDao.queryBorrowedBookByBookInfo(bookName, bookDescription);
	}

	public int countBorrowedBookByBookInfo(String bookName,
			String bookDescription) {
		return borrowedBookDao.countBorrowedBook(bookName, bookDescription);
	}

	public List<BorrowedBook> getBorrowedBookListByPage(String bookName,
			String bookDescription, int currentPage) {
		// page对象是一个Bean,是有状态的，所以在这new一个Page对象
		page = new Page();
		// 设置当前页数
		page.setCurrentPage(currentPage);
		// 获取需要显示书籍信息总条数
		int totalNumber = borrowedBookDao.countBorrowedBook(bookName,
				bookDescription);
		page.setTotalNumber(totalNumber);
//		System.out.println("+++++++++++++++++++++++");
//		System.out.println(page);
//		System.out.println("+++++++++++++++++++++++");
		return borrowedBookDao.queryBorrowedBookListByPage(bookName, bookDescription, page.getDbIndex(), page.getDbNumber());
	}

	@Transactional
	public SharedExecution executeShared(long bookId, String userPhone)
			throws SharedException, RepeatSharedException,
			BorrowedBookIsNotExitException {
//		执行借出书籍操作
//		1.如果用户登记了可借出的书籍的信息，则要删除（可借书籍信息表中）相应的登记信息，否则不做任何操作
//		2.在需借书籍信息表中删除记录
//		3.记录借出书籍行为，插入成功借出表
		Date date = new Date();
		BorrowedBook borrowedBook=borrowedBookDao.queryBorrowedBookById(bookId);
		if(borrowedBook==null){
			throw new BorrowedBookIsNotExitException("BorrowedBook is not exit!");
		}
		int deleteCount=sharedBookDao.reduceSharedBookByShared(borrowedBook.getBookName(), borrowedBook.getBookDescription(), userPhone);//步骤1
		try{
			if(deleteCount>1){
				//更新数据不合理，有两本以上同样的可借书籍
				throw new SharedException("Fail to shared!");
			}
			int updateCount= borrowedBookDao.reduceBorrowedBook(bookId);//步骤2
			if(updateCount<=0){
				//没有更新到记录（没有减库存）
				throw new BorrowedBookIsNotExitException("BorrowedBook is not exit!");
			}
			int insertCount= successLendedDao.insertSuccessLended(borrowedBook.getBookId(), borrowedBook.getBookName(),borrowedBook.getBookDescription(),userPhone,borrowedBook.getBorrowerPhone(),date);
			if(insertCount<=0){
				//重复借出
				throw new RepeatSharedException("Repeat Lended!");
			}
			else{
				return new SharedExecution(bookId, SharedStateEnum.SUCCESS,date);
			}
		}catch(BorrowedBookIsNotExitException e1){
			throw e1;
		}catch(RepeatSharedException e2){
			throw e2;
		}catch(SharedException e){
			logger.error(e.getMessage(),e);
			throw new SharedException("SharedBookException inner error: ",e.getMessage());
		}
	}

	public int countBorrowedBookOfUserByBookInfo(String userPhone) {
		return borrowedBookDao.countqueryBorrowedBookListOfUser(userPhone);
	}

	public List<BorrowedBook> getBorrowedBookListOfUserByPage(int currentPage,
			String userPhone) {
		// page对象是一个Bean,是有状态的，所以在这new一个Page对象
		page = new Page();
		// 设置当前页数
		page.setCurrentPage(currentPage);
		// 获取需要显示书籍信息总条数
		int totalNumber = borrowedBookDao.countqueryBorrowedBookListOfUser(userPhone);
		page.setTotalNumber(totalNumber);
		return borrowedBookDao.queryBorrowedBookListOfUserByPage(userPhone, page.getDbIndex(), page.getDbNumber());
	}

	public int addOneBorrowedBook(String bookName, String bookDescription,
			String borrowerPhone, Date releaseTime) {
		return borrowedBookDao.addBorrowedBook(bookName, bookDescription, borrowerPhone, releaseTime);
	}

	public int reduceOneBorrowedBook(long bookId) {
		return borrowedBookDao.reduceBorrowedBook(bookId);
	}

	public int updateBorrowedBook(String bookName, String bookDescription,
			long bookId) {
		return borrowedBookDao.updateBorrowedBook(bookName, bookDescription, bookId);	
	}

}
