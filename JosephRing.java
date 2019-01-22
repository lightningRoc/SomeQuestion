
/**
 * joseph ring
 * @author PC
 *
 */
public class JosephRing {
	
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
	
	public static Node josephRing1(Node head,int m)//O(n*m)
	{
		if(head==null||head.next==head||m<1)
		{
			return head;
		}
		
		Node cursion=head;
		while(cursion.next!=head)
		{
			cursion=cursion.next;
		}
		int count=0;
		while(head!=cursion)
		{
			if(++count==m)
			{
				cursion.next=head.next;
				count=0;
			}
			else
			{
				cursion=cursion.next;
			}
			head=cursion.next;
		}
		
		return head;
	}
	
	public static Node josephRing2(Node head,int m)//O(n)
	{
		if(head==null||head.next==head||m<1)
		{
			return head;
		}
		Node cursion=head.next;
		int len=1;
		while(cursion!=head)
		{
			len++;
			cursion=cursion.next;
		}
		int res=getResult(len,m);
		while(--res!=0)
		{
			head=head.next;
		}
		head.next=head;
		return head;
		
	}
	
	private static int getResult(int i,int m)
	{
		if(i==1)return 1;
		return (getResult(i-1,m)+m-1)%i+1;
	}
	
	public static Node createCircleList()
	{
		Node head=new Node(3);
		Node tail=head;
		Node newNode=new Node(4);
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
		Node head=JosephRing.createCircleList();
		//head=JosephRing.josephRing1(head, 2);
		head=JosephRing.josephRing2(head, 2);
		System.out.println(head.value);
		
	}

}
