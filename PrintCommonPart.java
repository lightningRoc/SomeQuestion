
/**
 * give two ordered list,print their common part
 * @author PC
 *
 */
public class PrintCommonPart {
	
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
	
	public static void printCommon(Node head1,Node head2)
	{
		while(head1!=null&&head2!=null)
		{
			if(head1.value<head2.value)
			{
				head1=head1.next;
			}
			else if(head1.value>head2.value)
			{
				head2=head2.next;
			}
			else
			{
				System.out.print(head1.value+" ");
				head1=head1.next;
				head2=head2.next;
			}
		}
	}
	
	public static Node createList1()
	{
		Node head=new Node(3);
		Node newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		return head;
	}
	
	public static Node createList2()
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
		Node head1=PrintCommonPart.createList1();
		Node head2=PrintCommonPart.createList2();
		PrintCommonPart.printCommon(head1, head2);
	}

}
