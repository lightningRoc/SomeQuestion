import java.util.LinkedList;

/**
 * give a array and num
 * return the number of subArray(max(array[i...j]-min(array[i...j])<=num)
 * @author PC
 *
 */
public class SubArrayNum {
	
	public static int getNum(int[] array,int num)
	{
		if(array==null||array.length==0)
		{
			return 0;
		}
		
		LinkedList<Integer> minQ=new LinkedList<Integer>();
		LinkedList<Integer> maxQ=new LinkedList<Integer>();
		int i=0,j=0,res=0;
		while(i<array.length)
		{
			while(j<array.length)
			{
				while(!minQ.isEmpty()&&array[minQ.peekLast()]>=array[j])
				{
					minQ.pollLast();
				}
				minQ.addLast(j);
				while(!maxQ.isEmpty()&&array[maxQ.peekLast()]<=array[j])
				{
					maxQ.pollLast();
				}
				maxQ.addLast(j);
				
				if(array[maxQ.getFirst()]-array[minQ.getFirst()]>num)break;
				j++;
				
			}
			
			if(minQ.peekFirst()==i)
			{
				minQ.pollFirst();
			}
			if(maxQ.peekFirst()==i)
			{
				maxQ.pollFirst();
			}
			res+=j-i;
			i++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] test= {4,5,10,6};
		System.out.println(SubArrayNum.getNum(test, 4));;

	}

}
