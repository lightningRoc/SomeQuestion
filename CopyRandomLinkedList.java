import java.util.HashMap;

/**
 * give a special LinkedList
 * it's Nodes have a random Node variable
 * copy the LinkedList
 * @author PC
 *
 */
public class CopyRandomLinkedList {
	
	private static class Node
	{
		public int value;
		public Node next;
		public Node rand;
		
		public Node(int value)
		{
			this.value=value;
			this.next=null;
			this.rand=null;
		}
	}
	
	public static Node copyList1(Node head)//space:O(n)
	{
		HashMap<Node,Node> map=new HashMap<Node,Node>();
		Node cursion=head;
		while(cursion!=null)
		{
			map.put(cursion, new Node(cursion.value));
			cursion=cursion.next;
		}
		
		cursion=head;
		while(cursion!=null)
		{
			map.get(cursion).next=map.get(cursion.next);
			map.get(cursion).rand=map.get(cursion.rand);
			cursion=cursion.next;
		}
		return map.get(head);
	}
	
	public static Node copyList2(Node head)//space:O(1)
	{
		if(head==null)return head;
		Node cursion=head;
		Node next=null;
		Node aux;
		while(cursion!=null)
		{
			aux=cursion.next;
			next=new Node(cursion.value);
			next.next=cursion.next;
			cursion.next=next;
			cursion=aux;
		}
		cursion=head;
		while(cursion!=null)
		{
			if(cursion.rand!=null)
			{
				cursion.next.rand=cursion.rand;
			}
			cursion=cursion.next.next;
		}
		
		Node resH=head.next;
		cursion=resH;
		aux=null;
		while(cursion.next!=null)
		{
			aux=cursion.next.next;
			cursion.next=cursion.next.next;
			cursion=aux;
		}
		
		return resH;
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
		newNode=new Node(1);
		newNode.next=head;
		head=newNode;
		
		Node cursion=head;
		cursion.rand=cursion.next.next;
		cursion=cursion.next;
		cursion.rand=cursion.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=CopyRandomLinkedList.createList();
		head=CopyRandomLinkedList.copyList2(head);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			if(head.rand!=null)
			{
				System.out.println(head.rand.value);
			}
			else
			{
				System.out.println();
			}
			head=head.next;
		}
	}

}
