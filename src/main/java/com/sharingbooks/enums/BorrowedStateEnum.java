package com.sharingbooks.enums;

/**
 * 用枚举来表示常量
 * 
 * @author think
 * 
 */
public enum BorrowedStateEnum {
	SUCCESS(1, "借阅成功"), INNER_ERROR(0, "系统异常，借阅失败！"), REPEAT_BORROWED(-1, "重复借书！"),BOOK_IS_NOT_EXIST(-2,"");

	private int state;

	private String stateInfo;

	BorrowedStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static BorrowedStateEnum stateOf(int index) {
		for (BorrowedStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
