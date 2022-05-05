 package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.house.model.User;
import com.house.model.house;
import com.house.util.StringUtil;

public class houseDao {
	
	/**
	 * 商品房信息添加
	 * @param con
	 * @param house
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, house house) throws Exception {
		
		//插入商品房信息前 检查houseId是否已经存在，若存在，返回0
		String sqlid = "select * from house where houseId = ?";
		PreparedStatement pstmtid = (PreparedStatement) con.prepareStatement(sqlid);	
		pstmtid.setString(1, house.gethouseId());
		ResultSet rs = pstmtid.executeQuery();
		if(rs.next()) {
			return 0;
		}
		
		String sql = "insert into house values(?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setString(1, house.gethouseId());
		pstmt.setString(2, house.getfloor());
		pstmt.setString(3, house.getbuilding());
		pstmt.setString(4, house.getdeveloper());
		pstmt.setInt(5, house.getreservation());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 商品房查询
	 * @param con
	 * @param houseMessage
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, house houseMessage) throws Exception {
		
		//将house表和houseType表连接
		//StringBuffer sb = new StringBuffer("select * from house,housetype where house.typeId=housetype.typeId");
		StringBuffer sb = new StringBuffer("select * from house where houseId = houseId ");
		
		//向sb中添加，并进行模糊查询
		if(StringUtil.isNotEmpty(houseMessage.gethouseId())) {
			sb.append(" and houseId like '%" + houseMessage.gethouseId() + "%'");
		}

		//按楼层模糊查询
		if(StringUtil.isNotEmpty(houseMessage.getfloor())) {
			sb.append(" and house.floor like '%" + houseMessage.getfloor() + "%'");
		}

		//按楼号模糊查询
		if(StringUtil.isNotEmpty(houseMessage.getbuilding())) {
			sb.append(" and house.floor like '%" + houseMessage.getbuilding() + "%'");
		}

		//按小区模糊查询
		if(StringUtil.isNotEmpty(houseMessage.getdeveloper())) {
			sb.append(" and house.developer like '%" + houseMessage.getdeveloper() + "%'");
		}
		
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	//历史记录查询
	public ResultSet listHistory(Connection con, User userMessage) throws Exception {
		
		String sql = "select recordId,floor,userName, houseId, (case back when 0 then '否' when 1 then '是' end) as back from record where userName = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, userMessage.getUsername());
		return pstmt.executeQuery();
	}
	
	/**
	 * 商品房信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		
		String sql = "delete from house where houseId = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);	
		pstmt.setString(1, id);
	
		return pstmt.executeUpdate();
	}
	
	/**
	 * 商品房信息修改
	 * @param con
	 * @param houseMessage1
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, house houseMessage1) throws Exception {
		
		String sql = "update house set floor=?, press=?, author=? where houseId=?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
		pstmt.setString(1, houseMessage1.getfloor());
		pstmt.setString(2, houseMessage1.getbuilding());
		pstmt.setString(3, houseMessage1.getdeveloper());
		pstmt.setString(4, houseMessage1.gethouseId());
		return pstmt.executeUpdate();
	}
	
	//检查该id的商品房信息是否存在,若存在，返回0，否则返回1
	public ResultSet houseCheck(Connection con, String id) throws Exception{
		//插入商品房信息前 检查houseId是否已经存在，若存在，返回0
		String sqlid = "select * from house where houseId = ?";
		PreparedStatement pstmtid = (PreparedStatement) con.prepareStatement(sqlid);	
		pstmtid.setString(1, id);
		ResultSet rs = pstmtid.executeQuery();
		return rs;
	}

	/**
	  * 商品房预定
	  * 修改house表中的lend字段和预定记录表（lendrecord）中的back字段  lend=1,back=0
	 * @param con
	 * @param houseId
	 * @param floor
	 * @param userMessage
	 * @return
	 * @throws Exception
	 */
	public int reservation(Connection con, String houseId, String floor, User userMessage) throws Exception {
		//先修改house表中商品房信息的状态
		String sql = "update house set reservation=? where houseId=?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
		pstmt.setString(1, "1");
		pstmt.setString(2, houseId);
		pstmt.executeUpdate();
		
		//插入记录表(record) 信息
		String insql = "insert into record (userId,userName,houseId,floor,back)values(?,?,?,?,?)";
		PreparedStatement reservationtemp = (PreparedStatement) con.prepareStatement(insql);
		
		reservationtemp.setString(1, userMessage.getUserId());
		reservationtemp.setString(2, userMessage.getUsername());
		reservationtemp.setString(3, houseId);
		reservationtemp.setString(4, floor);
		reservationtemp.setString(5, "1");
		reservationtemp.executeUpdate();
		return 0;//成功
	}
	
	//商品房归还
	/**
	  * 修改house表中的lend字段和预
	 * 定记录表（record）中的back字段 lend=0,back=1
	 * @param con
	 * @param houseId
	 * @param userMessage
	 * @return
	 * @throws Exception
	 */
	public int back (Connection con, String houseId, User userMessage) throws Exception {
		
		
		//先修改house表中商品房的状态
		String sql = "update house set reservation=? where houseId=?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
		pstmt.setString(1, "0");
		pstmt.setString(2, houseId);
		pstmt.executeUpdate();
		
		//修改预定记录表(record) 信息 ，back=1,表示已经归还
		String insql = "update lendrecord set back=? where houseId=? and userName=? ";
		PreparedStatement lendpstmt = (PreparedStatement) con.prepareStatement(insql);
		
		lendpstmt.setString(1, "1");
		lendpstmt.setString(2, houseId);
		lendpstmt.setString(3, userMessage.getUsername());
		lendpstmt.executeUpdate();
		
		return 0;//成功
	}
}
