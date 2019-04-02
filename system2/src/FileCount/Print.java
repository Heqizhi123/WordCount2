package FileCount;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Print 
{
	static TextField result_=new TextField(20);
	
	public Print()
	{
		JFrame f2=new JFrame();
		f2.setTitle("英文文本统计分析-结果输出到文件");
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f2.setVisible(true);
		
		//设置窗口的大小和位置
		f2.setSize(500,500);
		f2.setLocation(200,200);
		Container conP=f2.getContentPane();//生成一个容器	
		conP.setLayout(new GridLayout(6,1));
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel file=new JLabel("已有文件名：");
		panel.add(file);
		TextField file_=new TextField(20);
		panel.add(file_);
		conP.add(panel);
		JLabel result = new JLabel("结果文件名：");
		panel1.add(result);
		
		panel1.add(result_);
		conP.add(panel1);
		JButton print=new JButton("输出"); 
		panel2.add(print);
		JButton retur=new JButton("返回"); 
		panel2.add(retur);
		conP.add(panel2);
		 
		print.addActionListener(new ActionListener() 
		{  
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	String str=null;//定义一个字符串类型变量str
				StringBuffer sb1=  new  StringBuffer();
				try {
					String file1 =file_.getText();
					BufferedReader in = new BufferedReader(new FileReader(file1));
			        while ((str = in.readLine())!= null) 
			        {
			        	str = str.toLowerCase();
			        	sb1.append(str);
			        }
		            in.close();
				} catch (IOException e1) 
				{//当try代码块有异常时转到catch代码块
			       //	text.append("读取有误");
			       	//System.out.printf("error!");
			       	e1.printStackTrace();//printStackTrace()方法是打印异常信息在程序中出错的位置及原因
				}
				TreeMap<StringBuffer,String > ts = new TreeMap<StringBuffer,String>
				(new Comparator<StringBuffer>(){
					@Override
					public int compare(StringBuffer sb1,StringBuffer sb2 ) {
					
						if(sb1==null&&sb2==null) {
							return 1;
						}
						String str1 = sb1.toString();
						String str2 = sb2.toString();
						if (str1.compareTo(str2)>0) {
							return 1;		
						}
						else if (str1.compareTo(str2)<0) {
							return -1;
						}
						else
						{
							return 0;
						}
					}
				});
				List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表  
				String str2 = sb1.toString();
				String[] wordsArr1 = str2.split("[^a-zA-Z]");  //过滤出只含有字母的  
				for (String word : wordsArr1) {  
					if(word.length() != 0){  //去除长度为0的行 
						lists.add(word);  
					} 
				}  
				int count=1; 
				Map<String, Integer> hashMap = new HashMap<String, Integer>();
				for(String st: lists) 
				{
					StringBuffer s2 = new StringBuffer( st);
					
					if (ts.containsKey(s2)) {
						count=Integer.parseInt(Integer.toString(count));;
						count++;
						ts.put(s2,Integer.toString(count));
						hashMap.put(st,count);
					}
					else {
						count=1;
						ts.put(s2, Integer.toString(count));
						hashMap.put(st,count);
					}	 
				}
				
				Set<StringBuffer> ks1 = ts.keySet();
				for(StringBuffer s2:ks1) 
				{
			
					try {
						setFile ("单词："+s2.toString()+"            出现次数："+ts.get(s2)+"\r\n");
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				//System.out.println("文件成功读入到指定路径下");
				
		    	JOptionPane.showMessageDialog(null, "结果已成功输出到文件!");  
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
	public static void setFile (String s) throws IOException { //文件写入函数
		//String file1 = result_.getText();
		byte[] bs = s.getBytes();//定义字节数组用来当作缓冲区
		FileOutputStream fos=new FileOutputStream(result_.getText(),true);
		 try {
			 fos.write(bs);
			 
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }//从缓冲区字节数组中以字节流形式取出

		 fos.close();//关闭读取流
		 
		 File file=new File(result_.getText());//创建文件对象
		 if(file.exists()){//if语句的条件，调用exists方法判断文件是否存在
		 }
		 else{//否则
			 System.out.println("输出文件不存在");//输出文件不存在
		 }
	}

}
