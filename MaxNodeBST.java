import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * give a tree
 * find the biggest root's BST(has the maximum nodes and contain the root) of it
 * return the subTree's root
 * @author PC
 *
 */
public class MaxNodeBST {
	
	private static class Node
	{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value)
		{
			this.value=value;
		}
	}
	
	public static int rootBST1(Node root)//O(n^2)
	{
		if(root==null)return 0;
		int res=1;
		Queue<Node> q=new LinkedList<Node>();
		if(root.left!=null)q.add(root.left);
		if(root.right!=null)q.add(root.right);
		while(!q.isEmpty())
		{
			Node next=q.poll();
			if(canIn(root,next))
			{
				if(next.left!=null)q.add(next.left);
				if(next.right!=null)q.add(next.right);
				res++;
			}
		}
		
		return res;
	}
	
	private static boolean canIn(Node root,Node node)
	{		
		if(root.value==node.value)return true;
		else if(root.left==null&&root.right==null)return false;
		else if(root.value>node.value)return canIn(root.left,node);
		else return canIn(root.right,node);
	}
	
	private static class Record
	{
		public int left;
		public int right;
		
		public Record(int left,int right)
		{
			this.left=left;
			this.right=right;
		}
	}
	
	public static int rootBST2(Node root)
	{
		Map<Node,Record> map=new HashMap<Node,Record>();
		return rootBST2(root,map);
	}
	
	private static int rootBST2(Node root,Map<Node,Record> map)
	{
		if(root==null)return 0;
		int left=rootBST2(root.left,map);
		int right=rootBST2(root.right,map);
		calculate(root.left,root.value,map,true);
		calculate(root.right,root.value,map,false);
		Record l=map.get(root.left);
		Record r=map.get(root.right);
		int lBST=l==null?0:l.left+l.right+1;
		int rBST=r==null?0:r.left+r.right+1;
		map.put(root, new Record(lBST,rBST));
		return lBST+rBST+1;
		
	}
	
	private static int calculate(Node root,int value,Map<Node,Record> map,boolean sign)
	{
		if(root==null||(!map.containsKey(root)))return 0;
		Record r=map.get(root);
		if((sign&&root.value>value)||((!sign)&&root.value<value))
		{
			map.remove(root);
			return r.left+r.right+1;
		}
		else
		{
			int res=calculate(sign?root.right:root.left,value,map,sign);
			if(sign)
			{
				r.right=r.right-res;
			}
			else
			{
				r.left=r.left-res;
			}
			map.put(root, r);
			return res;
		}
	}
	
	public static Node createTree()
	{
		Node root=new Node(4);
		Node p=new Node(5);
		root.left=p;
		p=new Node(6);
		root.right=p;
		
		p=root.left;
		Node q=new Node(1);
		p.left=q;
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node root=MaxNodeBST.createTree();
		System.out.println(MaxNodeBST.rootBST1(root));
		System.out.println(MaxNodeBST.rootBST2(root));
	}

}
