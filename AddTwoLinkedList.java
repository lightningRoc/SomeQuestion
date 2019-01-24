import java.util.Stack;

/**
 * give two LinkedList(it's nodes represent a integer),adding up them,return a LinkedList that represent the sum
 * 1->2->3 + 1->2->3=123+123=246
 * return 2->4->6
 * @author PC
 *
 */
public class AddTwoLinkedList {
	
	private static class Node
	{
		public int value;
		public Node next;
		public Node(int value)
		{
			this.value=value;
			this.next=null;
		}
	}
	
	public static Node addTwoList(Node head1,Node head2)
	{
		Stack<Integer> s1=new Stack<Integer>();
		Stack<Integer> s2=new Stack<Integer>();
		
		Node cursion=head1;
		while(cursion!=null)
		{
			s1.push(cursion.value);
			cursion=cursion.next;
		}
		cursion=head2;
		while(cursion!=null)
		{
			s2.push(cursion.value);
			cursion=cursion.next;
		}
		
		int carry=0;
		int num1=0,num2=0,sum=0;
		Node res=null;
		while(!s1.isEmpty()||!s2.isEmpty())
		{
			num1=s1.isEmpty()?0:s1.pop();
			num2=s2.isEmpty()?0:s2.pop();
			sum=num1+num2+carry;
			if(sum>=10)
			{
				sum-=10;
				carry=1;
			}
			else
			{
				carry=0;
			}
			Node p=new Node(sum);
			p.next=res;
			res=p;
		}
		
		if(carry==1)
		{
			Node p=new Node(1);
			p.next=res;
			res=p;
		}
		
		return res;
	}
	
	public static Node createList()
	{
		Node head=new Node(3);
		Node newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		newNode=new Node(5);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head1=AddTwoLinkedList.createList();
		Node head2=AddTwoLinkedList.createList();
		Node res=AddTwoLinkedList.addTwoList(head1, head2);
		while(res!=null) 
		{
			System.out.print(res.value+" ");
			res=res.next;
		}
	}

}
