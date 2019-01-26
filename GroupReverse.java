import java.util.Stack;

/**
 * give a LinkedList
 * reverse every k elements
 * @author PC
 *
 */
public class GroupReverse {
	
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
	
	public static Node reverseK1(Node head,int k)//space:O(n)
	{
		if(k<2)return head;
		
		Stack<Node> s=new Stack<>();
		Node cursion=head;
		Node resT=null;
		Node resH=null;
		while(cursion!=null)
		{
			s.push(cursion);
			if(s.size()==k)
			{
				cursion=cursion.next;
				Node[] res=insert(resH, resT, s, k);
				if(resH==null)resH=res[0];
				resT=res[1];
			}
			else
			{
				cursion=cursion.next;
			}
		}
		if(!s.isEmpty())
		{
			Node[] res=insert(resH, resT, s, k);
			if(resH==null)resH=res[0];
			resT=res[1];
		}
		
		resT.next=null;
		return resH;
	}
	
	private static Node[] insert(Node resH,Node resT,Stack<Node> s,int k)
	{	
		Node head=s.pop();
		Node tail=head;
		if(s.size()>=k-1)
		{
			while(!s.isEmpty())
			{
				tail.next=s.pop();
				tail=tail.next;
			}
		}
		else
		{
			while(!s.isEmpty())
			{
				Node p=s.pop();
				p.next=head;
				head=p;
			}
		}
		 
		if(resT!=null)resT.next=head;
		return new Node[]{head,tail};
	}
	
	public static Node reverseK2(Node head,int k)//space:O(1)
	{
		if(k<2)return head;
		
		Node cursion=head;
		Node resT=null;
		Node resH=null;
		Node auxH=head;
		Node auxT=head;
		int num=0;
		while(cursion!=null)
		{
			num++;
			if(num==k)
			{
				cursion=cursion.next;
				auxT.next=null;
				Node[] res=insert(resH, resT,auxH, k,num);
				if(resH==null)resH=res[0];
				resT=res[1];
				
				auxT=cursion;
				auxH=cursion;
				num=0;
			}
			else
			{
				cursion=cursion.next;
				auxT=cursion;
			}
		}
		if(num!=0)
		{
			Node[] res=insert(resH, resT, auxH, k,num);
			if(resH==null)resH=res[0];
			resT=res[1];
		}
		
		resT.next=null;
		return resH;
	}
	
	private static Node[] insert(Node resH,Node resT,Node auxH,int k,int num)
	{	
		Node head=auxH;
		Node tail=head;
		if(num<k)
		{
			while(tail.next!=null)
			{
				tail=tail.next;
			}
		}
		else
		{
			auxH=auxH.next;
			while(auxH!=null)
			{
				Node p=auxH;
				auxH=auxH.next;
				p.next=head;
				head=p;
			}
		}
		 
		if(resT!=null)resT.next=head;
		return new Node[]{head,tail};
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
		newNode=new Node(3);
		newNode.next=head;
		head=newNode;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node head=GroupReverse.createList();
		head=GroupReverse.reverseK2(head, 3);
		int count=0;
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
		
	}

}
