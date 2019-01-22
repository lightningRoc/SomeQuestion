import java.util.Stack;

/**
 * judge a LinkedList if it's a palindrome
 * @author PC
 *
 */
public class PalindromeLinkedList {
	
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
	
	public static boolean isPalindrome1(Node head)//space:O(n)
	{
		if(head==null||head.next==null)return true;
		
		Stack<Node> aux=new Stack<Node>();
		Node cursion=head;
		while(cursion!=null)
		{
			aux.push(cursion);
			cursion=cursion.next;
		}
		
		while(head!=null)
		{
			if(head.value!=aux.pop().value)
			{
				return false;
			}
			head=head.next;
		}
		
		return true;
	}
	
	public static boolean isPalindrome2(Node head)//space:O(n/2)
	{
		if(head==null||head.next==null)return true;
		
		Node midN=head.next;
		Node cursion=head;
		while(cursion.next!=null&&cursion.next.next!=null)
		{
			midN=midN.next;
			cursion=cursion.next.next;
		}
		Stack<Node> aux=new Stack<Node>();
		while(midN!=null)
		{
			aux.push(midN);
			midN=midN.next;
		}
		while(!aux.isEmpty())
		{
			if(head.value!=aux.pop().value)
			{
				return false;
			}
			head=head.next;
		}
		
		return true;
	}
	
	public static boolean isPalindrome3(Node head)//space:O(1)
	{
		if(head==null||head.next==null)return true;
		
		Node midN=head.next;
		Node cursion=head;
		while(cursion.next!=null&&cursion.next.next!=null)
		{
			midN=midN.next;
			cursion=cursion.next.next;
		}
		
		midN=reverseList(midN);
		while(midN!=null)
		{
			if(midN.value!=head.value)
			{
				return false;
			}
			head=head.next;
			midN=midN.next;
		}
		
		return true;
	}
	
	public static Node reverseList(Node head)
	{
		if(head==null)return head;
		Node cursion=head;
		Node aux=null;
		head=null;
		
		while(cursion!=null)
		{
			aux=cursion.next;
			cursion.next=head;
			head=cursion;
			cursion=aux;
		}
		
		return head;
	}
	
	public static Node createList()
	{
		Node head=new Node(3);
		Node newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		newNode=new Node(3);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=PalindromeLinkedList.createList();
		System.out.println(PalindromeLinkedList.isPalindrome3(head));
	}

}
