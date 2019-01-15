import java.util.Stack;

public class StackCanGetMin {
	//a special stack that can get the minimum element
	//time: pop:O(1) push:O(1) getMin():O(1)
	
	private Stack<Integer> dataStack;
	private Stack<Integer> minDataStack;
	
	public StackCanGetMin()
	{
		dataStack=new Stack<Integer>();
		minDataStack=new Stack<Integer>();
	}
	
	public void push(int num)
	{
		if(minDataStack.isEmpty())
		{
			minDataStack.push(num);
		}
		else if(num<minDataStack.peek())
		{
			minDataStack.push(num);
		}
		else
		{
			num=minDataStack.peek();
			minDataStack.push(num);
		}
		dataStack.push(num);
	}
	
	public int pop()
	{
		if(minDataStack.isEmpty())
		{
			throw new RuntimeException("the stack is empty");
		}
		minDataStack.pop();
		return dataStack.pop();
	}
	
	public int getMin()
	{
		if(minDataStack.isEmpty())
		{
			throw new RuntimeException("the stack is empty");
		}
		return minDataStack.peek();
	}
	
	public boolean isEmpty()
	{
		return dataStack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testData
		int[] testData= {4,5,1,3,2,5};
		StackCanGetMin test=new StackCanGetMin();
		for(int i=0;i<testData.length;i++)
		{
			test.push(testData[i]);
		}
		
		while(!test.isEmpty())
		{
			System.out.println(test.pop());	
		}
	}

}
