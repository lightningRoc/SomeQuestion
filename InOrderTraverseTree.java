import java.util.Stack;

/**
 * traversing tree by inOrderTraverse by not recursion
 * @author PC
 *
 */
public class InOrderTraverseTree {
	
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
	
	public static void inOrder(Node root) 
	{
		if(root!=null)
		{
			Stack<Node> aux=new Stack<>();
			while(!aux.isEmpty()||root!=null)
			{
				if(root!=null)
				{
					aux.push(root);
					root=root.left;
				}
				else
				{
					root=aux.pop();
					System.out.print(root.value+" ");
					root=root.right;
				}
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
		Node root=InOrderTraverseTree.createTree();
		InOrderTraverseTree.inOrder(root);
	}

}
