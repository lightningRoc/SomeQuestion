import java.util.Stack;

/**
 * sort a stack by using just a stack
 * the top element is maximum 
 * @author PC
 *
 */

public class SortStackByStack {
	
	public static void sort(Stack<Integer> s)
	{
		Stack<Integer> aux=new Stack<Integer>();
		
		while(!s.isEmpty())
		{
			int num=s.pop();
			while(!aux.isEmpty()&&aux.peek()<num)
			{
				s.push(aux.pop());
			}
			
			aux.push(num);
		}
		
		while(!aux.isEmpty())
		{
			s.push(aux.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Stack<Integer> test=new Stack<Integer>();
		
		test.push(5);
		test.push(2);
		test.push(1);
		test.push(4);
		test.push(3);
		
		for(int i:test)
		{//from the bottom to top
			System.out.println(i);
		}
		SortStackByStack.sort(test);
		System.out.println("");
		
		while(!test.isEmpty())
		{
			System.out.println(test.pop());
		}
	}

}
