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
import com.sharingbooks.dao.SuccessBorrowedDao;
import com.sharingbooks.dto.BorrowedExecution;
import com.sharingbooks.dto.Page;
import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.enums.BorrowedStateEnum;
import com.sharingbooks.exception.BorrowedException;
import com.sharingbooks.exception.RepeatBorrowedException;
import com.sharingbooks.exception.SharedBookIsNotExitException;
import com.sharingbooks.service.SharedBookService;

@Service
public class SharedBookServiceImpl implements SharedBookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private SharedBookDao sharedBookDao;

	@Autowired
	private BorrowedBookDao borrowedBookDao;

	@Autowired
	private SuccessBorrowedDao successBorrowedDao;

	private Page page;

	public SharedBook getById(long bookId) {
		return sharedBookDao.querySharedBookById(bookId);
	}

	public List<SharedBook> getSharedBookByBookInfo(String bookName,
			String bookDescription) {
		return sharedBookDao
				.queryShareBookByBookInfo(bookName, bookDescription);
	}

	public int countSharedBookByBookInfo(String bookName, String bookDescription) {
		return sharedBookDao.countSharedBook(bookName, bookDescription);
	}

	public List<SharedBook> getSharedBookListByPage(String bookName,
			String bookDescription, int currentPage) {
		// page对象是一个Bean,是有状态的，所以在这new一个Page对象
		page = new Page();
		// 设置当前页数
		page.setCurrentPage(currentPage);
		// 获取需要显示书籍信息总条数
		int totalNumber = sharedBookDao.countSharedBook(bookName,
				bookDescription);
		page.setTotalNumber(totalNumber);
		// 根据偏移量显示分页书籍信息
		return sharedBookDao.querySharedBookListByPage(bookName,
				bookDescription, page.getDbIndex(), page.getDbNumber());
	}

	/**
	 * 使用注解控制事务方法的优点 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，比如只有一条修改操作，只读操作不需要事务控制
	 */
	@Transactional
	public BorrowedExecution executeBorrowed(long bookId, String userPhone)
			throws BorrowedException, RepeatBorrowedException,
			SharedBookIsNotExitException {
		// 执行借书操作：
		// 1.如果用户登记了所要借的书籍的信息，则删除该登记信息,否则不作任何操作
		// 2.在可借书籍信息表中删除所借书籍信息
		// 3.记录成功借阅行为，插入成功借阅表
		Date date=new Date();
		SharedBook sharedbook=sharedBookDao.querySharedBookById(bookId);
		if(sharedbook==null){
			throw new SharedBookIsNotExitException(
					"SharedBook is not avaliable!");
		}
		int deleteCount = borrowedBookDao.reduceBorrowedBookByBorrowed(
				sharedbook.getBookName(),sharedbook.getBookDescription(),
				userPhone);// 步骤1
		try { 
			if (deleteCount > 1) {
				// 更新数据行数不合理，有两本同样的需借书籍
				throw new BorrowedException("Fail to borrow!");
			}
			int updateCount = sharedBookDao.reduceSharedBook(bookId);// 步骤2
			if (updateCount <= 0) {
				// 没有更新到记录,书籍不存在。
				throw new SharedBookIsNotExitException(
						"SharedBook is not avaliable!");
			}
			int insertCount = successBorrowedDao.insertSuccessBorrowed(sharedbook.getBookId(), sharedbook.getBookName(), sharedbook.getBookDescription(), sharedbook.getMasterPhone(), userPhone, date);
			if (insertCount <= 0) {
				// 重复借阅
				throw new RepeatBorrowedException("Repeat borrowed!");
			} else {
				return new BorrowedExecution(bookId,
						BorrowedStateEnum.SUCCESS, date);
			}
		} catch (SharedBookIsNotExitException e1) {
			throw e1;
		} catch (RepeatBorrowedException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 所有的异常转化为运行期异常
			throw new BorrowedException("BorrowedBook inner error: ",
					e.getMessage());
		}
	}

	public int countSharedBookOfUserByBookInfo(String userName, String userPhone) {
		return sharedBookDao.countquerySharedBookListOfUser(userPhone);
	}

	public List<SharedBook> getSharedBookListOfUserByPage(int currentPage, String userPhone) {
		// page对象是一个Bean,是有状态的，所以在这new一个Page对象
		page = new Page();
		// 设置当前页数
		page.setCurrentPage(currentPage);
		// 获取需要显示书籍信息总条数
		page.setTotalNumber(sharedBookDao.countquerySharedBookListOfUser(userPhone));
		// 根据偏移量显示分页书籍信息
		return sharedBookDao.querySharedBookListOfUserByPage(userPhone, page.getDbIndex(), page.getDbNumber());
	}

	public int addOneSharedBook(String bookname, String bookDescription,
			String masterPhone, Date releaseTime) {
		int count=sharedBookDao.addSharedBook(bookname, bookDescription, masterPhone, releaseTime);
		return count;
	}

	public int reduceOneSharedBook(long bookId) {
		int count=sharedBookDao.reduceSharedBook(bookId);
		return count;
	}

	public int updateSharedBook(String bookName, String bookDescription,
			long bookId) {
		int count=sharedBookDao.updateSharedBook(bookName, bookDescription, bookId);
		return count;
	}



}
