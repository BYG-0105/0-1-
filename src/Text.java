import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public  class Text extends JFrame {

		public int fileId;
		static JFrame File = new JFrame(); //ѡ�������ļ�����
	    
	  public Text()
	   {
			
		   JButton Gbutton;//��ť���鿴�����ļ���Ϣ
		   
		   JLabel item1 = new JLabel("0-1��������",JLabel.CENTER);
		   JLabel item2 = new JLabel("ѡ����Ҫ��ȡ���ݵ��ļ�������10���ļ��� ",JLabel.CENTER);
	        //�������弰��������
		   item1.setFont(new Font("����",Font.BOLD,15));
		   item1.setForeground(Color.BLUE);
		   item2.setFont(new Font("����",Font.BOLD,15));
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
		   
	     
	      
	       JPanel area=new JPanel();//�������
		   area.setBackground(Color.CYAN);//�������ı�����ɫ
			area.setLayout(new GridLayout(5,1));//���񲼾֣���������������
			//��������������
			area.add(item1);
			area.add(item2);
		   

			add(area,BorderLayout.CENTER);//�߿򲼾ֹ�����
			
			
			//���Ӱ�ť
			Gbutton=new JButton("�鿴");
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
		           }
		       });
			
	   }
	  public int getID()
	  {
		  return fileId;
	  }




}
