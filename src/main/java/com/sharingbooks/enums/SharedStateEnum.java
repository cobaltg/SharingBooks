package com.sharingbooks.enums;

public enum SharedStateEnum {

	/**
	 * 用枚举来表示常量
	 * 
	 * @author think
	 * 
	 */
	SUCCESS(1, "借出成功"), DEFEAT(0, "系统异常,借出失败！"), DATA_REWRITE(-1, "数据重写");

	private int state;

	private String stateInfo;

	SharedStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
		
	public static SharedStateEnum stateOf(int index) {
		for (SharedStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
