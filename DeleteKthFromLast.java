

/**
 * delete the kth from last Node of a LinkedList
 * @author PC
 *
 */
public class DeleteKthFromLast {
	
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
	
	public static Node deleteKthLastNode(Node head,int k)
	{
		if(head==null||k<1)
		{
			return head;
		}
		
		Node n=head;
		while(n!=null)
		{
			k--;
			n=n.next;
		}
		if(k==0)
		{
			head=head.next;
		}
		if(k<0)
		{
			n=head;
			while(++k!=0)
			{
				n=n.next;
			}
			n.next=n.next.next;
		}
		
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
		Node head=DeleteKthFromLast.createList();
		DeleteKthFromLast.deleteKthLastNode(head, 2);
		Node cursion=head;
		while(cursion!=null)
		{
			System.out.print(cursion.value+" ");
			cursion=cursion.next;
		}
	}

}
