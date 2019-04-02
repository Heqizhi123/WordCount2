package FileCount;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Look 
{
	JTextArea text = new JTextArea();
	
	public Look()
	{
		JFrame look=new JFrame();
		look.setTitle("Ӣ���ı�ͳ�Ʒ���-���ҵ���");
		look.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		look.setExtendedState(JFrame.MAXIMIZED_BOTH);
		look.setVisible(true);
		
		//���ô��ڵĴ�С��λ��
		look.setSize(500,500);
		look.setLocation(200,200);
		Container conP=look.getContentPane();//����һ������	
		conP.setLayout(new GridLayout(6,1));
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel file=new JLabel("�ļ�����");
		panel.add(file);
		TextField file_=new TextField(20);
		panel.add(file_);
		conP.add(panel);
		JLabel word = new JLabel("�鿴���ʣ�");
		panel1.add(word);
		TextField word_=new TextField(20);
		panel1.add(word_);
		conP.add(panel1);
		text = new JTextArea(80,40);
		//text.setBackground(Color.blue);
		conP.add(text);
		JButton Look=new JButton("�鿴"); 
		panel2.add(Look);
		JButton retur=new JButton("����"); 
		panel2.add(retur);
		conP.add(panel2);
		
		Look.addActionListener(new ActionListener() 
		{  
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	String str=null;//����һ���ַ������ͱ���str
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
				{//��try��������쳣ʱת��catch�����
			       //	text.append("��ȡ����");
			       	//System.out.printf("error!");
			       	e1.printStackTrace();//printStackTrace()�����Ǵ�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
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
				List<String> lists = new ArrayList<String>();  //�洢���˺󵥴ʵ��б�  
				String str2 = sb1.toString();
				String[] wordsArr1 = str2.split("[^a-zA-Z]");  //���˳�ֻ������ĸ��  
				for (String word : wordsArr1) {  
					if(word.length() != 0){  //ȥ������Ϊ0���� 
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
					if(word_.getText().equals(s2.toString()))
					{
						text.append("���ʣ�"+s2.toString()+"            ���ִ�����"+ts.get(s2));
						break;
					}	
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
