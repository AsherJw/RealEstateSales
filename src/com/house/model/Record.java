package com.house.model;

public class Record {
	private int recordId;/*房屋被预定记录id*/
	private String userId;/*用户id*/
	private String userName;/*用户名*/
	private String houseId;/*商品房id*/
	private String floor;/*楼层*/
	private int back;/*是否取消预订, 是为1, 默认为0*/

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String gethouseId() {
		return houseId;
	}

	public void sethouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getfloor() {
		return floor;
	}

	public void setfloor(String floor) {
		this.floor = floor;
	}

	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}
}
