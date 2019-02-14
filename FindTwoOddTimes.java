import java.util.Arrays;

/**
 * give a array
 * the amount of two number are odd,the other are even
 * find them
 * @author PC
 *
 */
public class FindTwoOddTimes {
	
	public static int[] twoOddTimes(int[] arr)
	{
		int res1=0;
		int res2=0;
		for(int num:arr)
		{
			res1^=num;
		}
		int judge=res1&(~res1+1);
		for(int num:arr)
		{
			if((judge&num)!=0)
			{
				res2^=num;
			}
		}
		return new int[] {res2,(res1^res2)};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] test= {0,-1,2,2,3,3};
		System.out.println(Arrays.toString(twoOddTimes(test)));
	}

}
