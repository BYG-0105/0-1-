import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Frame extends JFrame
{
	int beibaosize;
	int types;
	int w[];
	int v[];
	double c[];
	int wvsum;
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
	  
	
	  
	  


	   JLabel Jwv = new JLabel("��Ʒ��������ֵ",JLabel.CENTER);
	   //JLabel Jvalue = new JLabel("��Ʒ��ֵ",JLabel.CENTER);
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
	        		  Text text = new Text();
	        		  text.setTitle("0-1��������");//��������
	        		  text.setBounds(190,60, 600,350);//����λ�ü���С
	        		  text.setVisible(true);
	        		  text.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ر�
	        		  int fileId = text.getID();
	        		  int Gweight;
	        		  double Gvalue;
	        		 
	        		  BufferedReader reader = null;
					try {
						reader = new BufferedReader(new FileReader("beibao"+fileId+".txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		  String line;
	        		  int flag = 0;
	        		  wvsum = 0;
						try {
							while((line=reader.readLine())!= null)
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
	        	  else if(select == 2)
	        	  {
	        		  Algorithm a = new Algorithm();
	        		  double x[] = a.Greedy(w,v,types,beibaosize);
	        	  }
	        	  else if(select == 3)
	        	  {
	        		  Algorithm a = new Algorithm();
	        		  int x[] = a.Backtracking(w,v,types,beibaosize);
	        	  }
	        	  else if(select == 4)
	        	  {
	        		  Algorithm a = new Algorithm();
	        		  int x[] = a.Dynamic(w,v,types,beibaosize);
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
		area.setLayout(new GridLayout(6,1));//���񲼾֣���������������
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
		//area.add(Jvalue);
		area.add(Tweight);
		area.add(Tvalue);
		area.add(choice);
		area.add(Gbutton);//���������Ӱ�ť
		//area.add(Tresult);
		
		add(area,BorderLayout.CENTER);//�߿򲼾ֹ�����
			
		
   }


}