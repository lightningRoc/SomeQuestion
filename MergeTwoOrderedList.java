
/**
 * give two ordered LinkedList
 * merge them,return a ordered LinkedList
 * @author PC
 *
 */
public class MergeTwoOrderedList {
	
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
	
	public static Node mergeList(Node head1,Node head2)
	{
		if(head1==null||head2==null)
		{
			if(head1==null)return head2;
			else return head1;
		}
		Node resH=null;
		Node resT=null;
		while(head1!=null||head2!=null)
		{
			if(head1==null||head1.value>head2.value)
			{
				if(resH==null)
				{
					resH=resT=head2;
				}
				else
				{
					resT.next=head2;
					resT=resT.next;
				}
				
				head2=head2.next;
			}
			else
			{
				if(resH==null)
				{
					resH=resT=head1;
				}
				else
				{
					resT.next=head1;
					resT=resT.next;
				}
				
				head1=head1.next;
			}
		}
		return resH;
	}
	
	public static Node createList()
	{
		Node head=new Node(5);
		Node newNode=new Node(4);
		newNode.next=head;
		head=newNode;
		newNode=new Node(3);
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
		Node head1=MergeTwoOrderedList.createList();
		Node head2=MergeTwoOrderedList.createList();
		Node res=MergeTwoOrderedList.mergeList(head1, head2);
		while(res!=null)
		{
			System.out.print(res.value+" ");
			res=res.next;
		}
	}

}
