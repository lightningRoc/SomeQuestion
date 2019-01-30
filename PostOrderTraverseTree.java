import java.util.Stack;

/**
 * traversing tree by postOrderTraverse by not recursion
 * @author PC
 *
 */
public class PostOrderTraverseTree {
	
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
	
	public static void postOrder(Node root)
	{
		if(root!=null)
		{
			Stack<Node> aux1=new Stack<>();
			Stack<Node> aux2=new Stack<>();
			
			aux1.push(root);
			while(!aux1.isEmpty())
			{
				root=aux1.pop();
				aux2.push(root);
				if(root.left!=null)aux1.push(root.left);
				if(root.right!=null)aux1.push(root.right);
			}
			while(!aux2.isEmpty())
			{
				System.out.print(aux2.pop().value+" ");
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
		Node root=PostOrderTraverseTree.createTree();
		PostOrderTraverseTree.postOrder(root);
	}

}
