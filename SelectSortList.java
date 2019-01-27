
/**
 * using Selection Sort to sort a LinkedList
 * @author PC
 *
 */
public class SelectSortList {
	
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
	
	public static Node selectSort(Node head)
	{
		if(head==null||head.next==null)return head;
		
		Node resH=null;
		Node resT=null;
		Node pre=head;
		while(head!=null)
		{
			Node cursion=head;
			Node nextN=head;
			Node nextPre=null;
			while(cursion!=null)
			{
				if(cursion.value<nextN.value)
				{
					nextPre=pre;
					nextN=cursion;
				}
				pre=cursion;
				cursion=cursion.next;
			}
			
			if(nextPre==null)
			{
				head=head.next;
			}
			else
			{
				nextPre.next=nextN.next;
			}
			
			if(resH==null)
			{
				resH=resT=nextN;
			}
			else
			{
				resT.next=nextN;
				resT=nextN;
			}
			resT.next=null;
		}
		
		return resH;
	}
	
	public static Node createList()
	{
		Node head=new Node(3);
		Node newNode=new Node(2);
		newNode.next=head;
		head=newNode;
		newNode=new Node(5);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=SelectSortList.createList();
		head=SelectSortList.selectSort(head);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
