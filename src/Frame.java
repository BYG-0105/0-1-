import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
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
	int[] w = new int [1000];
	int[] v = new int [1000];
	double[][] c = new double [1000][2];
	int wvsum;
	int fileId = -1;
	int dataname = 0;

	/* �ı��򣬷ֱ��������Ʒ����������ֵ*/
    JTextField choice; //�û�ѡ��
    
	
	JButton Gbutton;//��ť���鿴0-1����������
	JTextArea Twv;//�ı��������������Ʒ����,��Ʒ��ֵ
	JTextArea Tresult;//�ı��������������Ʒ��ֵ
    ArrayList<Goods> list = new ArrayList<Goods>();;//��Ŵ��ļ���ȡ����Ʒ����
    
  public Frame() 
   { 
	  
	
	  
	  


	 
	   JLabel item1 = new JLabel("<html><body>1.ѡ�������ļ� <br> 2.̰���㷨<br> 3.�����㷨<br> 4.��̬�滮�㷨<br>5.����ɢ��ͼ<br> 6.�������Ƚ��зǵ�������<br> 7.���ļ���ʽ������</body></html>",JLabel.CENTER);
	   JLabel item2 = new JLabel("                          ",JLabel.CENTER);
	   JLabel item3 = new JLabel("�������ѡ��",JLabel.CENTER);

	   /*
	   JLabel huisu = new JLabel("",JLabel.CENTER);
	   JLabel dtgh = new JLabel("",JLabel.CENTER);
	   JLabel paint = new JLabel("",JLabel.CENTER);
	   JLabel wv = new JLabel("",JLabel.CENTER);
	   JLabel txt = new JLabel("",JLabel.CENTER);

*/


       //�������弰��������
	   item1.setFont(new Font("����",Font.BOLD,18));
	   item1.setForeground(Color.BLUE);
	   item2.setFont(new Font("����",Font.BOLD,20));
	   item2.setForeground(Color.BLUE);
	   item3.setFont(new Font("����",Font.BOLD,18));
	   item3.setForeground(Color.BLUE);
	   

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
	   Twv = new JTextArea(20,30);//��������������
	   Tresult = new JTextArea(20,30);//��������������
	   Twv.setEditable(false);
	   Tresult.setEditable(false);
		add(Twv,BorderLayout.SOUTH);//�߿򲼾ֹ�����
		add(Tresult,BorderLayout.SOUTH);//�߿򲼾ֹ�����

		//���ı�������ӹ�����
		JScrollPane jspwv = new JScrollPane(Twv);
		//���þ��δ�С.��������Ϊ(�������ϽǺ�����x,�������Ͻ�������y�����γ��ȣ����ο��)
		//jspw.setBounds(13, 10, 350, 340);
		//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
		//jspw.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JScrollPane jspr = new JScrollPane(Tresult);
		//jspv.setSize(100,100);
		//jspv.setViewportView(Tvalue);
		//���þ��δ�С.��������Ϊ(�������ϽǺ�����x,�������Ͻ�������y�����γ��ȣ����ο��)
		//jspv.setBounds(13, 10, 350, 340);
		//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
		//jspv.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);JScrollPane.ScrollPaneConstraints.VERTICAL_SCROLLBAR_ALWAYS
		//jspv.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	   choice = new JTextField(15);//���������Ŀյ�JTextField����
	   choice.setFont(new Font("����",Font.BOLD,20));//�����ı����е�����
      
	 
	   JPanel area=new JPanel();//�������
	    area.setBackground(Color.CYAN);//�������ı�����ɫ
		//area.setLayout(new GridLayout(6,2));//���񲼾֣���������������
	    //area.setLayout(new BorderLayout());
		//��������������
		area.add(item1);
		area.add(item2);


		area.add(jspwv);
		area.add(jspr);
		area.add(item3);

		area.add(choice);		
		add(area,BorderLayout.CENTER);//�߿򲼾ֹ�����
			
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
		        		  double[][] x = new double[1000][1000];
		        		  for(int i = 0;i < types;i++)
		        		  {
		        			  x[i][1] = i;
		        		  }

		        		  x = a.Greedy(x,w,v,types,beibaosize);
		        		  Tresult.setText(null);
		        		  Tresult.append("����ֵΪ��"+x[types][0]+"\n");
		        		  Tresult.append("��Ʒ����������{ ");
		        		  for(int i = 0;i < types-1;i++)
		        		  {
		        			  Tresult.append(w[(int)x[i][1]]+", ");
		        		  }
		        		  Tresult.append(w[(int)x[types-1][1]]+" }"+"\n");
		        		  Tresult.append("������Ϊ��{ ");
		        		  for(int i = 0;i<types-1;i++)
		        		  {
		        			  Tresult.append(x[i][0]+", ");
		        		  }
		        		  Tresult.append(x[types-1][0]+" }"+"\n");
		        	  }
		        	  else if(select == 3)
		        	  {
		        		  Algorithm a = new Algorithm();
		        		  double[] x = new double[1000];
		        		  x = a.Backtracking(w,v,types,beibaosize);
		        		  Tresult.setText(null);
		        		  Tresult.append("����ֵΪ��"+x[types]+"\n");
		        		  Tresult.append("��Ʒ��������Ϊ��{ ");
		        		  for(int i = 0;i<types-1;i++)
		        		  {
		        			  Tresult.append(w[i]+", ");
		        		  }
		        		  Tresult.append(w[types-1]+" }"+"\n");
		        		  Tresult.append("������Ϊ��{ ");
		        		  for(int i = 0;i<types-1;i++)
		        		  {
		        			  Tresult.append((int)x[i]+", ");
		        		  }
		        		  Tresult.append((int)x[types-1]+" }"+"\n");
		        	  }
		        	  else if(select == 4)
		        	  {
		        		  Algorithm a = new Algorithm();
		        		  int[] x = new int[100];
		        		  x = a.Dynamic(w,v,types,beibaosize);
		        		  Tresult.setText(null);
		        		  Tresult.append("����ֵΪ��"+x[types]+"\n");
		        		  Tresult.append("��Ʒ��������Ϊ��{ ");
		        		  for(int i = 0;i<types-1;i++)
		        		  {
		        			  Tresult.append(w[i]+", ");
		        		  }
		        		  Tresult.append(w[types-1]+" }"+"\n");
		        		  Tresult.append("������Ϊ��{ ");
		        		  for(int i = 0;i<types-1;i++)
		        		  {
		        			  Tresult.append(x[i]+", ");
		        		  }
		        		  Tresult.append(x[types-1]+" }"+"\n");
		        	  }
		        	  else if(select == 5)
		        	  {
		        		 
		        		  JFrame f = new JFrame();
//		        		  JButton button = new JButton("�ر�");;//��ť���鿴0-1����������
//		        		  button.addActionListener(new ActionListener()
//		   		         {      
//		   		           public void actionPerformed(ActionEvent event)
//		   		           {    
//		   		        	  f.dispose();
//		   		           }
//		   		        });
//		        		  JPANEL A = NEW JPANEL();
//		        		  A.ADD(BUTTON);
		        		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        		 // f.add(a);
		        		  f.add(new Paint(w,v,types));
		        		  f.setSize(400,300);
		        		  f.setLocation(240,200);
		        		  f.setVisible(true);
		        		 
		        	  }
		        	  else if(select == 6)
		        	  {
		        		  Tresult.setText(null);
		        		  for(int i = 0;i < types;i++)
		        		  {
		        			  c[i][0] =(double)v[i]/(double)w[i];
		        			  c[i][1] = i+1;
		        			 // System.out.println(c[i][1] );
		        			  //System.out.println(c[i][0] );

		        		  }
		        		  Algorithm a = new Algorithm();
		        		  c = a.Selectsort(c, 0, types);
		        		  for(int i = 0;i < types;i++)
		        		  {
		        			  Tresult.append("��"+(int)c[i][1]+"����Ʒ��������Ϊ��"+c[i][0]+"\n");
		        		  }
		        	  }
		        	  else if(select == 7)
		        	  {
		        		  try {

		        			    File writeName = new File("D:\\2021-2022\\������\\������̾���\\Git\\0-1\\0-1-knapsack\\data"+dataname+".txt"); // ���·�������û����Ҫ����һ���µ�output.txt�ļ�
		        			    dataname++;
		        			    if(!writeName.exists()) {
		        			        writeName.createNewFile(); // �������ļ�,��ͬ�����ļ��Ļ�ֱ�Ӹ���
		        			    }
		        			    FileWriter writer = new FileWriter(writeName);
		        			    BufferedWriter out = new BufferedWriter(writer);
		        			    String data = Tresult.getText();
		        			    out.write(data);
		        			    out.flush(); // �ѻ���������ѹ���ļ�    out.close();
		        			} catch (IOException e) {
		        			    e.printStackTrace();
		        			}
		        		  JOptionPane.showMessageDialog(null,"�������ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);  
		        	  }
		        	  else
		        	  {
		        		  JOptionPane.showMessageDialog(null,"������ѡ������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
		                  //��������  
		                  choice.setText("");
		        	  }
		           }
		       });
			area.add(Gbutton);//���������Ӱ�ť
		
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
		        	  
		        	  
		        	  
		        	 list.clear();
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
							Twv.setText(null);
							 Twv.append(" ��Ʒ����: " +types+"    "+" ��������: " +beibaosize+"\n");
							 int i = 1;
		        		  for (Goods tmp : list)
		        		   { 
		        			 //���������ı�׷�ӵ��ı����������ı���β��
		        			  Twv.append("��"+i+"����Ʒ�� ����: " +tmp.getWeight()+"   "+" ��ֵ: " +tmp.getValue()+"\n");
		        			 i++;
		        	       } 
		        		  
		           }
		       });
			
			File.setTitle("0-1��������");//��������
			File.setBounds(190,60, 600,350);//����λ�ü���С
			File.setVisible(true);
			File.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ر�
			
			
			
	   }


}