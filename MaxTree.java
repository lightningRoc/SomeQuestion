import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * give a array(all element are different),build a MaxTree
 * MaxTree:1¡¢a array's value is a tree's node;
 * 2¡¢to all the subTree,the maximum node is the head node;
 * 3¡¢tree is a binaryTree;
 * @author PC
 *
 */


public class MaxTree {
	
	public static Node getMaxTree(int[] array)
	{
		Node[] res=new Node[array.length];
		for(int i=0;i<array.length;i++)
		{
			res[i]=new Node(array[i]);
		}
		
		Stack<Node> aux=new Stack<Node>();
		HashMap<Node,Node> lBig=new HashMap<Node,Node>();
		HashMap<Node,Node> rBig=new HashMap<Node,Node>();
		
		for(int i=0;i<array.length;i++)
		{
			Node curNode=res[i];
			while((!aux.isEmpty())&&aux.peek().value<curNode.value)
			{
				aux.pop();
			}
			if(aux.isEmpty())lBig.put(curNode,null);
			else lBig.put(curNode, aux.peek());
			
			aux.push(curNode);
		}
		aux=new Stack<Node>();
		
		for(int i=array.length-1;i>=0;i--)
		{
			Node curNode=res[i];
			while((!aux.isEmpty())&&aux.peek().value<curNode.value)
			{
				aux.pop();
			}
			if(aux.isEmpty())rBig.put(curNode,null);
			else rBig.put(curNode, aux.peek());
			
			aux.push(curNode);
		}
		
		Node head=null;
		for(int i=0;i<res.length;i++)
		{
			Node curNode=res[i];
			Node left=lBig.get(curNode);
			Node right=rBig.get(curNode);
			
			if(left==null&&right==null)
			{
				head=curNode;
			}
			else if(left==null)
			{
				if(right.left!=null)
				{
					right.right=curNode;
				}
				else
				{
					right.left=curNode;
				}
			}
			else if(right==null)
			{
				if(left.left!=null)
				{
					left.right=curNode;
				}
				else
				{
					left.left=curNode;
				}
			}
			else
			{
				if(left.value<right.value)
				{
					if(left.left!=null)
					{
						left.right=curNode;
					}
					else
					{
						left.left=curNode;
					}
				}
				else
				{
					if(right.left!=null)
					{
						right.right=curNode;
					}
					else
					{
						right.left=curNode;
					}
				}
			}
		}
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		
		int[] test= {3,4,5,1,2};
		Node head=MaxTree.getMaxTree(test);
		Queue<Node> q=new LinkedList<Node>();
		q.add(head);
		while(!q.isEmpty())
		{
			int end=q.size();
			for(int i=0;i<end;i++)
			{
				Node curNode=q.poll();
				
				System.out.print("Node "+curNode.value+":");
				
				if(curNode.left!=null)
				{
					q.add(curNode.left);
					System.out.print(" left:"+curNode.left.value);
				}
				if(curNode.right!=null)
				{
					q.add(curNode.right);
					System.out.print(" right:"+curNode.right.value);
				}
				System.out.println("");
			}
			
		}
	}

}

class Node
{
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value)
	{
		this.value=value;
		this.left=null;
		this.right=null;
	}
	
	public Node()
	{
		this.value=0;
		this.left=null;
		this.right=null;
	}
}
