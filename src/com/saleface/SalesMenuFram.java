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
	static String loginName = null;//���ǹ���Ա��¼�������Ա�����֣����򣬴���ͨ�û�������
	
	//����û��������0������ͨ�û���1�������Ա��Ĭ����0
	static int flag = 0;
	
	//ϵͳ������
	public static void BookMenuFram() {
		
		JFrame frame = new JFrame();//���˵�����	
		frame.setLayout(null);

		//��6����壬��������λ��
		JPanel pan1 = new JPanel();//ϵͳ����
		JPanel pan2 = new JPanel();//��Ʒ����Ϣ
		JPanel pan3 = new JPanel();//��Ʒ����Ϣ�Ĳ�����ť
		JPanel pan4 = new JPanel();//Ԥ������
		JPanel pan5 = new JPanel();//Ԥ��������ť
		JPanel pan6 = new JPanel();//�û�����
		JPanel pan7 = new JPanel();//�û�����Ĳ�����ť
		JPanel pan8 = new JPanel();//�ŵ�¼�˳���ť
		JPanel pan9 = new JPanel();//����ͼƬ
		
//		JTextField text = new JTextField();	// �ı��򣬿�ɾ��
//		text.setText("δ��¼��");//������ʾδ��¼
		
		JLabel text = new JLabel();//��ʾ�򣬲���ɾ��
		text.setText("δ��¼��");//������ʾδ��¼
		
		//��ʾ��
		JLabel label1 = new JLabel("¥������ϵͳ");
		JLabel label2 = new JLabel("��Ʒ����Ϣ");
		JLabel label3 = new JLabel("Ԥ������");
		JLabel label4 = new JLabel("�û�����");
	
		//���ͼƬ
		ImageIcon im = new ImageIcon("images/01.jpg");
		JLabel pac = new JLabel(im);		
		pac.setBounds(355,125, im.getIconWidth(), im.getIconHeight());
		pan9.add(pac);
		pan9.setBounds(355,125, 932, 630);
		
		//��ť
		JButton button1 = new JButton("��¼");
		JButton button2 = new JButton("��Ϣ��ѯ");
		JButton button3 = new JButton("��Ϣ���");
		JButton button4 = new JButton("��Ϣ�޸�");
		JButton button5 = new JButton("��Ϣɾ��");
		JButton button6 = new JButton("��Ʒ��Ԥ��");
		JButton button7 = new JButton("ȡ��Ԥ��");
		JButton button8 = new JButton("Ԥ����Ϣ��ѯ");
		JButton button9 = new JButton("��ѯ�û�");
		JButton button10 = new JButton("ɾ���û�");
		JButton button11 = new JButton("�˳�");
		
		//������ɫ��ʽ
		Color blacka = new Color(255,255,255);
		Color blackb = new Color(255,255,255);
		Color blackc = new Color(255,255,255);
		Color blackd = new Color(255,255,255);
		
		//���������С����
		Font font = new Font("����",Font.BOLD,80);//���������С		
		Font f = new Font("����",Font.BOLD,13);//��ʾ�������С
		Font f1 = new Font("����",Font.BOLD,13);//text
		
		//���ð�ť�Ĵ�С
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
		
		//���������С
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
		label1.setFont(font);//���ñ�������
		label2.setFont(f);
		label3.setFont(f);
		label4.setFont(f);
		
		//�������������
		pan1.add(label1);
		pan1.setBackground(blacka);
		pan1.setBounds(0, 0, 1100, 120);//�����
		
		//pan8��λ�����Ͻǣ��ŵ�¼���˳�����ʾ��
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
		
		
		String noLogin = "δ��¼��";//JVM�Ȳ鿴����������û�У����У���ַָ��������û�У������¶��󱣴�
		
		//��ȡ��¼����û���
		if(StringUtil.isNotEmpty(LogOnFram.userName())) {
		    loginName = LogOnFram.userName();
			text.setText("��ӭ����" + loginName);
		}
		if(StringUtil.isNotEmpty(LogOnFram.adminName())) {
		    loginName = LogOnFram.adminName();
			text.setText("��ӭ����" + loginName);
			flag = 1;
		}
		//��ȡ��¼���id
		if(StringUtil.isNotEmpty(LogOnFram.id())) {
			loginId = LogOnFram.id();
		}
		
		//��¼����
		button1.addActionListener(e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					LogOnFram.LogOnFram();
					frame.dispose();//�رյ�ǰ��¼����

				} else {
					JOptionPane.showMessageDialog(null, "�������˳���");
				}
		});
		
		//�����������,button2--button10
		button2.addActionListener(e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {	//equals()�����������д�����ǱȽϵ��ַ������ݡ���'=='�Ƚϵ��ǵ�ַ
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {
					HouseLookFram.BookLookFram();//��Ʒ����Ϣ��ѯ
				}
		});

		button3.addActionListener( e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {
					if(flag == 1) {//���flag��1���ǹ���Ա
						HouseAddFram.bookAddFram();//���
					} else {
						JOptionPane.showMessageDialog(null, "����Ա�ſ���ִ�д˲�����");
					}				
				}
		});
		button4.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {	
					if(flag == 1) {//���flag��1���ǹ���Ա
						HouseUpDataFram.bookUpDataFram();//�޸�
					} else {
						JOptionPane.showMessageDialog(null, "����Ա�ſ���ִ�д˲�����");
					}
				}
		});
		button5.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {
					if(flag == 1) {//���flag��1���ǹ���Ա
						HouseDeleteFram.BookDeleteFram();//ɾ��
					} else {
						JOptionPane.showMessageDialog(null, "����Ա�ſ���ִ�д˲�����");
					}
				}
		});
		button6.addActionListener(e-> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {  //Ԥ��
					Reservation.Reservation();
				}
		});
		button7.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {  //ȡ��Ԥ��
					CancelReservation.BackBook();
				}
		});
		button8.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {	//��ʷԤ��
					Historyhouse.Historyhouse();
				}
		});
		button9.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {
					if(flag == 1) {//���flag��1���ǹ���Ա
						UserLookFram.UserLookFram();//�û���ѯ
					} else {
						JOptionPane.showMessageDialog(null, "����Ա�ſ���ִ�д˲�����");
					}
					
				}
		});
		button10.addActionListener(e ->  {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {
					if(flag == 1) {//���flag��1���ǹ���Ա
						UserDeleteFram.UserDeleteFram();//�û�ɾ��
					} else {
						JOptionPane.showMessageDialog(null, "����Ա�ſ���ִ�д˲�����");
					}
				}
		});
		
		button11.addActionListener(e -> {
				String getText = text.getText().toString();//1
				if(getText.equals(noLogin)) {
					JOptionPane.showMessageDialog(null, "�����ȵ�¼��");
					return;
				} else {
					frame.dispose();
					LogOnFram.LogOnFram();
//					System.exit(0);
				}
		});
		
		//�����������JPanel���
		frame.add(pan1);
		frame.add(pan2);
		frame.add(pan3);
		frame.add(pan4);
		frame.add(pan5);
		frame.add(pan6);
		frame.add(pan7);
		frame.add(pan8);
		frame.add(pan9);
		
		//��������
//		frame.setBounds(310, 100, 1300, 800);
		frame.setSize(1300,800);
		frame.setLocationRelativeTo(null);//����
		frame.setResizable(false);//���ô��ڲ�������
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