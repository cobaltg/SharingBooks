package com.sharingbooks.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharingbooks.dto.BorrowedExecution;
import com.sharingbooks.dto.SharedBookResult;
import com.sharingbooks.entity.SharedBook;
import com.sharingbooks.enums.BorrowedStateEnum;
import com.sharingbooks.exception.RepeatBorrowedException;
import com.sharingbooks.exception.SharedBookIsNotExitException;
import com.sharingbooks.service.SharedBookService;

@Controller
@RequestMapping("/SharedBook")
// url:/模块/资源/{id}/细分
public class SharedBookController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SharedBookService sharedBookService;

	// 对http的请求方式做限制，不满足直接驳回
	@RequestMapping(name = "/{name}/{desc}/{currentPage}/list", method = RequestMethod.POST)
	public String list(@PathVariable("name") String name,
			@PathVariable("desc") String desc,
			@PathVariable("desc") int currentPage, Model model) {
		// 获取列表页
		List<SharedBook> list = sharedBookService.getSharedBookListByPage(name,
				desc, currentPage);
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list"; 
	}

	@RequestMapping(value = "/{bookId}/execution", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public SharedBookResult<BorrowedExecution> execute(
			@PathVariable("bookId") long bookId,
			@CookieValue(value = "userPhone", required = false) String userPhone) {
		//验证信息
		if(userPhone==null){
			return new SharedBookResult<BorrowedExecution>(false,"未登录！");
		}
		try{
			BorrowedExecution execution = sharedBookService.executeBorrowed(bookId,
					userPhone);
			return new SharedBookResult<BorrowedExecution>(true,execution);
		}catch(SharedBookIsNotExitException e){
			BorrowedExecution execution=new BorrowedExecution(bookId,BorrowedStateEnum.BOOK_IS_NOT_EXIST,new Date());
			return new SharedBookResult<BorrowedExecution>(false,execution);
		}catch(RepeatBorrowedException e){
			BorrowedExecution execution=new BorrowedExecution(bookId,BorrowedStateEnum.REPEAT_BORROWED,new Date());
			return new SharedBookResult<BorrowedExecution>(false,execution);
		}		
		catch(Exception e){
			logger.error(e.getMessage(), e);
			BorrowedExecution execution=new BorrowedExecution(bookId,BorrowedStateEnum.INNER_ERROR,new Date());
			return new SharedBookResult<BorrowedExecution>(false,execution);
		}
	}
}
