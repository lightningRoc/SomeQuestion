/**
 * give a integer array, each value represent the face value of a type of coin
 * all the coins' number are only one
 * give a integer aim
 * find the minimum number of coins whose sum equals aim
 * @author PC
 *
 */
public class MinCoins2 {
	
	public static int minCoins(int[] arr,int aim)
	{
		if(arr==null||arr.length==0||aim<0)return -1;
		
		int n=arr.length;
		int max=Integer.MAX_VALUE;
		int[][] dp=new int[n][aim+1];
		for(int i=1;i<=aim;i++)
		{
			dp[0][i]=max;
		}
		if(arr[0]<=aim)dp[0][arr[0]]=1;
		
		int left=0;
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=aim;j++)
			{
				left=max;
				if(j-arr[i]>=0&&dp[i-1][j-arr[i]]!=max)
				{
					left=dp[i-1][j-arr[i]]+1;
				}
				dp[i][j]=Math.min(left, dp[i-1][j]);
			}
		}
		return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] test= {5,2,5,3};
		System.out.println(minCoins(test,10));
	}

}
