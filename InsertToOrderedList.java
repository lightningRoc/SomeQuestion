
/**
 * give a circular ordered LinkedList and a integer num
 * insert a Node whose value is num to the LinkedList correctly
 * @author PC
 *
 */
public class InsertToOrderedList {
	
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
	
	public static Node insertNode(Node head,int num)
	{
		Node newNode=new Node(num);
		if(head==null)
		{
			newNode.next=newNode;
			return newNode;
		}
		Node pre=head;
		Node cursion=head.next;
		while(cursion!=head)
		{
			if(pre.value<=num&&cursion.value>=num)
			{
				break;
			}
			pre=cursion;
			cursion=cursion.next;
		}
		
		pre.next=newNode;
		newNode.next=cursion;
		if(head.value<num)return head;
		else return newNode;
	}
	
	public static Node createList()
	{
		Node head=new Node(5);
		Node tail=head;
		Node newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		newNode=new Node(3);
		newNode.next=head;
		head=newNode;
		newNode=new Node(2);
		newNode.next=head;
		head=newNode;
		newNode=new Node(2);
		newNode.next=head;
		head=newNode;
		tail.next=head;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=InsertToOrderedList.createList();
		head=InsertToOrderedList.insertNode(head, 3);
		Node cursion=head.next;
		System.out.print(head.value+" ");
		cursion=head.next;
		while(cursion!=head)
		{
			System.out.print(cursion.value+" ");
			cursion=cursion.next;
		}
	}

}
