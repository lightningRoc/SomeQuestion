/**
 * give a array and a integer k
 * the amount of a number is just 1,the other are k
 * find it
 * @author PC
 *
 */
public class FindOneTimes {
	
	public static int oneTime(int[] arr,int k)
	{
		int[] resNum=new int[32];
		for(int i=0;i<arr.length;i++)
		{
			exclusiveOr(resNum,arr[i],k);
		}
		int res=getNumFromBaseK(resNum,k);
		return res;
	}
	
	public static void exclusiveOr(int[] num,int value,int k)
	{
		int[] curNum=getBaseK(value,k);
		for(int i=0;i<num.length;i++)
		{
			num[i]=(num[i]+curNum[i])%k;
		}
	}
	
	public static int[] getBaseK(int value,int k)
	{
		int[] res=new int[32];
		int cursion=0;
		while(value!=0)
		{
			res[cursion++]=value%k;
			value/=k;
		}
		return res;
	}
	
	public static int getNumFromBaseK(int[] num,int k)
	{
		int res=0;
		for(int i=num.length-1;i>=0;i--)
		{
			res=res*k+num[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] res= {Integer.MAX_VALUE,2,2,3,3};
		System.out.println(oneTime(res,2));
	}

}
