import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public  class Text extends JFrame {

		public int fileId;
		JFrame File = new JFrame(); //ѡ�������ļ�����
	    
	  public Text()
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
		   area.setBackground(Color.PINK);//�������ı�����ɫ
			area.setLayout(new GridLayout(4,1));//���񲼾֣���������������
			//��������������
			area.add(item1);
			area.add(item2);
		    area.add(jrbarea);

			add(area,BorderLayout.CENTER);//�߿򲼾ֹ�����
			
			
			//���Ӱ�ť
			Gbutton=new JButton("ȷ��");
			Gbutton.setFont(new Font("����",Font.BOLD,20));
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
