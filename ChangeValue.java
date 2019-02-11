/**
 * give two numbers
 * change their value without another variable
 * @author PC
 *
 */
public class ChangeValue {
	
	public static int[] swap(int a,int b)
	{
		a=a^b;
		b=a^b;
		a=a^b;
		return new int[]{a,b};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=4;
		int b=3;
		int[] res=swap(a,b);
		a=res[0];
		b=res[1];
		System.out.println(a+" "+b);
	}

}
