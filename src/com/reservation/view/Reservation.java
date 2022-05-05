package com.reservation.view;

import java.awt.Dimension;
import java.awt.Font;
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

public class Reservation {

	//дһ����¼��Ԥ����Ʒ���ķ���
	public static void Reservation() {
		
		JFrame frame = new JFrame("");
		frame.setLayout(null);
		//��6����壬��������λ��
		JPanel pan1 = new JPanel();//�������ϵͳ�������
		JPanel pan2 = new JPanel();//��������û���ݺ����������
		JPanel pan5 = new JPanel();//������ŵ�¼���
		
		//�ı���
		JTextField houseid = new JTextField();//
		
		//��ʾ��
		JLabel label1 = new JLabel("Ԥ����Ʒ��");
		JLabel label2 = new JLabel("��Ʒ�����ƺ�  ");
	
		//��ť
		JButton button1 = new JButton("Ԥ��");

		Font font = new Font("����",Font.BOLD,50);//���������С		
		Font f = new Font("����",Font.BOLD,25);//��ʾ�������С
		
		//�����ı���Ĵ�С
		houseid.setPreferredSize(new Dimension(200,30));
		button1.setPreferredSize(new Dimension(90,40));
				
		//���ý������������С���������⡢��ʾ��������ı���
		label1.setFont(font);//���ñ�������
		label2.setFont(f);
		houseid.setFont(f);
		button1.setFont(f);
		
		//�������������
		pan1.add(label1);
		pan2.add(label2);
		pan2.add(houseid);
		pan5.add(button1);
		
		//�������λ��
		pan1.setBounds(140,50, 430, 60);
		pan2.setBounds(130,170, 430, 50);			
		pan5.setBounds(340,300,100, 50);//�Ų�ѯ��ť

		//������
		frame.add(pan1);
		frame.add(pan2);		
		frame.add(pan5);			
		
		//Ԥ����Ʒ������
		button1.addActionListener(e -> {
								
				String houseId = houseid.getText();
				if(StringUtil.isEmpty(houseId)) {
					JOptionPane.showMessageDialog(null, "���ƺŲ���Ϊ�գ�");
					return;
				}

				Connection con = null;
				DbUtil dbutil = new DbUtil();			
				houseDao housedao = new houseDao();
				
				//��ȡ��¼���id
				String loginId = SalesMenuFram.loginId();
				//��ȡ��¼����û���
				String loginName = SalesMenuFram.loginName();
				
				User userMessage = new User();
				userMessage.setUserId(loginId);
				userMessage.setUsername(loginName);
				
				try {
					con = dbutil.getCon();
					
					//�����������ƺ��Ƿ���ڣ��Ƿ�Ԥ��
					ResultSet currentBook = housedao.houseCheck(con, houseId);
					if(currentBook.next()) {//�ѱ�Ԥ��
						if(currentBook.getInt("reservation") == 1) {
							JOptionPane.showMessageDialog(null, "����Ʒ���Ѿ���Ԥ����");
							return;
						}
						String floor = currentBook.getString("floor");
						
						int reservation = housedao.reservation(con,houseId,floor,userMessage);//
						
						if(reservation == 0) {
							JOptionPane.showMessageDialog(null, "Ԥ���ɹ�");
						} else {
							JOptionPane.showMessageDialog(null, "δ�ҵ�����Ʒ������������ȷ�����ƺţ�");
						}	
						
					} else {
						JOptionPane.showMessageDialog(null, "δ�ҵ�����Ʒ������������ȷ�����ƺţ�");
						return;
					}					
					
					
				}catch(Exception evt) {
					evt.printStackTrace();
				}
		});
	
		//��������
		frame.setBounds(500, 150, 750, 550);
		frame.setVisible(true);		
	}		
}
