
/**
 * reverse a LinkedList
 * @author PC
 *
 */
public class ReverseLinkedList {
	
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
		newNode=new Node(2);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=ReverseLinkedList.createList();
		head=ReverseLinkedList.reverseList(head);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
