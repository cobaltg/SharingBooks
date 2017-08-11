package com.sharingbooks.service;

import java.util.List;

import com.sharingbooks.entity.SuccessLended;

public interface SuccessLendedService {
	public List<SuccessLended> getSuccessLendedListOfUserByPage(String userPhone, int currentPage);
}
