/**
 * give a integer
 * count the '1' in it's binary number
 * @author PC
 *
 */
public class CountBit {
	
	public static int count(int num)
	{
		int res=0;
		while(num!=0)
		{
			num&=(num-1);
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(5));
	}

}
