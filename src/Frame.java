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
	//给定常量值
	public static final int TEXTAREA_ROWS = 200;
	public static final int TEXTAREA_COLUMNS = 200;
	/* 文本域，分别来存放物品的重量，价值*/
    JTextField choice; //用户选择
    
	
	JButton Gbutton;//按钮，查看0-1背包问题结果
	JTextArea Tweight;//文本区，用来输出物品重量
	JTextArea Tvalue;//文本区，用来输出物品价值
	JTextArea Tresult;//文本区，用来输出物品价值
    ArrayList<Goods> list = new ArrayList<Goods>();;//存放从文件读取的物品对象
    
  public Frame() 
   { 
	  
	
	  
	  


	   JLabel Jwv = new JLabel("物品重量及价值",JLabel.CENTER);
	   //JLabel Jvalue = new JLabel("物品价值",JLabel.CENTER);
	   JLabel item1 = new JLabel("<html><body> 1.选择数据文件<br> 2.贪心算法<br> 3.回溯算法<br> 4.动态规划算法<br> </body></html>",JLabel.CENTER);
	   JLabel item2 = new JLabel("<html><body>5.绘制散点图<br> 6.按重量比进行非递增排序<br> 7.以文件形式保存结果</body></html>",JLabel.CENTER);
	   /*
	   JLabel huisu = new JLabel("",JLabel.CENTER);
	   JLabel dtgh = new JLabel("",JLabel.CENTER);
	   JLabel paint = new JLabel("",JLabel.CENTER);
	   JLabel wv = new JLabel("",JLabel.CENTER);
	   JLabel txt = new JLabel("",JLabel.CENTER);

*/


       //设置字体及背景设置
	   item1.setFont(new Font("宋体",Font.BOLD,15));
	   item1.setForeground(Color.BLUE);
	   
	   Jwv.setFont(new Font("宋体",Font.BOLD,15));
	   Jwv.setForeground(Color.BLUE);
	   
	   //Jvalue.setFont(new Font("宋体",Font.BOLD,15));
	   //Jvalue.setForeground(Color.BLUE);
	   
	   item2.setFont(new Font("宋体",Font.BOLD,15));
	   item2.setForeground(Color.BLUE);
	   /*
	   filenames.setPreferredSize(new Dimension(100, 200));
	   
	   tanxin.setFont(new Font("宋体",Font.BOLD,15));
	   tanxin.setForeground(Color.BLUE);
	   
	   huisu.setFont(new Font("宋体",Font.BOLD,15));
	   huisu.setForeground(Color.BLUE);
	   
	   dtgh.setFont(new Font("宋体",Font.BOLD,15));
	   dtgh.setForeground(Color.BLUE);
	   
	   paint.setFont(new Font("宋体",Font.BOLD,15));
	   paint.setForeground(Color.BLUE);
	   
	   wv.setFont(new Font("宋体",Font.BOLD,15));
	   wv.setForeground(Color.BLUE);
*/
	   Tweight = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);//给定列数和行数
	   Tvalue = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);//给定列数和行数
	   Tresult = new JTextArea(100,1000);//给定列数和行数
		add(Tweight,BorderLayout.SOUTH);//边框布局管理器
		add(Tvalue,BorderLayout.SOUTH);//边框布局管理器
		//add(Tresult,BorderLayout.SOUTH);//边框布局管理器


	   choice = new JTextField(10);//给定列数的空的JTextField对象
	   choice.setFont(new Font("宋体",Font.BOLD,15));//设置文本域中的字体
      
	  //增加按钮
	   Gbutton=new JButton("确定");
	   Gbutton.setBackground(Color.pink);//设置按钮的颜色
		//动作监听器
		Gbutton.addActionListener(new ActionListener()
	       {      
	           public void actionPerformed(ActionEvent event)
	           {    
	        	  
	        	  int select = Integer.parseInt(choice.getText());//从文本域中获取输入的值
	        	  if(select == 1)
	        	  {
	        		  Text text = new Text();
	        		  text.setTitle("0-1背包问题");//定义名称
	        		  text.setBounds(190,60, 600,350);//定义位置及大小
	        		  text.setVisible(true);
	        		  text.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭
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
	        			 //将给定的文本追加到文本区的已有文本的尾部
	        			  Tweight.append(" 重量: " +tmp.getWeight()+"\n");
	        			  Tvalue.append(" 价值: " +tmp.getValue()+"\n");
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
	        			  Tresult.append("第"+(i+1)+"个物品的重量比为："+c[i]+"\n");
	        		  }
	        	  }
	        	  else if(select == 7)
	        	  {
	        		  
	        	  }
	        	  else
	        	  {
	        		  JOptionPane.showMessageDialog(null,"所输入选择有误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
	                  //清空输入框  
	                  choice.setText("");
	        	  }
	           }
	       });
		
	   JPanel area=new JPanel();//增加面板
	    area.setBackground(Color.CYAN);//设置面板的背景颜色
		area.setLayout(new GridLayout(6,1));//网格布局，给定行数和列数
		//在面板上增加组件
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
		area.add(Gbutton);//在面板上添加按钮
		//area.add(Tresult);
		
		add(area,BorderLayout.CENTER);//边框布局管理器
			
		
   }


}