package com.housemanager.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.house.dao.houseDao;
import com.house.util.DbUtil;
import com.house.model.house;

public class HouseLookFram {

		//写一个登录后图书管理方法
		public static void BookLookFram() {
			
			JFrame frame = new JFrame("");
			
			frame.setLayout(null);
			//开6个面板，方便设置位置
			JPanel pan1 = new JPanel();//用来存放系统名字组件
			JPanel pan2 = new JPanel();//用来存放用户身份和下拉框组件
			JPanel pan3 = new JPanel();//用来存放账号和文本框组件
			JPanel pan4 = new JPanel();//用来存放密码和密码框组件
			JPanel pan5 = new JPanel();//用来存放登录组件
			JPanel pan6 = new JPanel();//存放查询结果
			
			//文本框
			JTextField textId = new JTextField();//
			JTextField textfloor = new JTextField();//
			JTextField textdeveloper = new JTextField();//
			JTextField textbuilding = new JTextField();
			
			//提示框
			JLabel label1 = new JLabel("商 品 房 查 询");
			JLabel label2 = new JLabel("房  间   号  ");
			JLabel label3 = new JLabel("楼       层  ");
			JLabel label4 = new JLabel("所 属 社 区  ");
			JLabel label5 = new JLabel("楼       号  ");
					
			//按钮
			JButton button1 = new JButton("查询");
			
			Font font = new Font("宋体",Font.BOLD,50);//标题字体大小		
			Font f = new Font("宋体",Font.BOLD,25);//提示框字体大小
			Font f2 = new Font("宋体",Font.BOLD,13);//结果表中字体大小
			//设置文本框的大小
			textId.setPreferredSize(new Dimension(200,30));
			textfloor.setPreferredSize(new Dimension(200,30));
			textdeveloper.setPreferredSize(new Dimension(200,30));
			textbuilding.setPreferredSize(new Dimension(200,30));
			button1.setPreferredSize(new Dimension(90,40));
					
			//设置界面所有字体大小，包括标题、提示框字体和文本框
			label1.setFont(font);//设置标题字体
			label2.setFont(f);
			textId.setFont(f);
			label3.setFont(f);
			textfloor.setFont(f);
			label4.setFont(f);
			label5.setFont(f);
			textbuilding.setFont(f);
			button1.setFont(f);
			
			//向面板中添加组件
			pan1.add(label1);
			pan2.add(label2);
			pan2.add(textId);
			pan3.add(label3);
			pan3.add(textfloor);
			pan4.add(label4);
			pan4.add(textdeveloper);
			pan5.add(button1);
			
			//设置面板位置
			pan1.setBounds(235,50, 430, 60);
			pan2.setBounds(100,170, 430, 50);
			pan3.setBounds(100,240, 430, 50);
			pan4.setBounds(100,310, 430, 50);		
			pan5.setBounds(250,450,100, 50);//放查询按钮

			String [] columnNames = { "门牌号","楼层" ,"楼号", "所属社区","是否被预定"};
			DefaultTableModel model = new DefaultTableModel(columnNames,11);
			JTable jTable = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(jTable);
			//scrollPane.setPreferredSize(new Dimension(30,10));
			scrollPane.setBounds(580,170, 430, 201);
			
			//监听
			button1.addActionListener(e ->  {
									
					String houseid = textId.getText().toString();
					String floor = textfloor.getText().toString();
					String developer = textdeveloper.getText().toString();
					String building = textbuilding.getText().toString();

					Connection con = null;
					DbUtil dbutil = new DbUtil();			
					houseDao bookdao = new houseDao();
					house houseMessage = new house();
					
					houseMessage.sethouseId(houseid);
					houseMessage.setfloor(floor);
					houseMessage.setdeveloper(developer);
					
					DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
					dtm.setRowCount(0);//初始化为0行
					jTable.setFont(f2);
					try {
						con = dbutil.getCon();			
						ResultSet currentbook = bookdao.list(con, houseMessage);

							while(currentbook.next()) {
							Vector v = new Vector();
							v.add(currentbook.getString("houseId"));
							v.add(currentbook.getString("floor"));
							v.add(currentbook.getString("building"));
							v.add(currentbook.getString("developer"));
							if(currentbook.getString("reservation").equals("0")) {
								v.add("否");
							} else {
								v.add("是");
							}
							dtm.addRow(v);
						}
					
					}catch(Exception evt) {
						evt.printStackTrace();
					}
			});
					
			//添加面板
			frame.add(pan1);
			frame.add(pan2);
			frame.add(pan3);
			frame.add(pan4);
			frame.add(pan5);			
			frame.add(scrollPane);
			
			//窗口设置
			frame.setBounds(450, 150, 1150, 650);
			frame.setVisible(true);		
		}		
}
