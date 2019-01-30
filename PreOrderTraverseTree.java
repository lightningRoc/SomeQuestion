import java.util.Stack;

/**
 * traversing tree by preOrderTraverse by not recursion
 * @author PC
 *
 */
public class PreOrderTraverseTree {
	
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
		if(root!=null)
		{
			Stack<Node> aux=new Stack<Node>();
			aux.push(root);
			while(!aux.isEmpty())
			{
				root=aux.pop();
				System.out.print(root.value+" ");
				if(root.right!=null)aux.push(root.right);
				if(root.left!=null)aux.push(root.left);
			}
		}
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
		Node root=PreOrderTraverseTree.createTree();
		PreOrderTraverseTree.preOrder(root);
	}

}
