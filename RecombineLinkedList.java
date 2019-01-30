
/**
 * give a LinkedList
 * divide it into two parts(leftPart(1 to floor(len/2),rightPart(floor(len/2)+1 to len)
 * return a new LinkedList(left1->right1->left2->right2->...)
 * @author PC
 *
 */
public class RecombineLinkedList {
	
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
	
	public static Node relocate(Node head)
	{
		if(head==null||head.next==null)return head;
		
		Node resH=null;
		Node resT=null;
		Node mid=findMid(head);
		Node left=head;
		Node right=mid.next;
		mid.next=null;
		
		while(left!=null||right!=null)
		{
			if(resH==null)
			{
				resH=left;
				left=left.next;
				resH.next=resT=right;
				right=right.next;
			}
			else if(left==null)
			{
				resT.next=right;
				break;
			}
			else
			{
				resT.next=left;
				left=left.next;
				resT=resT.next;
				resT.next=right;
				right=right.next;
				resT=resT.next;
			}
		}
		
		return resH;
	}
	
	private static Node findMid(Node head)
	{
		Node mid=head;
		Node cursion=head.next;
		while(cursion.next!=null&&cursion.next.next!=null)
		{
			mid=mid.next;
			cursion=cursion.next.next;
		}
		
		return mid;
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
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=RecombineLinkedList.createList();
		head=RecombineLinkedList.relocate(head);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
