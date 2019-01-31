
/**
 * give a binary tree
 * print it's edgeNode counterclockwise
 * edgeNode:
 * 1¡¢the root
 * 2¡¢the leaf
 * 3¡¢the layer's edge nodes
 * @author PC
 *
 */
public class PrintBTEdgeNode {
	
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
	
	public static void printEdge(Node root)
	{
		if(root==null)return;
		int height=getTreeHeight(root,0);
		Node[][] edgeMap=new Node[height][2];
		setEdgeMap(root,0,edgeMap);
		for(int i=0;i<edgeMap.length;i++)System.out.print(edgeMap[i][0].value+" ");
		printLeafRemain(root,0,edgeMap);
		for(int i=edgeMap.length-1;i>=0;i--)
		{
			if(edgeMap[i][0]!=edgeMap[i][1])System.out.print(edgeMap[i][1].value+" ");
		}
	}
	
	public static int getTreeHeight(Node root,int height)
	{
		if(root==null)return height;
		
		return Math.max(getTreeHeight(root.left,height+1), getTreeHeight(root.right,height+1));
	}
	
	public static void setEdgeMap(Node root,int n,Node[][] edgeMap)
	{
		if(root==null)return;
		
		edgeMap[n][0]=edgeMap[n][0]==null?root:edgeMap[n][0];
		edgeMap[n][1]=root;
		setEdgeMap(root.left,n+1,edgeMap);
		setEdgeMap(root.right,n+1,edgeMap);
	}
	
	public static void printLeafRemain(Node root,int n,Node[][] m)
	{
		if(root==null)return;
		if(root.left==null&&root.right==null&&root!=m[n][0]&&root!=m[n][n])
		{
			System.out.print(root.value+" ");
		}
		printLeafRemain(root.left,n+1,m);
		printLeafRemain(root.right,n+1,m);
	}
	public static Node createTree()
	{
		Node root=new Node(4);
		Node p=new Node(2);
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
		Node root=PrintBTEdgeNode.createTree();
		PrintBTEdgeNode.printEdge(root);
	}

}
