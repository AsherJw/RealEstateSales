package com.housemanager.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.house.dao.houseDao;

import com.house.util.DbUtil;
import com.house.util.StringUtil;

public class HouseDeleteFram {

	//写一个管理员登录后删除商品房信息方法
			public static void BookDeleteFram() {
				
				JFrame frame = new JFrame("删除商品房信息");
				frame.setLayout(null);
				//开6个面板，方便设置位置
				JPanel pan1 = new JPanel();//用来存放系统名字组件
				JPanel pan2 = new JPanel();//用来存放用户身份和下拉框组件
				JPanel pan5 = new JPanel();//用来存放登录组件
				
				//文本框
				JTextField textId = new JTextField();//
				
				//提示框
				JLabel label1 = new JLabel("商品房信息删除");
				JLabel label2 = new JLabel("商品房门牌号 ");
			
				//按钮
				JButton button1 = new JButton("删除");
		
				Font font = new Font("宋体",Font.BOLD,50);//标题字体大小		
				Font f = new Font("宋体",Font.BOLD,13);//提示框字体大小
				
				//设置文本框的大小
				textId.setPreferredSize(new Dimension(200,30));
				button1.setPreferredSize(new Dimension(90,40));
						
				//设置界面所有字体大小，包括标题、提示框字体和文本框
				label1.setFont(font);//设置标题字体
				label2.setFont(f);
				textId.setFont(f);
				button1.setFont(f);
				
				//向面板中添加组件
				pan1.add(label1);
				pan2.add(label2);
				pan2.add(textId);
				pan5.add(button1);
				
				//设置面板位置
				pan1.setBounds(140,50, 430, 60);
				pan2.setBounds(130,170, 430, 50);			
				pan5.setBounds(340,300,100, 50);//放查询按钮
		
				//添加面板
				frame.add(pan1);
				frame.add(pan2);		
				frame.add(pan5);			
				
				//用户查询监听
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
										
						String textid = textId.getText();
						if(StringUtil.isEmpty(textid)) {
							JOptionPane.showMessageDialog(null, "商品房门牌号不能为空！");
							return;
						}

						Connection con = null;
						DbUtil dbutil = new DbUtil();			
						houseDao bookdao = new houseDao();
						
						try {
							con = dbutil.getCon();			
							int currentUser = bookdao.delete(con,textid);//若找并删除，返回值为1
							
							if(currentUser == 1) {
								JOptionPane.showMessageDialog(null, "删除成功");						
							} else {
								JOptionPane.showMessageDialog(null, "未找到该商品房信息！");
							}						
						}catch(Exception evt) {
							evt.printStackTrace();
						}
					}
				});
			
				//窗口设置
				frame.setBounds(500, 150, 750, 550);
				frame.setVisible(true);		
			}		
}
