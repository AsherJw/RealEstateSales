package com.house.model;

public class Record {
	private int recordId;/*���ݱ�Ԥ����¼id*/
	private String userId;/*�û�id*/
	private String userName;/*�û���*/
	private String houseId;/*��Ʒ��id*/
	private String floor;/*¥��*/
	private int back;/*�Ƿ�ȡ��Ԥ��, ��Ϊ1, Ĭ��Ϊ0*/

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
