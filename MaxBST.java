
/**
 * give a tree
 * find the biggest BST(has the maximum nodes) of it
 * return the subTree's root
 * @author PC
 *
 */
public class MaxBST {
	
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
	
	public static Node biggestBST(Node root)
	{
		int[] record=new int[3];
		return biggestBST(root,record);
	}
	
	private static Node biggestBST(Node root,int[] record)
	{
		if(root==null)
		{
			record[0]=0;
			record[1]=Integer.MAX_VALUE;
			record[2]=Integer.MIN_VALUE;
			return null;
		}
		int value=root.value;
		Node left=root.left;
		Node right=root.right;
		Node lBST=biggestBST(left,record);
		int lSize=record[0];
		int lMin=record[1];
		int lMax=record[2];
		Node rBST=biggestBST(right,record);
		int rSize=record[0];
		int rMin=record[1];
		int rMax=record[2];
		record[1]=Math.min(lMin,value);
		record[2]=Math.max(rMax, value);
		if(left==lBST&&right==rBST&&lMax<value&&value<rMin)
		{
			record[0]=lSize+rSize+1;
			return root;
		}
		record[0]=Math.max(lSize, rSize);
		if(lSize>rSize)return lBST;
		else return rBST;
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
		Node root=MaxBST.createTree();
		System.out.println(MaxBST.biggestBST(root).value);
	}

}
