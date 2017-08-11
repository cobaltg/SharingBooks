package com.sharingbooks.service;

import java.util.List;

import com.sharingbooks.entity.SuccessBorrowed;

public interface SuccessBorrowedService {
	
	public List<SuccessBorrowed> getSuccessBorrowedListOfUserByPage(String userPhone, int currentPage);
	
}
