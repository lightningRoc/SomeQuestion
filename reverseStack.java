import java.util.Stack;

public class reverseStack {
	//reverse a stack by using recursion
	
	private int popTheLast(Stack<Integer> s)
	{
		int num=s.pop();
		if(s.isEmpty())
		{
			return num;
		}
		else
		{
			int last=popTheLast(s);
			s.push(num);
			return last;
		}
	}
	
	public void reverse(Stack<Integer> s)
	{
		if(s.isEmpty())
		{
			return;
		}
		
		int num=popTheLast(s);
		reverse(s);
		s.push(num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Stack<Integer> testStack=new Stack<Integer>();
		for(int i=1;i<=5;i++)
		{
			testStack.push(i);
		}
		reverseStack test=new reverseStack();
		test.reverse(testStack);
		
		while(!testStack.isEmpty())
		{
			System.out.println(testStack.pop());
		}
	}

}
