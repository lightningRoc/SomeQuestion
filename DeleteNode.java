
/**
 * give a LinkedList and a Node(not the last node)
 * delete the Node
 * @author PC
 *
 */
public class DeleteNode {
	
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
	
	public static void deleteNode(Node node)
	{
		if(node==null)return;
		
		node.value=node.next.value;
		node.next=node.next.next;
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
		newNode=new Node(2);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=DeleteNode.createList();
		Node node=head.next.next;
		DeleteNode.deleteNode(node);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
