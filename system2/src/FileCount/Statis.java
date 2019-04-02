package FileCount;

import java.util.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Statis 
{
	
	JTextArea text = new JTextArea();
	public Statis()
	{
		JFrame sta=new JFrame();
		sta.setTitle("Ӣ���ı�ͳ�Ʒ���-ͳ���������ַ���");
		sta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sta.setExtendedState(JFrame.MAXIMIZED_BOTH);
		sta.setVisible(true);
		sta.setSize(500,500);
		sta.setLocation(200,200);
		Container conS=sta.getContentPane();//����һ������	
		conS.setLayout(new GridLayout(6,1));
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel file=new JLabel("�ļ�����");
		panel.add(file);
		TextField file_=new TextField(20);
		panel.add(file_);
		conS.add(panel);
		
		text = new JTextArea(80,40);
		conS.add(text);
		JButton Look=new JButton("ͳ��"); 
		panel2.add(Look);
		JButton retur=new JButton("����"); 
		panel2.add(retur);
		conS.add(panel2);
		Look.addActionListener(new ActionListener() 
		{  
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	int line=0;
		    	int wordCount=0;
		    	
		    	String str=null;//����һ���ַ������ͱ���str
				StringBuffer sb1=  new  StringBuffer();
				try {
					String file1 =file_.getText();
					BufferedReader in = new BufferedReader(new FileReader(file1));
			        while ((str = in.readLine())!= null) 
			        {
			        	str = str.toLowerCase();
			        	sb1.append(str);
			        	line++;
			        }
			        text.append("�ļ�����  ��  "+line  +"\n");
			        
		            in.close();
		            String str2 = sb1.toString();
					String[] wordsArr1 = str2.split("[^a-zA-Z]");  //���˳�ֻ������ĸ��  
					for (String word : wordsArr1) 
					{  
						wordCount++;
					} 
					text.append("�ַ���  ��"+ wordCount  + "\n");
				} catch (IOException e1) 
				{
			       	e1.printStackTrace();//printStackTrace()�����Ǵ�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
				}
				
		    }
		});
		
		retur.addActionListener(new ActionListener() 
		{  
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	new MyExGUI();
		    }
		});
		
	}


}
