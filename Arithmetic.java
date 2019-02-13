/**
 * give two integer
 * implement the add,minus,multiply,divide
 * without the '+','-','*','/'
 * @author PC
 *
 */
public class Arithmetic {
	
	public static int add(int a,int b)
	{
		int sum=a;
		while(b!=0)
		{
			sum=a^b;
			b=(a&b)<<1;
			a=sum;
		}
		return sum;
	}
	
	public static int negativeNum(int num)
	{
		return add(~num,1);
	}
	
	public static int minus(int a,int b)
	{
		return add(a,negativeNum(b));
	}
	
	public static int multi(int a,int b)
	{
		int res=0;
		while(b!=0)
		{
			if((b&1)!=0)
			{
				res=add(res,a);
			}
			a<<=1;
			b>>>=1;
		}
		return res;
	}
	
	public static boolean isNeg(int num)
	{
		return num<0;
	}
	
	public static int div(int a,int b)//cannot compute the Integer.MIN_VALUE
	{
		if(b==0)throw new RuntimeException("divisor is 0");
		int x=isNeg(a)?negativeNum(a):a;
		int y=isNeg(b)?negativeNum(b):b;
		int res=0;
		for(int i=31;i>-1;i=minus(i,1))
		{
			if((x>>i)>=y)
			{
				res|=(1<<i);
				x=minus(x,y<<i);
			}
		}
		return isNeg(a)^isNeg(b)?negativeNum(res):res;
	}
	
	public static int divEx(int a,int b)//can compute the Integer.MIN_VALUE
	{
		if(b==0)throw new RuntimeException("divisor is 0");
		if(a==Integer.MIN_VALUE&&b==Integer.MIN_VALUE)
		{
			return 1;
		}
		else if(b==Integer.MIN_VALUE)
		{
			return 0;
		}
		else if(a==Integer.MIN_VALUE)
		{
			int res=div(add(a,1),b);
			return add(res,div(minus(a,multi(res,b)),b));
		}
		else
		{
			return div(a,b);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int a=8,b=4;
		System.out.println(add(a,b));
		System.out.println(minus(a,b));
		System.out.println(multi(a,b));
		System.out.println(div(a,b));
		System.out.println(div(Integer.MIN_VALUE,2));
		System.out.println(divEx(Integer.MIN_VALUE,2));
	}

}
