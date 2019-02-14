/**
 * give a array
 * the amount of a number is odd,the other are even
 * find it
 * @author PC
 *
 */
public class FindOddTimes {
	
	public static int oddTimes(int[] arr)
	{
		int res=0;
		for(int num:arr)
		{
			res^=num;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] test= {1,2,3,5,5,3,2};
		System.out.println(oddTimes(test));
	}

}
