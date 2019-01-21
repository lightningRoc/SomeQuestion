
/**
 * delete the middle Node of a LinkedList(mid=floor(length/2))
 * @author PC
 *
 */
public class DeleteMidNode {
	
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
	
	public static void deleteMidNode(Node head)
	{
		if(head==null||head.next==null)
		{
			return;
		}
		if(head.next.next==null)
		{
			head=head.next;
		}
		Node target=head;
		Node judge=head.next.next;
		while(judge.next!=null&&judge.next.next!=null)
		{
			target=target.next;
			judge=judge.next.next;
		}
		target.next=target.next.next;
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
		Node head=DeleteMidNode.createList();
		DeleteMidNode.deleteMidNode(head);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
