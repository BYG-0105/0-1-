import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame
{
	JFrame File = new JFrame(); //ѡ�������ļ�����
	int beibaosize;
	int types;
	int[] w = new int [100];
	int[] v = new int [100];
	double[] c = new double [100];
	int wvsum;
	int fileId = -1;
	//��������ֵ
	public static final int TEXTAREA_ROWS = 200;
	public static final int TEXTAREA_COLUMNS = 200;
	/* �ı��򣬷ֱ��������Ʒ����������ֵ*/
    JTextField choice; //�û�ѡ��
    
	
	JButton Gbutton;//��ť���鿴0-1����������
	JTextArea Tweight;//�ı��������������Ʒ����
	JTextArea Tvalue;//�ı��������������Ʒ��ֵ
	JTextArea Tresult;//�ı��������������Ʒ��ֵ
    ArrayList<Goods> list = new ArrayList<Goods>();;//��Ŵ��ļ���ȡ����Ʒ����
    
  public Frame() 
   { 
	  
	
	  
	  


	   JLabel Jwv = new JLabel("��Ʒ����",JLabel.CENTER);
	   JLabel Jvalue = new JLabel("��Ʒ��ֵ",JLabel.CENTER);
	   JLabel item1 = new JLabel("<html><body> 1.ѡ�������ļ�<br> 2.̰���㷨<br> 3.�����㷨<br> 4.��̬�滮�㷨<br> </body></html>",JLabel.CENTER);
	   JLabel item2 = new JLabel("<html><body>5.����ɢ��ͼ<br> 6.�������Ƚ��зǵ�������<br> 7.���ļ���ʽ������</body></html>",JLabel.CENTER);
	   /*
	   JLabel huisu = new JLabel("",JLabel.CENTER);
	   JLabel dtgh = new JLabel("",JLabel.CENTER);
	   JLabel paint = new JLabel("",JLabel.CENTER);
	   JLabel wv = new JLabel("",JLabel.CENTER);
	   JLabel txt = new JLabel("",JLabel.CENTER);

*/


       //�������弰��������
	   item1.setFont(new Font("����",Font.BOLD,15));
	   item1.setForeground(Color.BLUE);
	   
	   Jwv.setFont(new Font("����",Font.BOLD,15));
	   Jwv.setForeground(Color.BLUE);
	   
	   //Jvalue.setFont(new Font("����",Font.BOLD,15));
	   //Jvalue.setForeground(Color.BLUE);
	   
	   item2.setFont(new Font("����",Font.BOLD,15));
	   item2.setForeground(Color.BLUE);
	   /*
	   filenames.setPreferredSize(new Dimension(100, 200));
	   
	   tanxin.setFont(new Font("����",Font.BOLD,15));
	   tanxin.setForeground(Color.BLUE);
	   
	   huisu.setFont(new Font("����",Font.BOLD,15));
	   huisu.setForeground(Color.BLUE);
	   
	   dtgh.setFont(new Font("����",Font.BOLD,15));
	   dtgh.setForeground(Color.BLUE);
	   
	   paint.setFont(new Font("����",Font.BOLD,15));
	   paint.setForeground(Color.BLUE);
	   
	   wv.setFont(new Font("����",Font.BOLD,15));
	   wv.setForeground(Color.BLUE);
*/
	   Tweight = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);//��������������
	   Tvalue = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);//��������������
	   Tresult = new JTextArea(100,1000);//��������������
		add(Tweight,BorderLayout.SOUTH);//�߿򲼾ֹ�����
		add(Tvalue,BorderLayout.SOUTH);//�߿򲼾ֹ�����
		//add(Tresult,BorderLayout.SOUTH);//�߿򲼾ֹ�����

		//���ı�������ӹ�����
		JScrollPane jspw = new JScrollPane(Tweight);
		//���þ��δ�С.��������Ϊ(�������ϽǺ�����x,�������Ͻ�������y�����γ��ȣ����ο��)
		jspw.setBounds(13, 10, 350, 340);
		//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
		jspw.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JScrollPane jspv = new JScrollPane();
		jspv.setViewportView(Tvalue);
		//���þ��δ�С.��������Ϊ(�������ϽǺ�����x,�������Ͻ�������y�����γ��ȣ����ο��)
		jspv.setBounds(13, 10, 350, 340);
		//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
		jspv.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		

	   choice = new JTextField(10);//���������Ŀյ�JTextField����
	   choice.setFont(new Font("����",Font.BOLD,15));//�����ı����е�����
      
	  //���Ӱ�ť
	   Gbutton=new JButton("ȷ��");
	   Gbutton.setBackground(Color.pink);//���ð�ť����ɫ
		//����������
		Gbutton.addActionListener(new ActionListener()
	       {      
	           public void actionPerformed(ActionEvent event)
	           {    
	        	  
	        	  int select = Integer.parseInt(choice.getText());//���ı����л�ȡ�����ֵ
	        	  if(select == 1)
	        	  {
	        		 Text(); 
	        	  }
	        	  else if(select == 2)
	        	  {
	        		  Algorithm a = new Algorithm();
	        		  double[] x = a.Greedy(w,v,types,beibaosize);
	        	  }
	        	  else if(select == 3)
	        	  {
	        		  Algorithm a = new Algorithm();
	        		  int[] x = a.Backtracking(w,v,types,beibaosize);
	        	  }
	        	  else if(select == 4)
	        	  {
	        		  Algorithm a = new Algorithm();
	        		  int[] x = a.Dynamic(w,v,types,beibaosize);
	        	  }
	        	  else if(select == 5)
	        	  {
	        		  
	        	  }
	        	  else if(select == 6)
	        	  {
	        		  for(int i = 0;i < types;i++)
	        		  {
	        			  c[i] =(double)v[i]/(double)w[i];
	        		  }
	        		  Algorithm a = new Algorithm();
	        		  c = a.QuickSort(c, 0, types);
	        		  for(int i = 0;i < types;i++)
	        		  {
	        			  Tresult.append("��"+(i+1)+"����Ʒ��������Ϊ��"+c[i]+"\n");
	        		  }
	        	  }
	        	  else if(select == 7)
	        	  {
	        		  
	        	  }
	        	  else
	        	  {
	        		  JOptionPane.showMessageDialog(null,"������ѡ������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
	                  //��������  
	                  choice.setText("");
	        	  }
	           }
	       });
		
	   JPanel area=new JPanel();//�������
	    area.setBackground(Color.CYAN);//�������ı�����ɫ
		area.setLayout(new GridLayout(6,2));//���񲼾֣���������������
		//��������������
		area.add(item1);
		area.add(item2);

		//area.add(filenames);
		/*
		area.add(tanxin);
		area.add(huisu);
		area.add(dtgh);
		area.add(paint);
		area.add(wv);
		*/		

		area.add(Jwv);
		area.add(Jvalue);
		area.add(jspw);
		area.add(jspv);
		area.add(Tweight);
		area.add(Tvalue);
		area.add(choice);
		area.add(Gbutton);//���������Ӱ�ť
		//area.add(Tresult);
		
		add(area,BorderLayout.CENTER);//�߿򲼾ֹ�����
			
		
   }

	  public void Text()
	   {
			
		   JButton Gbutton;//��ť���鿴�����ļ���Ϣ
		   
		   JLabel item1 = new JLabel("0-1��������",JLabel.CENTER);
		   JLabel item2 = new JLabel("ѡ����Ҫ��ȡ���ݵ��ļ�������10���ļ��� ",JLabel.CENTER);
	        //�������弰��������
		   item1.setFont(new Font("����",Font.BOLD,23));
		   item1.setForeground(Color.BLUE);
		   item2.setFont(new Font("����",Font.BOLD,22));
		   item2.setForeground(Color.BLUE);
		   
		   JRadioButton jrb1=new JRadioButton("beibao0");  
		   JRadioButton jrb2=new JRadioButton("beibao1"); 
		   JRadioButton jrb3=new JRadioButton("beibao2");  
		   JRadioButton jrb4=new JRadioButton("beibao3");
		   JRadioButton jrb5=new JRadioButton("beibao4");  
		   JRadioButton jrb6=new JRadioButton("beibao5");
		   JRadioButton jrb7=new JRadioButton("beibao6");  
		   JRadioButton jrb8=new JRadioButton("beibao7");
		   JRadioButton jrb9=new JRadioButton("beibao8");  
		   JRadioButton jrb10=new JRadioButton("beibao9");
		   
		   jrb1.setFont(new Font("����",Font.BOLD,22));
		   jrb2.setFont(new Font("����",Font.BOLD,22));
		   jrb3.setFont(new Font("����",Font.BOLD,22));
		   jrb4.setFont(new Font("����",Font.BOLD,22));
		   jrb5.setFont(new Font("����",Font.BOLD,22));
		   jrb6.setFont(new Font("����",Font.BOLD,22));
		   jrb7.setFont(new Font("����",Font.BOLD,22));
		   jrb8.setFont(new Font("����",Font.BOLD,22));
		   jrb9.setFont(new Font("����",Font.BOLD,22));
		   jrb10.setFont(new Font("����",Font.BOLD,22));


		   
		   ButtonGroup bg=new ButtonGroup(); 
		   
		   bg.add(jrb1);
		   bg.add(jrb2);
		   bg.add(jrb3);
		   bg.add(jrb4);
		   bg.add(jrb5);
		   bg.add(jrb6);
		   bg.add(jrb7);
		   bg.add(jrb8);
		   bg.add(jrb9);
		   bg.add(jrb10);
		   jrb1.setSelected(true);  
		   
	       JPanel jrbarea=new JPanel();//�������
	       jrbarea.add(jrb1);
	       jrbarea.add(jrb2);
	       jrbarea.add(jrb3);
	       jrbarea.add(jrb4);
	       jrbarea.add(jrb5);
	       jrbarea.add(jrb6);
	       jrbarea.add(jrb7);
	       jrbarea.add(jrb8);
	       jrbarea.add(jrb9);
	       jrbarea.add(jrb10);
	      // jrbarea.setLayout(new GridLayout(10,1));//���񲼾֣���������������


	      
	       JPanel area=new JPanel();//�������
		   area.setBackground(Color.CYAN);//�������ı�����ɫ
			area.setLayout(new GridLayout(4,1));//���񲼾֣���������������
			//��������������
			area.add(item1);
			area.add(item2);
		    area.add(jrbarea);

			File.add(area,BorderLayout.CENTER);//�߿򲼾ֹ�����
			
			
			//���Ӱ�ť
			Gbutton=new JButton("ȷ��");
			Gbutton.setBackground(Color.pink);//���ð�ť����ɫ
			area.add(Gbutton);//���������Ӱ�ť
			//����������
			//File.add(area);
			Gbutton.addActionListener(new ActionListener()
		       {      
		           public void actionPerformed(ActionEvent event)
		           { 
		        	  if(jrb1.isSelected())
		        	  {
		        		  fileId = 1;
		        	  }
		        	  else if(jrb2.isSelected())
		        	  {
		        		  fileId = 2;
		        	  }
		        	  else if(jrb3.isSelected())
		        	  {
		        		  fileId = 3;
		        	  }
		        	  else if(jrb4.isSelected())
		        	  {
		        		  fileId = 4;
		        	  }
		        	  else if(jrb5.isSelected())
		        	  {
		        		  fileId = 5;
		        	  }
		        	  else if(jrb6.isSelected())
		        	  {
		        		  fileId = 6;
		        	  }
		        	  else if(jrb7.isSelected())
		        	  {
		        		  fileId = 7;
		        	  }
		        	  else if(jrb8.isSelected())
		        	  {
		        		  fileId = 8;
		        	  }
		        	  else if(jrb9.isSelected())
		        	  {
		        		  fileId = 9;
		        	  }
		        	  else if(jrb10.isSelected())
		        	  {
		        		  fileId = 10;
		        	  }
		        	 fileId--;
		        	  File.dispose(); //ѡ�������ļ�����ر�
		        	  
		        	  
		        	  

	        	     int Gweight;
		        	 double Gvalue;
		        		  String filePath = "D:\\2021-2022\\������\\������̾���\\Git\\0-1\\0-1-knapsack\\res\\beibao"+fileId+".in";
		        	        FileInputStream fin = null;
							try {
								fin = new FileInputStream(filePath);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        	        InputStreamReader reader = new InputStreamReader(fin);
		        	        BufferedReader buffReader = new BufferedReader(reader);
		        	       
						
		        		  String line;
		        		  int flag = 0;
		        		  wvsum = 0;
							
								try {
									while((line=buffReader.readLine())!= null)
									{
										String stringArray[] = line.split(" ");
										if(flag == 0)
										{
											 beibaosize = Integer.parseInt(stringArray[0]);
											 types = Integer.parseInt(stringArray[1]);
											 flag = 1;
										}
										else
										{
										  Gweight = Integer.parseInt(stringArray[0]);
										  Gvalue = Integer.parseInt(stringArray[1]);
										  w[wvsum] = Integer.parseInt(stringArray[0]);
										  v[wvsum] = Integer.parseInt(stringArray[1]);
										  wvsum++;
										  Goods goods = new Goods(Gweight,Gvalue);
										  list.add(goods);
										}
										 
									}
								} catch (NumberFormatException | IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
							try {
								reader.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
		        		  for (Goods tmp : list)
		        		   { 
		        			 //���������ı�׷�ӵ��ı����������ı���β��
		        			  Tweight.append(" ����: " +tmp.getWeight()+"\n");
		        			  Tvalue.append(" ��ֵ: " +tmp.getValue()+"\n");
		        	       } 
		        		  
		           }
		       });
			
			File.setTitle("0-1��������");//��������
			File.setBounds(190,60, 600,350);//����λ�ü���С
			File.setVisible(true);
			File.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ر�
			
			
			
	   }


}