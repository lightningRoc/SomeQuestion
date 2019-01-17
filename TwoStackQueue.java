import java.util.Stack;

public class TwoStackQueue {
	//create a Queue with two stacks
	
	public Stack<Integer> stackIn;
	public Stack<Integer> stackOut;
	
	public TwoStackQueue()
	{
		stackIn=new Stack<Integer>();
		stackOut=new Stack<Integer>();
	}
	
	public void add(int num)
	{
		stackIn.push(num);
	}
	
	public int poll()
	{
		if(stackIn.isEmpty()&&stackOut.isEmpty())throw new RuntimeException("Queue is empty");
		else if(stackOut.isEmpty())
		{
			while(!stackIn.isEmpty())
			{
				int num=stackIn.pop();
				stackOut.push(num);
			}
		}
		
		return stackOut.pop();
	}
	
	public int peek()
	{
		if(stackIn.isEmpty()&&stackOut.isEmpty())throw new RuntimeException("Queue is empty");
		else if(stackOut.isEmpty())
		{
			while(!stackIn.isEmpty())
			{
				int num=stackIn.pop();
				stackOut.push(num);
			}
		}
		
		return stackOut.peek();
	}
	
	public boolean isEmpty()
	{
		return stackIn.isEmpty()&&stackOut.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[] testData= {1,2,3,4,5};
		TwoStackQueue test=new TwoStackQueue();
		
		for(int i=0;i<3;i++)
		{
			test.add(testData[i]);
		}
		System.out.println(test.peek());
		for(int i=3;i<testData.length;i++)
		{
			test.add(testData[i]);
		}
		
		while(!test.isEmpty())
		{
			System.out.println(test.poll());
		}
	}

}
