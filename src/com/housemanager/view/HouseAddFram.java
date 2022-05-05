package com.housemanager.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.house.dao.houseDao;
import com.house.util.DbUtil;
import com.house.util.StringUtil;

import com.house.model.house;

public class HouseAddFram {

	public static void bookAddFram() {
			
			JFrame frame = new JFrame("");
			frame.setLayout(null);
			//开6个面板，方便设置位置
			JPanel pan1 = new JPanel();//用来存放系统名字组件
			JPanel pan2 = new JPanel();//用来存放用户身份和下拉框组件
			JPanel pan3 = new JPanel();//用来存放账号和文本框组件
			JPanel pan4 = new JPanel();//用来存放密码和密码框组件
			JPanel pan5 = new JPanel();//用来存放提交组件
			JPanel pan6 = new JPanel();//用来存放提交组件
			//文本框
			JTextField textId = new JTextField();//房间号
			JTextField textfloor = new JTextField();//楼层
			JTextField textdeveloper = new JTextField();//开发商/小区名字
			JTextField textbuilding = new JTextField();//
			
			//提示框
			JLabel label1 = new JLabel("商 品 房 添 加");
			JLabel label2 = new JLabel("门	 牌	 号  ");
			JLabel label3 = new JLabel("楼  	 层  ");
			JLabel label4 = new JLabel("所 属 社 区  ");
			JLabel label5 = new JLabel("楼    	 号  ");

			//按钮
			JButton button1 = new JButton("提交");
			
			Font font = new Font("宋体",Font.BOLD,50);//标题字体大小		
			Font f = new Font("宋体",Font.BOLD,13);//提示框字体大小
			
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
			textdeveloper.setFont(f);
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
			pan5.add(label5);
			pan5.add(textbuilding);
			pan6.add(button1);
			
			//设置面板位置
			pan1.setBounds(235,50, 430, 60);
			pan2.setBounds(235,170, 430, 50);
			pan3.setBounds(235,240, 430, 50);
			pan4.setBounds(235,310, 430, 50);			
			pan5.setBounds(235,360,430, 50);		
			pan6.setBounds(450,450,100, 50);
			//添加面板
			frame.add(pan1);
			frame.add(pan2);
			frame.add(pan3);
			frame.add(pan4);
			frame.add(pan5);
			frame.add(pan6);
			
			//提交事件监听
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					house houseMessage = new house();
					
					String id = textId.getText();
					String floor = textfloor.getText();
					String developer = textdeveloper.getText();
					String building = textbuilding.getText();

					//注册时，判断输入文本框的值不能为空
					if(StringUtil.isEmpty(id)) {
						JOptionPane.showMessageDialog(null, "门牌号不能为空");
						return;
					} 
					else if(StringUtil.isEmpty(floor)){
						JOptionPane.showMessageDialog(null, "楼层不能为空！");
						return;
					}
					else if(StringUtil.isEmpty(developer)){
						JOptionPane.showMessageDialog(null, "所属社区及开发商不能为空！");
						return;
					}
					else if(StringUtil.isEmpty(building)){
						JOptionPane.showMessageDialog(null, "楼号不能为空！");
						return;
					}
					
					//将用户输入的信息封装到userMessage类里面
					houseMessage.sethouseId(id);
					houseMessage.setfloor(floor);
					houseMessage.setdeveloper(developer);
					houseMessage.setbuilding(building);
					
					DbUtil dbutil = new DbUtil();
					houseDao housedao = new houseDao();
					
					try {
						Connection con = dbutil.getCon();		
						
						//先判断该书Id在是否存在，若存在，重新输入
						ResultSet currentId = housedao.houseCheck(con, id);
						if(currentId.next()) {
							JOptionPane.showMessageDialog(null, "房屋信息已存在，请重新确认信息！");
							return;
						}
						
						//若不存在，可以进行插入
						int current = housedao.add(con, houseMessage);
						
						//提示框，若返回值是1，添加成功
						if(current == 1) {
							JOptionPane.showMessageDialog(null, "添加成功");
							frame.dispose();
							return;
						} else {
							JOptionPane.showMessageDialog(null, "添加失败！");
							return;
						}
					}catch(Exception evt) {
						evt.printStackTrace();
					}
				}		
			});
			
			//窗口设置
			frame.setBounds(500, 150, 950, 650);
			frame.setVisible(true);	
		}	
}
