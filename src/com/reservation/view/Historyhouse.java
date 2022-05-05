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

	//写一个登录后查询历史记录的方法
	public static void Historyhouse() {
		
		JFrame frame = new JFrame("历史查询");
		frame.setLayout(null);
		
		JPanel pan = new JPanel();
		
		Font font = new Font("宋体",Font.BOLD,50);//标题字体大小		
		Font f = new Font("宋体",Font.BOLD,25);//提示框字体大小
		Font f2 = new Font("宋体",Font.BOLD,13);//结果表中字体大小

	

		String [] columnNames = { "预约号","楼层", "门牌号","客户", "是否被预定"};
		DefaultTableModel model = new DefaultTableModel(columnNames,6);
		JTable jTable = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(jTable);
		
		scrollPane.setBounds(200,140, 800, 250);
		//frame.setBounds(450, 150, 1150, 650);
	
		Connection con = null;
		DbUtil dbutil = new DbUtil();			
		houseDao houseDao = new houseDao();
		
		//获取登录后的id
		String loginId = SalesMenuFram.loginId();
		//获取登录后的用户名
		String loginName = SalesMenuFram.loginName();
		
		User userMessage = new User();
		userMessage.setUserId(loginId);
		userMessage.setUsername(loginName);
				
		DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
		dtm.setRowCount(0);//初始化为0行
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
