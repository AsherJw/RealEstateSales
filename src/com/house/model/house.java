package com.house.model;

public class house {
	
	private String houseId;//��Ʒ�����ƺ�
	private String floor;//��Ʒ��¥��
	private String building;//��Ʒ������¥��
	private String developer;//��Ʒ��������
	private int lend;//��Ʒ���Ƿ�Ԥ��, ��Ϊ1, Ĭ��Ϊ0

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

	public String getbuilding() {
		return building;
	}

	public void setbuilding(String building) {
		this.building = building;
	}

	public String getdeveloper() {
		return developer;
	}

	public void setdeveloper(String developers) {
		this.developer = developers;
	}

	public int getreservation() {
		return lend;
	}


	public void setLend(int lend) {
		this.lend = lend;
	}

}
