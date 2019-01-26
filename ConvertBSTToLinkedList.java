/**
 * give a BST
 * convert it to a ordered DoubleLinkedList
 * @author PC
 *
 */
public class ConvertBSTToLinkedList {
	
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
	
	public static Node convert(Node root)
	{
		if(root==null)return root;
		Node resT=dfs(root);
		
		Node res=resT.right;
		resT.right=null;
		return res;
	}
	
	public static Node dfs(Node root)
	{
		if(root==null)return null;
		Node leftT=dfs(root.left);
		Node rightT=dfs(root.right);
		if(leftT!=null&&rightT!=null)
		{
			root.right=rightT.right;
			root.left=leftT;	
			rightT.right.left=root;
			
			rightT.right=leftT.right;
			leftT.right=root;
		}
		else if(leftT!=null)
		{
			root.left=leftT;
			root.right=leftT.right;
			leftT.right=root;
			rightT=root;
		}
		else if(rightT!=null)
		{
			root.right=rightT.right;
			rightT.right.left=root;
			rightT.right=root;
		}
		else
		{
			root.right=root;
			rightT=root;
		}
		
		return rightT;
	}
	
	public static Node createBST()
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
	
	public static void test(Node root)
	{
		if(root==null)return;
		System.out.println(root.value);
		test(root.left);
		test(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node root=ConvertBSTToLinkedList.createBST();
		Node head=ConvertBSTToLinkedList.convert(root);
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.right;
		}
		while(head!=null)
		{
			System.out.print(head.value+" ");
			head=head.right;
		}
	}

}
