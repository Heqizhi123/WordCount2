package FileCount;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;  


public class MyExGUI {
	
    public MyExGUI()
    {  
    	JFrame f=new JFrame();
		f.setTitle("Ӣ���ı�ͳ�Ʒ���-�˵�");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		
		//���ô��ڵĴ�С��λ��
		f.setSize(500,500);
		f.setLocation(200,200);
		
		Container con=f.getContentPane();//����һ������	
		con.setLayout(new GridLayout(7,1));
		JPanel jp1 =new JPanel();
		JLabel title=new JLabel("Ӣ���ı�ͳ��");
		title.setFont(new Font("����",Font.BOLD, 20));
		jp1.add(title);
		con.add(jp1);
		JPanel jp3 =new JPanel();
		JButton coun=new JButton("��Ƶ�ʼ���");
		coun.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e) 
		    {  
		    	f.dispose();
		    	new Count();   
		    }  
		});  
		jp3.add(coun);
		con.add(jp3);
		JPanel jp4 =new JPanel();
		JButton print=new JButton("���������ļ�");
		print.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e) 
		    {  
		    	f.dispose();
		    	//JOptionPane.showMessageDialog(null, "����ļ��ɹ���");
		    	new Print();   
		    }  
		});  
		jp4.add(print);
		con.add(jp4);
		JPanel jp5 =new JPanel();
		JButton sta=new JButton("ͳ���������ַ���");
		jp5.add(sta);
		sta.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e) 
		    {  
		    	f.dispose();
		    	new Statis();   
		    }  
		});  
		con.add(jp5);
		JPanel jp6 =new JPanel();
		JButton look=new JButton("����ָ���ʵĴ�Ƶ");
		jp6.add(look);
		look.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e) 
		    {  
		    	f.dispose();
		    	new Look();   
		    }  
		});  
		con.add(jp6);
    }
 
}