import java.util.HashSet;

/**
 * give a LinkedList
 * delete the repetitive node
 * @author PC
 *
 */
public class DeleteRepetitiveNode {
	
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
	
	public static void deleteRep(Node head)
	{
		if(head==null)return;
		
		HashSet<Integer> set=new HashSet<>();
		Node cursion=head.next;
		Node pre=head;
		set.add(head.value);
		while(cursion!=null)
		{
			if(set.contains(cursion.value))
			{
				pre.next=cursion.next;
			}
			else
			{
				set.add(cursion.value);
				pre=cursion;
			}
			cursion=cursion.next;
		}
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
		Node head=DeleteRepetitiveNode.createList();
		DeleteRepetitiveNode.deleteRep(head);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
