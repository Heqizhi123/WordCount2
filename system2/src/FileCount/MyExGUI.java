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
		f.setTitle("英文文本统计分析-菜单");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		
		//设置窗口的大小和位置
		f.setSize(500,500);
		f.setLocation(200,200);
		
		Container con=f.getContentPane();//生成一个容器	
		con.setLayout(new GridLayout(7,1));
		JPanel jp1 =new JPanel();
		JLabel title=new JLabel("英文文本统计");
		title.setFont(new Font("宋体",Font.BOLD, 20));
		jp1.add(title);
		con.add(jp1);
		JPanel jp3 =new JPanel();
		JButton coun=new JButton("高频词计数");
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
		JButton print=new JButton("结果输出到文件");
		print.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e) 
		    {  
		    	f.dispose();
		    	//JOptionPane.showMessageDialog(null, "输出文件成功！");
		    	new Print();   
		    }  
		});  
		jp4.add(print);
		con.add(jp4);
		JPanel jp5 =new JPanel();
		JButton sta=new JButton("统计行数与字符数");
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
		JButton look=new JButton("查找指定词的词频");
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