import java.math.BigDecimal;

public class Algorithm {
	/*������*/
	public Algorithm()
	{	}
	
	//̰���㷨
	public double[] Greedy(int w[],int v[],int n, int C)
	{
		 double[] c = new double[100];
		 for(int i = 0;i < n;i++)
		  {
			  c[i] =(double)v[i]/(double)w[i];
		  }
		 for(int i = 0;i < n;i++)
		 {
			 for(int j = i+1;j < n;j++)
			 {
				 if(c[i] <= c[j])
				 {
					 double temp = c[i];
					 c[i] = c[j];
					 c[j] = temp;
					 
					 int tempw = w[i];
					 w[i] = w[j];
					 w[j] = tempw;
					 
					 int tempv = v[i];
					 v[i] = v[j];
					 v[j] = tempv;
					 
				 }
			 }
		 }
		 double[] x = new double[100];
		 for(int i = 0;i < n;i++)
		 {
			 x[i] = 0;
		 }
		int maxValue= 0;
		int i;
		for (i=0; w[i]<C; i++ )
		{
		 x[i]=1;
		 maxValue+=v[i] ;
		 C=C-w[i] ;
		}
		x[i]= (double)C/w[i];
		maxValue+=x[i]*v[i];
		x[i+1] =maxValue ;
		return x ;

	}
	
	

	

		//�����㷨
	public int[] Backtracking(int w[], int v[], int n,int C)
	{
	   int cw=0, cv=0,bestv=0,k=0;
	   int[] x = new int [1000];
	   int[] bestx = new int [1000];
       for (int i = 0; i < n ;i++)
			   x[i]=2;
			while (k>=0)
			{
				x[k]=x[k]-1;
			   while (x[k]>=0)
			   {
			    if (cw+w[k]<=C) 
			    {
			    	if (bound(k+1,cw,cv,n,C,w,v) > bestv) 
			    	{
			    		cv=cv+v[k]*x[k];
			    		cw=cw+w[k]*x[k];
			    		break;
			    	}
			    	else
			    	{
			    		x[k]=x[k]-1;
			    	}
			   }
			  else
			  {
				  x[k]=x[k]-1;
			  }
			 }
			if (x[k]>=0 && k==n) { //�õ�һ��װ��
				if (cv > bestv)
				{
					bestv=cv;
					for( int i=1;i<=n;i++)
						bestx[i]=x[i];
				}
			if (x[k]>=0 && k<n)
				k=k+1;
			//������һ����Ʒ
			else {
			cw=cw-w[k]*x[k];
			cv=cv-v[k]*x[k];
			x[k]=2;
			//����x[k],����
			k=k-1;
			}
		}
	  }
	 return x;

	}
	//�����Ͻ纯��
	double bound(int i,int cw,int cv,int n, int C,int w[],int v[])
	{
	    double leftw= C-cw;
	    double b = cv;
	    while(i<=n && w[i]<=leftw)
	    {
	        leftw-=w[i];
	        b+=v[i];
	        i++;
	    }
	    if(i<=n)
	        b+=v[i]/w[i]*leftw;
	    return b;

	}


	
	
	
	//��̬�滮�㷨
	public int[] Dynamic(int w[ ], int v[ ],int n,int C)
	{
		  int i,j;
		  int[] x = new int [1000];
		  int[][] V = new int [1000][1000];
		  for (i=0; i<=n; i++)   //��ʼ����0��
		  {
		      V[i][0]=0;
		  }
		  for (j=0; j<=C; j++)   //��ʼ����0��
		  {
		      V[0][j]=0;
		  }
		  for (i=1; i<=n; i++)   //�����i�У����е�i�ε���
		  {
		    for (j=1; j<=C; j++)
		    {
		         if (j<w[i])
		         {
		             V[i][j]=V[i-1][j];
		         }
		         else
		         {
		             if(V[i-1][j] > V[i-1][j-w[i]]+v[i])
		             {
		                  V[i][j]=V[i-1][j];
		             }
		             else
		             {
		                 V[i][j]=V[i-1][j-w[i]]+v[i];
		             }
		         }

		    }
		  }
		    j=C;    //��װ�뱳������Ʒ
		    for (i=n; i>0; i--)
		    {
		      if (V[i][j]>V[i-1][j])
		      {
		        x[i]=1;
		        j=j-w[i];
		      }
		      else
		      {
		        x[i]=0;
		      }
		     }
             x[n+1] = V[n][C];
		     return x;    //���ر���ȡ�õ�����ֵ

	}

	
	
	public double[][] Selectsort(double r[][], int first, int end){ 
		 //��������
        for (int i = 1; i < end; i++) {
            //���ѭ�����ӵڶ�����ʼ�Ƚ�
            for (int j = i; j > 0; j--) {
                //�ڴ�ѭ������ǰ���ź�������ݱȽϣ�������������С��ǰ����򽻻�
                if (r[j][0] < r[j - 1][0]) {
                    double[] temp = new double[100];
                    temp = r[j - 1];
                    r[j - 1] = r[j];
                    r[j] = temp;
                } else {
                    //�����С�ڣ�˵��������ϣ��˳��ڲ�ѭ��
                    break;
                }
            }
        }
        return r;
	}
	
}


/*

 	//��������
	int Partition(double r[][], int first, int end)//����
	{				
		int i = first, j = end;
		//��ʼ������������
		while (i < j)	{
			while (i < j && compare(r[i][0] ,r[j][0]) <= 0) j--;
			//�Ҳ�ɨ��
			if (i < j)
			{
				//����С��¼������ǰ��
				
				 System.out.println(r[i][1]+"i" );
   			     System.out.println(r[i][0]+"i"  );
				 System.out.println(r[j][1]+"j" );
   			     System.out.println(r[j][0]+"j"  );
				double[] temp = new double[100];
				
				temp = r[i]; r[i] = r[j]; r[j] = temp;
				 System.out.println(r[i][1]+"i" );
   			     System.out.println(r[i][0]+"i"  );
				 System.out.println(r[j][1]+"j" );
   			     System.out.println(r[j][0]+"j"  );
				
				i++;
			}
			while (i < j && compare(r[i][0] ,r[j][0]) <= 0) i++;
			//���ɨ��
			if (i < j) 
			{
				//���ϴ��¼����������
				double[] temp = new double[100];
				temp = r[i]; r[i] = r[j]; r[j] = temp; 
				 
				
				j--;
			}
		}
		return i;												// ������ֵ��¼��λ��
	}


	public double[][] QuickSort(double r[][], int first, int end){  
		//��������
		int pivot;
		for(int i = 0;i <= end;i++)
	{
		 System.out.print(r[i][1]+"i   " );
		     System.out.println(r[i][0]+"i"  );
	}
		 System.out.println("i                 "  );
	

		if (first < end) {
			pivot = Partition(r, first, end);
			//���֣�pivot����ֵ�������е�λ��
			r=QuickSort(r, first, pivot - 1);
			//���������1������������н��п�������
			r=QuickSort(r, pivot + 1, end);
			//���������2�����Ҳ������н��п�������	
			for(int i = 0;i <= end;i++)
		{
			 System.out.print(r[i][1]+"i   " );
			     System.out.println(r[i][0]+"i"  );
		}
			 System.out.println("i                 "  );
		}

      return r;
	}
	
	int compare(double d1,double d2)
	{
		BigDecimal d11 = new BigDecimal(d1);
		BigDecimal d22 = new BigDecimal(d2);
		int res =  d11.compareTo(d22); 
	    return res;
	}
	
 
*/