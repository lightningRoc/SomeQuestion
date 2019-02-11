/**
 * give two integers
 * return the bigger number without comparing
 * @author PC
 *
 */
public class CompareValue {
	
	public static int flip(int n)
	{
		return n^1;
	}
	
	public static int getSign(int n)
	{
		return flip((n>>31)&1);
	}
	
	public static int getMax(int a,int b)
	{
		int res=a-b;
		int sa=getSign(a);
		int sb=getSign(b);
		int sr=getSign(res);
		int sDifferent=sa^sb;
		int sSame=flip(sDifferent);
		int selectA=sDifferent*sa+sSame*sr;
		int selectB=flip(selectA);
		return a*selectA+b*selectB;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=6;
		int b=3;
		System.out.println(getMax(a,b));
	}

}
