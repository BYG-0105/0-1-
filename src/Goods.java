
public class Goods {
	/* ��Ʒ���������ֵ */
	private int weight; //��Ʒ����
	private double value; //��Ʒ��ֵ
	
	 /* ������ */
	public Goods(int weight,double value)
	{
		this.weight = weight;
		this.value = value;
	}
	
    /* get��set����*/
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
