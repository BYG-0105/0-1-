
public class Goods {
	/* 货品对象的属性值 */
	private int weight; //货品重量
	private double value; //货品价值
	
	 /* 构造器 */
	public Goods(int weight,double value)
	{
		this.weight = weight;
		this.value = value;
	}
	
    /* get和set函数*/
	public int getWeight()
   {
	  return weight;
   }
   public void setWeight(int weight)
  {
    this.weight = weight;
   }
   public double getValue()
   {
	   return value;
   }
   public void setValue()
   {
	   this.value = value;
   }
}
