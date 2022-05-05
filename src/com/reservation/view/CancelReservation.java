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

	//дһ����¼��ȡ��Ԥ���ķ���
	public static void BackBook() {
		
		JFrame frame = new JFrame("");
		frame.setLayout(null);
		//��3����壬��������λ��
		JPanel pan1 = new JPanel();//�������ϵͳ�������
		JPanel pan2 = new JPanel();//��������û���ݺ����������
		JPanel pan5 = new JPanel();//������ŵ�¼���
		
		//�ı���
		JTextField houseid = new JTextField();
		
		//��ʾ��
		JLabel label1 = new JLabel("ȡ �� �� Ʒ �� Ԥ ��");
		JLabel label2 = new JLabel("��Ʒ�����ƺ�  ");
	
		//��ť
		JButton button1 = new JButton("ȡ��");

		Font font = new Font("����",Font.BOLD,50);//���������С		
		Font f = new Font("����",Font.BOLD,13);//��ʾ�������С
		
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
		button1.addActionListener(e ->  {
								
				String houseId = houseid.getText();
				if(StringUtil.isEmpty(houseId)) {
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�");
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
					
					//����������Ʒ�����ƺ��Ƿ���ڣ��Ƿ�Ԥ��
					ResultSet currenthouse = housedao.houseCheck(con, houseId);
					if(currenthouse.next()) {//��Ԥ����Ϣ����
						if(currenthouse.getInt("reservation") == 1) {
							JOptionPane.showMessageDialog(null, "�÷����ѱ�Ԥ������鿴������");
							return;
						}
						String houseid2 = currenthouse.getString("houseId");
						
						int reservation = housedao.back(con,houseId,userMessage);//
						
						if(reservation == 0) {
							JOptionPane.showMessageDialog(null, "ȡ��Ԥ���ɹ�");
						} else {
							JOptionPane.showMessageDialog(null, "ȡ��Ԥ��ʧ�ܣ�");
						}
					} else {
						JOptionPane.showMessageDialog(null, "δ�ҵ��÷�����Ϣ����������ȷ�����ƺ�");
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
