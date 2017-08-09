package com.sharingbooks.enums;

/**
 * 用枚举来表示常量
 * 
 * @author think
 * 
 */
public enum BorrowedBookStateEnum {
	SUCCESS(1, "节约成功"), DEFEAT(0, "系统异常"), DATA_REWRITE(-1, "数据重写");

	private int state;

	private String stateInfo;

	BorrowedBookStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static BorrowedBookStateEnum stateOf(int index) {
		for (BorrowedBookStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
