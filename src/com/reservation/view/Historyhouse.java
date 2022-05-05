package com.reservation.view;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.house.dao.houseDao;
import com.house.model.User;
import com.house.util.DbUtil;
import com.saleface.SalesMenuFram;

public class Historyhouse {

	//дһ����¼���ѯ��ʷ��¼�ķ���
	public static void Historyhouse() {
		
		JFrame frame = new JFrame("��ʷ��ѯ");
		frame.setLayout(null);
		
		JPanel pan = new JPanel();
		
		Font font = new Font("����",Font.BOLD,50);//���������С		
		Font f = new Font("����",Font.BOLD,25);//��ʾ�������С
		Font f2 = new Font("����",Font.BOLD,13);//������������С

	

		String [] columnNames = { "ԤԼ��","¥��", "���ƺ�","�ͻ�", "�Ƿ�Ԥ��"};
		DefaultTableModel model = new DefaultTableModel(columnNames,6);
		JTable jTable = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(jTable);
		
		scrollPane.setBounds(200,140, 800, 250);
		//frame.setBounds(450, 150, 1150, 650);
	
		Connection con = null;
		DbUtil dbutil = new DbUtil();			
		houseDao houseDao = new houseDao();
		
		//��ȡ��¼���id
		String loginId = SalesMenuFram.loginId();
		//��ȡ��¼����û���
		String loginName = SalesMenuFram.loginName();
		
		User userMessage = new User();
		userMessage.setUserId(loginId);
		userMessage.setUsername(loginName);
				
		DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
		dtm.setRowCount(0);//��ʼ��Ϊ0��
		jTable.setFont(f2);
		try {
			con = dbutil.getCon();			
			ResultSet currenthouse = houseDao.listHistory(con,userMessage);
			
			while(currenthouse.next()) {
				Vector v = new Vector();
				v.add(currenthouse.getString("recordId"));
				v.add(currenthouse.getString("floor"));
				v.add(currenthouse.getString("houseId"));
				v.add(currenthouse.getString("userName"));
				v.add(currenthouse.getString("back"));
				
				dtm.addRow(v);
			}
		
		}catch(Exception evt) {
			evt.printStackTrace();
		}
	
		frame.add(scrollPane);
		frame.setBounds(450, 150, 1150, 650);
		frame.setVisible(true);		
	}
}
