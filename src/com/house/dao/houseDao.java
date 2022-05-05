 package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.house.model.User;
import com.house.model.house;
import com.house.util.StringUtil;

public class houseDao {
	
	/**
	 * ��Ʒ����Ϣ���
	 * @param con
	 * @param house
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, house house) throws Exception {
		
		//������Ʒ����Ϣǰ ���houseId�Ƿ��Ѿ����ڣ������ڣ�����0
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
	 * ��Ʒ����ѯ
	 * @param con
	 * @param houseMessage
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, house houseMessage) throws Exception {
		
		//��house���houseType������
		//StringBuffer sb = new StringBuffer("select * from house,housetype where house.typeId=housetype.typeId");
		StringBuffer sb = new StringBuffer("select * from house where houseId = houseId ");
		
		//��sb����ӣ�������ģ����ѯ
		if(StringUtil.isNotEmpty(houseMessage.gethouseId())) {
			sb.append(" and houseId like '%" + houseMessage.gethouseId() + "%'");
		}

		//��¥��ģ����ѯ
		if(StringUtil.isNotEmpty(houseMessage.getfloor())) {
			sb.append(" and house.floor like '%" + houseMessage.getfloor() + "%'");
		}

		//��¥��ģ����ѯ
		if(StringUtil.isNotEmpty(houseMessage.getbuilding())) {
			sb.append(" and house.floor like '%" + houseMessage.getbuilding() + "%'");
		}

		//��С��ģ����ѯ
		if(StringUtil.isNotEmpty(houseMessage.getdeveloper())) {
			sb.append(" and house.developer like '%" + houseMessage.getdeveloper() + "%'");
		}
		
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	//��ʷ��¼��ѯ
	public ResultSet listHistory(Connection con, User userMessage) throws Exception {
		
		String sql = "select recordId,floor,userName, houseId, (case back when 0 then '��' when 1 then '��' end) as back from record where userName = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, userMessage.getUsername());
		return pstmt.executeQuery();
	}
	
	/**
	 * ��Ʒ����Ϣɾ��
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
	 * ��Ʒ����Ϣ�޸�
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
	
	//����id����Ʒ����Ϣ�Ƿ����,�����ڣ�����0�����򷵻�1
	public ResultSet houseCheck(Connection con, String id) throws Exception{
		//������Ʒ����Ϣǰ ���houseId�Ƿ��Ѿ����ڣ������ڣ�����0
		String sqlid = "select * from house where houseId = ?";
		PreparedStatement pstmtid = (PreparedStatement) con.prepareStatement(sqlid);	
		pstmtid.setString(1, id);
		ResultSet rs = pstmtid.executeQuery();
		return rs;
	}

	/**
	  * ��Ʒ��Ԥ��
	  * �޸�house���е�lend�ֶκ�Ԥ����¼��lendrecord���е�back�ֶ�  lend=1,back=0
	 * @param con
	 * @param houseId
	 * @param floor
	 * @param userMessage
	 * @return
	 * @throws Exception
	 */
	public int reservation(Connection con, String houseId, String floor, User userMessage) throws Exception {
		//���޸�house������Ʒ����Ϣ��״̬
		String sql = "update house set reservation=? where houseId=?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
		pstmt.setString(1, "1");
		pstmt.setString(2, houseId);
		pstmt.executeUpdate();
		
		//�����¼��(record) ��Ϣ
		String insql = "insert into record (userId,userName,houseId,floor,back)values(?,?,?,?,?)";
		PreparedStatement reservationtemp = (PreparedStatement) con.prepareStatement(insql);
		
		reservationtemp.setString(1, userMessage.getUserId());
		reservationtemp.setString(2, userMessage.getUsername());
		reservationtemp.setString(3, houseId);
		reservationtemp.setString(4, floor);
		reservationtemp.setString(5, "1");
		reservationtemp.executeUpdate();
		return 0;//�ɹ�
	}
	
	//��Ʒ���黹
	/**
	  * �޸�house���е�lend�ֶκ�Ԥ
	 * ����¼��record���е�back�ֶ� lend=0,back=1
	 * @param con
	 * @param houseId
	 * @param userMessage
	 * @return
	 * @throws Exception
	 */
	public int back (Connection con, String houseId, User userMessage) throws Exception {
		
		
		//���޸�house������Ʒ����״̬
		String sql = "update house set reservation=? where houseId=?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
		pstmt.setString(1, "0");
		pstmt.setString(2, houseId);
		pstmt.executeUpdate();
		
		//�޸�Ԥ����¼��(record) ��Ϣ ��back=1,��ʾ�Ѿ��黹
		String insql = "update lendrecord set back=? where houseId=? and userName=? ";
		PreparedStatement lendpstmt = (PreparedStatement) con.prepareStatement(insql);
		
		lendpstmt.setString(1, "1");
		lendpstmt.setString(2, houseId);
		lendpstmt.setString(3, userMessage.getUsername());
		lendpstmt.executeUpdate();
		
		return 0;//�ɹ�
	}
}
