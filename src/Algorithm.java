
public class Algorithm {
	/*构造器*/
	public Algorithm()
	{	}
	
	//贪心算法
	public double[] Greedy(int w[],int v[],int n, int C)
	{
		 double c[] = null;
		 for(int i = 0;i < n;i++)
		  {
			  c[i] =(double)v[i]/(double)w[i];
		  }
		 for(int i = 0;i < n;i++)
		 {
			 for(int j = i+1;j < n;j++)
			 {
				 if(c[i] < c[j])
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
		 double x[] = null;
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
	
	

	

		//回溯算法
	public int[] Backtracking(int w[], int v[], int n,int C)
	{
	   int cw=0, cv=0,bestv=0,k=0, x[] = null,bestx[] = null;
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
			if (x[k]>=0 && k==n) { //得到一种装法
				if (cv > bestv)
				{
					bestv=cv;
					for( int i=1;i<=n;i++)
						bestx[i]=x[i];
				}
			if (x[k]>=0 && k<n)
				k=k+1;
			//安排下一个物品
			else {
			cw=cw-w[k]*x[k];
			cv=cv-v[k]*x[k];
			x[k]=2;
			//重置x[k],回溯
			k=k-1;
			}
		}
	  }
	 return x;

	}
	//计算上界函数
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


	
	
	
	//动态规划算法
	public int[] Dynamic(int w[ ], int v[ ],int n,int C)
	{
		  int i,j;
		  int x[] = null;
		  int V[][] = null;
		  for (i=0; i<=n; i++)   //初始化第0列
		  {
		      V[i][0]=0;
		  }
		  for (j=0; j<=C; j++)   //初始化第0行
		  {
		      V[0][j]=0;
		  }
		  for (i=1; i<=n; i++)   //计算第i行，进行第i次迭代
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
		    j=C;    //求装入背包的物品
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
/*
		     printf("所装入的物品分别为：");
		     for(i = 1;i <= n;i++)
		     {

		         if(x[i] == 1)
		         {
		             printf("物品 %d  ",i);
		         }

		     }
		     printf("\n");
		     printf("背包最优解为 %d \n",V[n][C]);
		     */
		     return x;    //返回背包取得的最大价值

	}
	//快速排序
	int Partition(double r[], int first, int end)//划分
	{				
		int i = first, j = end;
		//初始化待划分区间
		while (i < j)	{
			while (i < j && r[i] <= r[j]) j--;
			//右侧扫描
			if (i < j)
			{
				//将较小记录交换到前面
				double temp = r[i]; r[i] = r[j]; r[j] = temp;
				i++;
			}
			while (i < j && r[i] <= r[j]) i++;
			//左侧扫描
			if (i < j) 
			{
				//将较大记录交换到后面
				double temp = r[i]; r[i] = r[j]; r[j] = temp;    
				j--;
			}
		}
		return i;												// 返回轴值记录的位置
	}


	public double[] QuickSort(double r[], int first, int end){  
		//快速排序
		int pivot;
		if (first < end) {
			pivot = Partition(r, first, end);
			//划分，pivot是轴值在序列中的位置
			QuickSort(r, first, pivot - 1);
			//求解子问题1，对左侧子序列进行快速排序
			QuickSort(r, pivot + 1, end);
			//求解子问题2，对右侧子序列进行快速排序
		}
      return r;
	}
}
