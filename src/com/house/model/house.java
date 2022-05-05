package com.house.model;

public class house {
	
	private String houseId;//商品房门牌号
	private String floor;//商品房楼层
	private String building;//商品房所属楼栋
	private String developer;//商品房开发商
	private int lend;//商品房是否被预定, 是为1, 默认为0

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
