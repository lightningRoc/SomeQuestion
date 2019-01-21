
/**
 * give a integer from and to
 * reverse a part(from 'from' to 'to') of a LinkedList
 * @author PC
 *
 */
public class ReversePartOfLinkedList {
	
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
	
	public static Node reversePartOfList(Node head,int from,int to)
	{
		int len=0;
		Node cursion=head;
		Node fromPre=null;
		Node fromN=null;
		Node toPost=null;
		Node toN=null;
		while(cursion!=null)
		{
			len++;
			if(len==from-1)fromPre=cursion;
			if(len==to)toN=cursion;
			if(len==to+1)toPost=cursion;
			cursion=cursion.next;
		}
		if(from>to||from<1||to>len)
		{
			return head;
		}
		
		if(fromPre==null)
		{
			fromN=head;
		}
		else 
		{
			fromN=fromPre.next;
			fromPre.next=toPost;
		}
		toN.next=null;
		System.out.println(fromN.value+" "+toN.value);
		
		while(fromN!=null)
		{
			cursion=fromN;
			fromN=fromN.next;
			cursion.next=toPost;
			toPost=cursion;
		}
		
		if(fromPre!=null)
		{
			fromPre.next=toPost;	
		}
		else head=toPost;
		
		return head;
	}
	
	
	
	
	public static Node createList()
	{
		Node head=new Node(3);
		Node newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		newNode=new Node(2);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data 
		Node head=ReversePartOfLinkedList.createList();
		head=ReversePartOfLinkedList.reversePartOfList(head, 2,3);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
