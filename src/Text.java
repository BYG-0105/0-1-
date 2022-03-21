import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public  class Text extends JFrame {

		public int fileId;
		JFrame File = new JFrame(); //选择数据文件界面
	    
	  public Text()
	   {
			
		   JButton Gbutton;//按钮，查看数据文件信息
		   
		   JLabel item1 = new JLabel("0-1背包问题",JLabel.CENTER);
		   JLabel item2 = new JLabel("选择所要读取数据的文件（共有10个文件） ",JLabel.CENTER);
	        //设置字体及背景设置
		   item1.setFont(new Font("宋体",Font.BOLD,23));
		   item1.setForeground(Color.BLUE);
		   item2.setFont(new Font("宋体",Font.BOLD,22));
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
		   
		   jrb1.setFont(new Font("宋体",Font.BOLD,22));
		   jrb2.setFont(new Font("宋体",Font.BOLD,22));
		   jrb3.setFont(new Font("宋体",Font.BOLD,22));
		   jrb4.setFont(new Font("宋体",Font.BOLD,22));
		   jrb5.setFont(new Font("宋体",Font.BOLD,22));
		   jrb6.setFont(new Font("宋体",Font.BOLD,22));
		   jrb7.setFont(new Font("宋体",Font.BOLD,22));
		   jrb8.setFont(new Font("宋体",Font.BOLD,22));
		   jrb9.setFont(new Font("宋体",Font.BOLD,22));
		   jrb10.setFont(new Font("宋体",Font.BOLD,22));


		   
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
		   
	       JPanel jrbarea=new JPanel();//增加面板
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
	      // jrbarea.setLayout(new GridLayout(10,1));//网格布局，给定行数和列数


	      
	       JPanel area=new JPanel();//增加面板
		   area.setBackground(Color.PINK);//设置面板的背景颜色
			area.setLayout(new GridLayout(4,1));//网格布局，给定行数和列数
			//在面板上增加组件
			area.add(item1);
			area.add(item2);
		    area.add(jrbarea);

			add(area,BorderLayout.CENTER);//边框布局管理器
			
			
			//增加按钮
			Gbutton=new JButton("确定");
			Gbutton.setFont(new Font("宋体",Font.BOLD,20));
			Gbutton.setBackground(Color.pink);//设置按钮的颜色
			area.add(Gbutton);//在面板上添加按钮
			//动作监听器
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
		        	 File.dispose(); //选择数据文件界面关闭
		           }
		       });
			
	   }
	  public int getID()
	  {
		  return fileId;
	  }




}
