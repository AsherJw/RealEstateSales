package com.house.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	private String url = "jdbc:mysql://localhost:3306/work?useSSL=false&serverTimezone=CTT&allowPublicKeyRetrieval=true";
	private String username = "root";
	private String password = "1234";
	
	//�������ݿⷽ��
	public Connection getCon() throws Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		return con;
	}
	//�ر����ݿⷽ��
	public void closeCon(java.sql.Connection con) throws Exception {
		
		if(con != null) {
			con.close();
		}
	}
	
/*	 public static void main(String[] args) {
		 DbUtil dbUtil = new DbUtil(); 
		 try {
			 dbUtil.getCon(); 
			 System.out.println("���ݿ����ӳɹ�"); 
			 } catch (Exception e) { 
				 // TODO Auto-generated catch block 
				 e.printStackTrace(); //�������д�ӡ�쳣��Ϣ�ڳ����г�����λ�ü�ԭ��
				 System.out.println("���ݿ����Ӵ���"); 
				 } 
		 } */
}