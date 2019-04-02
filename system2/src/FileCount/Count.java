package FileCount;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
import java.util.Map.Entry;


public class Count extends JFrame
{
	JTextArea text = new JTextArea();
	
	public Count()
	{
		JFrame f2=new JFrame();
		f2.setTitle("英文文本统计分析-高频词统计");
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f2.setVisible(true);
		
		//设置窗口的大小和位置
		f2.setSize(500,500);
		f2.setLocation(200,200);
		Container con2=f2.getContentPane();//生成一个容器	
		con2.setLayout(new GridLayout(4,1));
		JTextField file = new JTextField(20);
		JTextField num = new JTextField(20);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		panel.add(new JLabel("输入文件名"));
		panel.add(file);
		JPanel panel1 = new JPanel();
		panel.add(new JLabel("高频词个数"));
		panel.add(num);
		con2.add(panel);
		text = new JTextArea(80,40);
		//text.setBackground(Color.blue);
		con2.add(text);
		JButton print=new JButton("输出"); 
		panel1.add(print);
		//String na = file.getText();
	//	int number = Integer.parseInt(num.getText());
		//JPanel panel2 = new JPanel();
		JButton retur=new JButton("返回"); 
		panel1.add(retur);
		con2.add(panel1);
		
		
		retur.addActionListener(new ActionListener() 
		{  
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	new MyExGUI();
		    }
		});
		 
		print.addActionListener(new ActionListener() 
		{  
		    public void actionPerformed(ActionEvent arg0) 
		    {  
		    	//text.append(file.getText());
		    	String str=null;//定义一个字符串类型变量str
				StringBuffer sb1=  new  StringBuffer();
				try {
					String file1 =file.getText();
					BufferedReader in = new BufferedReader(new FileReader(file1));
			        while ((str = in.readLine())!= null) 
			        {
			        	str = str.toLowerCase();
			        	sb1.append(str);
			        }
		            in.close();
				} catch (IOException e1) 
				{//当try代码块有异常时转到catch代码块
			       	text.append("读取有误");
			       	System.out.printf("error!");
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
				
				Set<java.util.Map.Entry<String, Integer>> mapEntries = hashMap.entrySet();  
				 List<Entry<String,Integer>> aList = new LinkedList<Entry<String,Integer>>(mapEntries); 

				 Collections.sort(aList, new Comparator<Entry<String,Integer>>() { 

				 public int compare(Entry<String, Integer> ele1, 
				 Entry<String, Integer> ele2) { 

				 return ele2.getValue().compareTo(ele1.getValue()); 
				 } 
				 });  
				 Map<String,Integer> aMap2 = new LinkedHashMap<String, Integer>(); 
				 for(Entry<String,Integer> entry: aList) { 
				 aMap2.put(entry.getKey(), entry.getValue()); 
				 } 
				 count = 0;
			
				
		    	for(Entry<String,Integer> entry : aMap2.entrySet()) 
				 { 
		    		 
		    				 
		    		text.append("单词： " +entry.getKey() + "      次数   ：" + entry.getValue()+"\r\n"); 
					count=count+1;
					if(count==Integer.parseInt(num.getText()))
						break;
				}
			 }
		    
		}); 
			
	}
}
