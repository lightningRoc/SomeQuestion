
/**
 * traversing tree by recursion
 * @author PC
 *
 */
public class TraverseTreeRecursion {
	
	private static class Node
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
	}
	
	public static void preOrder(Node root)
	{
		if(root==null)return;
		
		System.out.print(root.value+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root)
	{
		if(root==null)return;
		
		inOrder(root.left);
		System.out.print(root.value+" ");
		inOrder(root.right);
	}
	
	public static void postOrder(Node root)
	{
		if(root==null)return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.value+" ");
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
		Node root=TraverseTreeRecursion.createTree();
		TraverseTreeRecursion.preOrder(root);
		System.out.println();
		TraverseTreeRecursion.inOrder(root);
		System.out.println();
		TraverseTreeRecursion.postOrder(root);
	}

}
