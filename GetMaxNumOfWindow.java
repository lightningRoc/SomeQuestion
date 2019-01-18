import java.util.LinkedList;

/**
 * give a array whose length is n
 * give a window whose length is w
 * return the window's maximum number of all different window
 * example:array:[4,3,5,4],w=3
 * [[4,3,5],4]  max=5
 * [4,[3,5,4]] max=5
 * return [5,5]
 * @author PC
 *
 */

public class GetMaxNumOfWindow {
	
	public static int[] getMaxWindow(int[] arr,int w)
	{
		if(arr==null||w<1||arr.length<w)
		{
			throw new RuntimeException("input is invalid");
		}
		
		LinkedList<Integer> aux=new LinkedList<Integer>();
		
		int[] res=new int[arr.length-w+1];
		int cursion=0;
		for(int i=0;i<arr.length;i++)
		{
			while(!aux.isEmpty()&&arr[aux.peekLast()]<=arr[i])
			{
				aux.pollLast();
			}
			aux.addLast(i);
			if(aux.peekFirst()==i-w)
			{
				aux.pollFirst();
			}
			if(i>=w-1)
			{
				res[cursion++]=arr[aux.peekFirst()];
			}
			
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] test= {4,3,5,4,3,3,6,7};
		int[] res=GetMaxNumOfWindow.getMaxWindow(test, 3);
		for(int i=0;i<res.length;i++)
		{
			System.out.println(res[i]);
		}
	}

}
