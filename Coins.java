/**
 * give a integer array, each value represent the face value of a type of coin
 * all the coins' number are unlimited
 * give a integer aim
 * find the types of coins whose sum equals aim
 * @author PC
 *
 */
public class Coins {
	
	public static int coins1(int[] arr,int aim)//common recursion
	{
		if(arr==null||arr.length==0||aim<0)return 0;
		
		return recursion1(arr,0,aim);
	}
	
	public static int recursion1(int[] arr,int index,int aim)
	{
		int res=0;
		if(index==arr.length)
		{
			res=aim==0?1:0;
		}
		else
		{
			for(int i=0;arr[index]*i<=aim;i++)
			{
				res+=recursion1(arr,index+1,aim-arr[index]*i);
			}
		}
		return res;
	}
	
	public static int coins2(int[] arr,int aim)//dp1
	{
		if(arr==null||arr.length==0||aim<0)return 0;
		int[][] record=new int[arr.length+1][aim+1];
		return recursion2(arr,0,aim,record);
	}
	
	public static int recursion2(int[] arr,int index,int aim,int[][] record)
	{
		int res=0;
		if(index==arr.length)
		{
			res=aim==0?1:0;
		}
		else
		{
			int recordValue=0;
			for(int i=0;arr[index]*i<=aim;i++)
			{
				recordValue=record[index+1][aim-arr[index]*i];
				if(recordValue!=0)res+=recordValue==-1?0:recordValue;
				else res+=recursion2(arr,index+1,aim-arr[index]*i,record);
			}
		}
		record[index][aim]=res==0?-1:res;
		return res;
	}
	
	public static int coins3(int[] arr,int aim)//dp2
	{
		if(arr==null||arr.length==0||aim<0)return 0;
		int[][] dp=new int[arr.length][aim+1];
		for(int i=0;i<arr.length;i++)dp[i][0]=1;
		for(int j=0;arr[0]*j<=aim;j++)dp[0][arr[0]*j]=1;
		int num=0;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<=aim;j++)
			{
				num=0;
				for(int k=0;j-arr[i]*k>=0;k++)
				{
					num+=dp[i-1][j-arr[i]*k];	
				}
				dp[i][j]=num;
			}
		}
		return dp[arr.length-1][aim];
	}
	
	public static int coins4(int[] arr,int aim)
	{
		if(arr==null||arr.length==0||aim<0)return 0;
		int[][] dp=new int[arr.length][aim+1];
		for(int i=0;i<arr.length;i++)dp[i][0]=1;
		for(int j=0;arr[0]*j<=aim;j++)dp[0][arr[0]*j]=1;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<=aim;j++)
			{
				dp[i][j]=dp[i-1][j];
				dp[i][j]+=j-arr[i]>=0?dp[i][j-arr[i]]:0;
			}
		}
		return dp[arr.length-1][aim];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] test= {5,10,25,1,2,3,4,6};
		int aim=15;
		long start;
		long end;
		start=System.currentTimeMillis();
		for(int i=0;i<10000;i++)
		{
			coins1(test,aim);
		}
		end=System.currentTimeMillis();
		System.out.println(coins1(test,aim)+" 1:time:"+(end-start)+"ms");
		start=System.currentTimeMillis();
		for(int i=0;i<10000;i++)
		{
			coins2(test,aim);
		}
		end=System.currentTimeMillis();
		System.out.println(coins2(test,aim)+" 2:time:"+(end-start)+"ms");
		start=System.currentTimeMillis();
		for(int i=0;i<10000;i++)
		{
			coins3(test,aim);
		}
		end=System.currentTimeMillis();
		System.out.println(coins3(test,aim)+" 3:time:"+(end-start)+"ms");
		start=System.currentTimeMillis();
		for(int i=0;i<10000;i++)
		{
			coins4(test,aim);
		}
		end=System.currentTimeMillis();
		System.out.println(coins4(test,aim)+" 4:time:"+(end-start)+"ms");
	}

}
