import javax.swing.JFrame;
public class Main
{
   public static void main(String[] args)
   {
	     Frame frame = new Frame();
         frame.setTitle("Student");//定义名称
         frame.setBounds(40,40, 700, 680);//定义位置及大小
         frame.setVisible(true);
 		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭
   }
}