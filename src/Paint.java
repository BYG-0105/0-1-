
import java.awt.*;

import java.awt.geom.*;
import javax.swing.*;

public class Paint extends JPanel {

    final int p = 20;
    int[] w = new int [100];
    int[] v = new int [100];
    int n;
    public  Paint(int[] w,int[] v,int n)
    {
    	this.w = w;
    	this.v = v;
    	this.n = n;
    }
    	
	public Paint() {
		// TODO Auto-generated constructor stub
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int wid = getWidth();
        int hei = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(p, p, p, hei-p));
        // Draw abcissa.
        g2.draw(new Line2D.Double(p, hei-p, wid-p, hei-p));
        
        g2.drawString("0",p-10,hei-p+10); //添加文字
        g2.drawString("重量",wid-p-20,hei-p+10);
        g2.drawString("价值",p-10,p-5);
        double xline = (double)(wid - 2*p)/getMaxw();
        double yline = (double)(hei - 2*p)/getMaxv();
        double x = 0,y = 0;
        for (int i=0 ;i< n;i++) 
        { //开始绘制点
             x = p+xline*w[i];
             y =  hei-p-yline*v[i];
            g2.fill(new Ellipse2D.Double(x-2,y-2,4,4));
        }
        for(int i = 0;i < n;i++)
		{
			 System.out.print(w[i]+"i   " );
			     System.out.println(v[i]+"i"  );
		}
       
    }

    private int getMaxw() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(w[i] > max)
                max = w[i];
        }
        return max;
    }
    private int getMaxv() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(v[i] > max)
                max = v[i];
        }
        return max;
    }

   
}
    

