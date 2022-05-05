package com.reservation.view;

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
import com.house.model.User;
import com.house.util.DbUtil;
import com.house.util.StringUtil;
import com.saleface.SalesMenuFram;

public class CancelReservation {

	//写一个登录后取消预购的方法
	public static void BackBook() {
		
		JFrame frame = new JFrame("");
		frame.setLayout(null);
		//开3个面板，方便设置位置
		JPanel pan1 = new JPanel();//用来存放系统名字组件
		JPanel pan2 = new JPanel();//用来存放用户身份和下拉框组件
		JPanel pan5 = new JPanel();//用来存放登录组件
		
		//文本框
		JTextField houseid = new JTextField();
		
		//提示框
		JLabel label1 = new JLabel("取 消 商 品 房 预 定");
		JLabel label2 = new JLabel("商品房门牌号  ");
	
		//按钮
		JButton button1 = new JButton("取消");

		Font font = new Font("宋体",Font.BOLD,50);//标题字体大小		
		Font f = new Font("宋体",Font.BOLD,13);//提示框字体大小
		
		//设置文本框的大小
		houseid.setPreferredSize(new Dimension(200,30));
		button1.setPreferredSize(new Dimension(90,40));
				
		//设置界面所有字体大小，包括标题、提示框字体和文本框
		label1.setFont(font);//设置标题字体
		label2.setFont(f);
		houseid.setFont(f);
		button1.setFont(f);
		
		//向面板中添加组件
		pan1.add(label1);
		pan2.add(label2);
		pan2.add(houseid);
		pan5.add(button1);
		
		//设置面板位置
		pan1.setBounds(140,50, 430, 60);
		pan2.setBounds(130,170, 430, 50);			
		pan5.setBounds(340,300,100, 50);//放查询按钮

		//添加面板
		frame.add(pan1);
		frame.add(pan2);		
		frame.add(pan5);			
		
		//预定商品房监听
		button1.addActionListener(e ->  {
								
				String houseId = houseid.getText();
				if(StringUtil.isEmpty(houseId)) {
					JOptionPane.showMessageDialog(null, "账号不能为空！");
					return;
				}
				Connection con = null;
				DbUtil dbutil = new DbUtil();			
				houseDao housedao = new houseDao();

				//获取登录后的id
				String loginId = SalesMenuFram.loginId();
				//获取登录后的用户名
				String loginName = SalesMenuFram.loginName();
				
				User userMessage = new User();
				userMessage.setUserId(loginId);
				userMessage.setUsername(loginName);
				
				try {
					con = dbutil.getCon();
					
					//检查输入的商品房门牌号是否存在，是否被预定
					ResultSet currenthouse = housedao.houseCheck(con, houseId);
					if(currenthouse.next()) {//该预定信息存在
						if(currenthouse.getInt("reservation") == 1) {
							JOptionPane.showMessageDialog(null, "该房产已被预定，请查看其他！");
							return;
						}
						String houseid2 = currenthouse.getString("houseId");
						
						int reservation = housedao.back(con,houseId,userMessage);//
						
						if(reservation == 0) {
							JOptionPane.showMessageDialog(null, "取消预定成功");
						} else {
							JOptionPane.showMessageDialog(null, "取消预定失败！");
						}
					} else {
						JOptionPane.showMessageDialog(null, "未找到该房产信息，请输入正确的门牌号");
						return;
					}					
					

				}catch(Exception evt) {
					evt.printStackTrace();
				}
		});
	
		//窗口设置
		frame.setBounds(500, 150, 750, 550);
		frame.setVisible(true);		
	}
}
