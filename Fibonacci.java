/**
 * find the Nth number of Fibonacci sequence
 * @author PC
 *
 */
public class Fibonacci {
	
	public static int f1(int n)//O(n^2)
	{
		if(n<1)return 0;
		if(n==1||n==2)return 1;
		return f1(n-1)+f1(n-2);
	}
	
	public static int f2(int n)//O(n)
	{
		if(n<1)return 0;
		if(n==1||n==2)return 1;
		int temp=1;
		int first=1;
		int second=1;
		for(int i=3;i<=n;i++)
		{
			temp=second;
			second+=first;
			first=temp;
		}
		return second;
	}
	
	public static int[][] matrixPower(int[][] m,int p)
	{
		int[][] res=new int[m.length][m[0].length];
		for(int i=0;i<res.length;i++)
		{
			res[i][i]=1;
		}
		int[][] tmp=m;
		for(;p!=0;p>>=1)
		{
			if((p&1)!=0)
			{
				res=multiMatrix(res,tmp);
			}
			tmp=multiMatrix(tmp,tmp);
		}
		return res;
	}
	
	public static int[][] multiMatrix(int[][] m1,int[][] m2)
	{
		int[][] res=new int[m1.length][m2[0].length];
		for(int i=0;i<m1.length;i++)
		{
			for(int j=0;j<m2[0].length;j++)
			{
				res[i][j]=0;
			}
		}
		for(int i=0;i<m1.length;i++)
		{
			for(int j=0;j<m2[0].length;j++)
			{
				for(int k=0;k<m2.length;k++)
				{
					res[i][j]+=m1[i][k]*m2[k][j];
				}
			}
		}
		
		return res;
	}
	
	public static int f3(int n)
	{
		if(n<1)return 0;
		if(n==1||n==2)return 1;
		int[][] base= {{1,1},{1,0}};
		int[][] res=matrixPower(base,n-2);
		return res[0][0]+res[1][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		System.out.println("O(n^2):"+f1(10));
		System.out.println("O(n):"+f2(10));
		System.out.println("O(logn):"+f3(10));
	}

}
