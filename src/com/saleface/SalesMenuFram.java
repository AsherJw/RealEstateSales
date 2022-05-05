package com.saleface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.house.util.StringUtil;
import com.housemanager.view.HouseAddFram;
import com.housemanager.view.HouseDeleteFram;
import com.housemanager.view.HouseLookFram;
import com.housemanager.view.HouseUpDataFram;
import com.reservation.view.CancelReservation;
import com.reservation.view.Historyhouse;
import com.reservation.view.Reservation;
import com.usermanager.view.UserDeleteFram;
import com.usermanager.view.UserLookFram;

public class SalesMenuFram extends JFrame {
	
	static String loginId = null;
	static String loginName = null;//若是管理员登录，存管理员的名字，否则，存普通用户的名字
	
	//标记用户类别，若是0代表普通用户，1代表管理员，默认是0
	static int flag = 0;
	
	//系统主界面
	public static void BookMenuFram() {
		
		JFrame frame = new JFrame();//主菜单窗口	
		frame.setLayout(null);

		//开6个面板，方便设置位置
		JPanel pan1 = new JPanel();//系统名字
		JPanel pan2 = new JPanel();//商品房信息
		JPanel pan3 = new JPanel();//商品房信息的操作按钮
		JPanel pan4 = new JPanel();//预定管理
		JPanel pan5 = new JPanel();//预定操作按钮
		JPanel pan6 = new JPanel();//用户管理
		JPanel pan7 = new JPanel();//用户管理的操作按钮
		JPanel pan8 = new JPanel();//放登录退出按钮
		JPanel pan9 = new JPanel();//放置图片
		
//		JTextField text = new JTextField();	// 文本框，可删除
//		text.setText("未登录！");//设置提示未登录
		
		JLabel text = new JLabel();//提示框，不可删除
		text.setText("未登录！");//设置提示未登录
		
		//提示框
		JLabel label1 = new JLabel("楼盘销售系统");
		JLabel label2 = new JLabel("商品房信息");
		JLabel label3 = new JLabel("预定管理");
		JLabel label4 = new JLabel("用户管理");
	
		//添加图片
		ImageIcon im = new ImageIcon("images/01.jpg");
		JLabel pac = new JLabel(im);		
		pac.setBounds(355,125, im.getIconWidth(), im.getIconHeight());
		pan9.add(pac);
		pan9.setBounds(355,125, 932, 630);
		
		//按钮
		JButton button1 = new JButton("登录");
		JButton button2 = new JButton("信息查询");
		JButton button3 = new JButton("信息添加");
		JButton button4 = new JButton("信息修改");
		JButton button5 = new JButton("信息删除");
		JButton button6 = new JButton("商品房预定");
		JButton button7 = new JButton("取消预定");
		JButton button8 = new JButton("预定信息查询");
		JButton button9 = new JButton("查询用户");
		JButton button10 = new JButton("删除用户");
		JButton button11 = new JButton("退出");
		
		//设置颜色格式
		Color blacka = new Color(255,255,255);
		Color blackb = new Color(255,255,255);
		Color blackc = new Color(255,255,255);
		Color blackd = new Color(255,255,255);
		
		//设置字体大小对象
		Font font = new Font("宋体",Font.BOLD,80);//标题字体大小		
		Font f = new Font("宋体",Font.BOLD,13);//提示框字体大小
		Font f1 = new Font("宋体",Font.BOLD,13);//text
		
		//设置按钮的大小
		button2.setPreferredSize(new Dimension(200,65));
		button3.setPreferredSize(new Dimension(200,65));
		button4.setPreferredSize(new Dimension(200,65));
		button5.setPreferredSize(new Dimension(200,65));
		button6.setPreferredSize(new Dimension(200,65));
		button7.setPreferredSize(new Dimension(200,65));
		button8.setPreferredSize(new Dimension(200,65));
		button9.setPreferredSize(new Dimension(200,65));
		button10.setPreferredSize(new Dimension(200,65));
		text.setPreferredSize(new Dimension(170,35));//
		
		//设置字体大小
		button2.setFont(f);
		button3.setFont(f);
		button4.setFont(f);
		button5.setFont(f);
		button6.setFont(f);
		button7.setFont(f);
		button8.setFont(f);
		button9.setFont(f);
		button10.setFont(f);
		text.setFont(f1);
		label1.setFont(font);//设置标题字体
		label2.setFont(f);
		label3.setFont(f);
		label4.setFont(f);
		
		//向面板中添加组件
		pan1.add(label1);
		pan1.setBackground(blacka);
		pan1.setBounds(0, 0, 1100, 120);//大标题
		
		//pan8定位在右上角，放登录、退出和显示框
		pan8.add(text);
		pan8.add(button1);
		pan8.add(button11);	
		pan8.setBackground(blacka);
		pan8.setBounds(1100, 0, 190, 120);
        
		pan2.add(label2);
		pan2.setBackground(blackb);
		pan2.setBounds(0, 120, 150, 284);
		
		pan3.add(button2);
		pan3.add(button3);
		pan3.add(button4);
		pan3.add(button5);
		pan3.setBounds(150, 120, 200, 284);
		
		pan4.add(label3);
		pan4.setBackground(blackc);
		pan4.setBounds(0, 404, 150, 213);
	    
		pan5.add(button6);
		pan5.add(button7);
		pan5.add(button8);
		pan5.setBounds(150, 404, 200, 213);
		
		pan6.add(label4);
		pan6.setBackground(blackd);
		pan6.setBounds(0, 617, 150, 142);
	    
		pan7.add(button9);
		pan7.add(button10);
		pan7.setBounds(150, 617, 200, 200);
		
		
		String noLogin = "未登录！";//JVM先查看常量池中有没有，如有，地址指向它，若没有，创建新对象保存
		
		//获取登录后的用户名
		if(StringUtil.isNotEmpty(LogOnFram.userName())) {
		    loginName = LogOnFram.userName();
			text.setText("欢迎您，" + loginName);
		}
		if(StringUtil.isNotEmpty(LogOnFram.adminName())) {
		    loginName = LogOnFram.adminName();
			text.setText("欢迎您，" + loginName);
			flag = 1;
		}
		//获取登录后的id
		if(StringUtil.isNotEmpty(LogOnFram.id())) {
			loginId = LogOnFram.id();
		}
		
		//登录监听
		button1.addActionListener(e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					LogOnFram.LogOnFram();
					frame.dispose();//关闭当前登录界面

				} else {
					JOptionPane.showMessageDialog(null, "请您先退出！");
				}
		});
		
		//各项操作监听,button2--button10
		button2.addActionListener(e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {	//equals()方法如果不重写，就是比较的字符串内容。而'=='比较的是地址
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {
					HouseLookFram.BookLookFram();//商品房信息查询
				}
		});

		button3.addActionListener( e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {
					if(flag == 1) {//如果flag是1，是管理员
						HouseAddFram.bookAddFram();//添加
					} else {
						JOptionPane.showMessageDialog(null, "管理员才可以执行此操作！");
					}				
				}
		});
		button4.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {	
					if(flag == 1) {//如果flag是1，是管理员
						HouseUpDataFram.bookUpDataFram();//修改
					} else {
						JOptionPane.showMessageDialog(null, "管理员才可以执行此操作！");
					}
				}
		});
		button5.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {
					if(flag == 1) {//如果flag是1，是管理员
						HouseDeleteFram.BookDeleteFram();//删除
					} else {
						JOptionPane.showMessageDialog(null, "管理员才可以执行此操作！");
					}
				}
		});
		button6.addActionListener(e-> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {  //预定
					Reservation.Reservation();
				}
		});
		button7.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {  //取消预定
					CancelReservation.BackBook();
				}
		});
		button8.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {	//历史预定
					Historyhouse.Historyhouse();
				}
		});
		button9.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {
					if(flag == 1) {//如果flag是1，是管理员
						UserLookFram.UserLookFram();//用户查询
					} else {
						JOptionPane.showMessageDialog(null, "管理员才可以执行此操作！");
					}
					
				}
		});
		button10.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {
					if(flag == 1) {//如果flag是1，是管理员
						UserDeleteFram.UserDeleteFram();//用户删除
					} else {
						JOptionPane.showMessageDialog(null, "管理员才可以执行此操作！");
					}
				}
		});
		
		button11.addActionListener(e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "请您先登录！");
					return;
				} else {
					frame.dispose();
					LogOnFram.LogOnFram();
//					System.exit(0);
				}
		});
		
		//向容器中添加JPanel面板
		frame.add(pan1);
		frame.add(pan2);
		frame.add(pan3);
		frame.add(pan4);
		frame.add(pan5);
		frame.add(pan6);
		frame.add(pan7);
		frame.add(pan8);
		frame.add(pan9);
		
		//窗口设置
//		frame.setBounds(310, 100, 1300, 800);
		frame.setSize(1300,800);
		frame.setLocationRelativeTo(null);//居中
		frame.setResizable(false);//设置窗口不能扩大
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static String loginName() {
		return loginName;
	}
	public static String loginId() {
		return loginId;
	}
} 