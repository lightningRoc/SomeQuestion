
/**
 * give a LinkedList and a integer num
 * delete nodes whose value are num
 * @author PC
 *
 */
public class DeleteSelectedNode {
	
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
	
	public static Node deleteNode(Node head,int num)
	{
		while(head!=null)
		{
			if(head.value!=num)
			{
				break;
			}
			else
			{
				head=head.next;
			}
		}
		if(head==null)return head;
		Node pre=head;
		Node cursion=head.next;
		while(cursion!=null)
		{
			if(cursion.value==num)
			{
				pre.next=cursion.next;
			}
			else
			{
				pre=cursion;
			}
			cursion=cursion.next;
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
		Node head=DeleteSelectedNode.createList();
		head=DeleteSelectedNode.deleteNode(head, 2);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
