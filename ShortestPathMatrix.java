/**
 * give a matrix
 * find the shortest path(from the topLeft to the bottomRight)
 * path:the node just can go to the right and go to the bottom
 * the length is the sum of all the pathNodes' value
 * @author PC
 *
 */
public class ShortestPathMatrix {
	
	public static int minPath1(int[][] m)
	{
		if(m==null||m.length==0||m[0]==null||m[0].length==0)
		{
			return 0;
		}
		int rows=m.length;
		int cols=m[0].length;
		int[][] dp=new int[rows][cols];
		dp[0][0]=m[0][0];
		for(int i=1;i<rows;i++)dp[i][0]=dp[i-1][0]+m[i][0];
		for(int j=1;j<cols;j++)dp[0][j]=dp[0][j-1]+m[0][j];
		for(int i=1;i<rows;i++)
			for(int j=1;j<cols;j++)
			{
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		
		return dp[rows-1][cols-1];
	}
	
	public static int minPath2(int[][] m)
	{
		if(m==null||m.length==0||m[0]==null||m[0].length==0)
		{
			return 0;
		}
		int big=Math.max(m.length, m[0].length);
		int small=Math.min(m.length, m[0].length);
		boolean rowmore=big==m.length;
		int[] aux=new int[small];
		aux[0]=m[0][0];
		for(int i=1;i<small;i++)aux[i]=aux[i-1]+(rowmore?m[0][i]:m[i][0]);
		for(int i=1;i<big;i++)
		{
			aux[0]=aux[0]+(rowmore?m[0][i]:m[i][0]);
			for(int j=1;j<small;j++)
			{
				aux[j]=Math.min(aux[j-1], aux[j])+(rowmore?m[i][j]:m[j][i]);
			}
		}
		
		return aux[small-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[][] test= {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		System.out.println(minPath1(test));
		System.out.println(minPath2(test));
	}

}
