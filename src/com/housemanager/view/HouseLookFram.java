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

		//дһ����¼��ͼ�������
		public static void BookLookFram() {
			
			JFrame frame = new JFrame("");
			
			frame.setLayout(null);
			//��6����壬��������λ��
			JPanel pan1 = new JPanel();//�������ϵͳ�������
			JPanel pan2 = new JPanel();//��������û���ݺ����������
			JPanel pan3 = new JPanel();//��������˺ź��ı������
			JPanel pan4 = new JPanel();//��������������������
			JPanel pan5 = new JPanel();//������ŵ�¼���
			JPanel pan6 = new JPanel();//��Ų�ѯ���
			
			//�ı���
			JTextField textId = new JTextField();//
			JTextField textfloor = new JTextField();//
			JTextField textdeveloper = new JTextField();//
			JTextField textbuilding = new JTextField();
			
			//��ʾ��
			JLabel label1 = new JLabel("�� Ʒ �� �� ѯ");
			JLabel label2 = new JLabel("��  ��   ��  ");
			JLabel label3 = new JLabel("¥       ��  ");
			JLabel label4 = new JLabel("�� �� �� ��  ");
			JLabel label5 = new JLabel("¥       ��  ");
					
			//��ť
			JButton button1 = new JButton("��ѯ");
			
			Font font = new Font("����",Font.BOLD,50);//���������С		
			Font f = new Font("����",Font.BOLD,25);//��ʾ�������С
			Font f2 = new Font("����",Font.BOLD,13);//������������С
			//�����ı���Ĵ�С
			textId.setPreferredSize(new Dimension(200,30));
			textfloor.setPreferredSize(new Dimension(200,30));
			textdeveloper.setPreferredSize(new Dimension(200,30));
			textbuilding.setPreferredSize(new Dimension(200,30));
			button1.setPreferredSize(new Dimension(90,40));
					
			//���ý������������С���������⡢��ʾ��������ı���
			label1.setFont(font);//���ñ�������
			label2.setFont(f);
			textId.setFont(f);
			label3.setFont(f);
			textfloor.setFont(f);
			label4.setFont(f);
			label5.setFont(f);
			textbuilding.setFont(f);
			button1.setFont(f);
			
			//�������������
			pan1.add(label1);
			pan2.add(label2);
			pan2.add(textId);
			pan3.add(label3);
			pan3.add(textfloor);
			pan4.add(label4);
			pan4.add(textdeveloper);
			pan5.add(button1);
			
			//�������λ��
			pan1.setBounds(235,50, 430, 60);
			pan2.setBounds(100,170, 430, 50);
			pan3.setBounds(100,240, 430, 50);
			pan4.setBounds(100,310, 430, 50);		
			pan5.setBounds(250,450,100, 50);//�Ų�ѯ��ť

			String [] columnNames = { "���ƺ�","¥��" ,"¥��", "��������","�Ƿ�Ԥ��"};
			DefaultTableModel model = new DefaultTableModel(columnNames,11);
			JTable jTable = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(jTable);
			//scrollPane.setPreferredSize(new Dimension(30,10));
			scrollPane.setBounds(580,170, 430, 201);
			
			//����
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
					dtm.setRowCount(0);//��ʼ��Ϊ0��
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
								v.add("��");
							} else {
								v.add("��");
							}
							dtm.addRow(v);
						}
					
					}catch(Exception evt) {
						evt.printStackTrace();
					}
			});
					
			//������
			frame.add(pan1);
			frame.add(pan2);
			frame.add(pan3);
			frame.add(pan4);
			frame.add(pan5);			
			frame.add(scrollPane);
			
			//��������
			frame.setBounds(450, 150, 1150, 650);
			frame.setVisible(true);		
		}		
}
