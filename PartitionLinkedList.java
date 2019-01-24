
/**
 * give a LinkedList and a integer num
 * divide the LinkedList into three parts
 * the left number are less than num
 * the middle number are equal to num
 * the right number are equal to num
 * @author PC
 *
 */
public class PartitionLinkedList {
	
	private static class Node
	{
		public int value;
		public Node next;
		public Node(int value)
		{
			this.value=value;
		}
	}
	
	public static Node partition1(Node head,int num)//unordered
	{
		if(head==null)return head;
		
		Node cursion=head;
		int len=0;
		while(cursion!=null)
		{
			len++;
			cursion=cursion.next;
		}
		
		Node[] auxArray=new Node[len];
		cursion=head;
		for(int i=0;i<auxArray.length;i++)
		{
			auxArray[i]=cursion;
			cursion=cursion.next;
		}
		partitionArr(auxArray,num);
		for(int i=1;i<auxArray.length;i++)
		{
			auxArray[i-1].next=auxArray[i];
		}
		auxArray[auxArray.length-1].next=null;
		return auxArray[0];
		
	}
	
	public static Node partition2(Node head,int num)//ordered
	{
		Node smallH=null,smallT=null;
		Node equalH=null,equalT=null;
		Node bigH=null,bigT=null;
		
		Node cursion=head;
		Node aux=null;
		while(cursion!=null)
		{
			aux=cursion.next;
			cursion.next=null;
			if(cursion.value<num)
			{
				if(smallH==null)
				{
					smallH=smallT=cursion;
				}
				else
				{
					smallT.next=cursion;
					smallT=cursion;
				}
			}
			else if(cursion.value==num)
			{
				if(equalH==null)
				{
					equalH=cursion;
					equalT=cursion;
				}
				else
				{
					equalT.next=cursion;
					equalT=cursion;
				}
			}
			else
			{
				if(bigH==null)
				{
					bigH=cursion;
					bigT=cursion;
				}
				else
				{
					bigT.next=cursion;
					bigT=cursion;
				}
			}
			cursion=aux;
		}
		
		if(smallH!=null)
		{
			smallT.next=equalH;
			equalT=equalT==null?smallT:equalT;
		}
		
		if(equalT!=null)
		{
			equalT.next=bigH;
		}
		
		if(smallH==null)
		{
			if(equalH==null)
			{
				return bigH;
			}
			else
			{
				return equalH;
			}
		}
		else
		{
			return smallH;
		}
	}
	
	public static void partitionArr(Node[] array,int num)
	{
		int lo=-1;
		int hi=array.length;
		int index=0;
		while(index!=hi)
		{
			if(array[index].value<num)
			{
				lo++;
				swap(array,lo,index);
				index++;
			}
			else if(array[index].value==num)
			{
				index++;
			}
			else
			{
				hi--;
				swap(array,hi,index);
			}
		}
	}
	
	public static void  swap(Node[] array,int a,int b)
	{
		Node temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	public static Node createList()
	{
		Node head=new Node(2);
		Node newNode=new Node(1);
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
		Node head=PartitionLinkedList.createList();
		head=PartitionLinkedList.partition2(head, 2);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
