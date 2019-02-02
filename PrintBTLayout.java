import java.util.LinkedList;
import java.util.Queue;

/**
 * give a binary tree
 * print the tree(a layout occupies a line)
 * @author PC
 *
 */
public class PrintBTLayout {
	
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
	
	public static void traverse(Node root)
	{
		if(root==null)return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int layout=1;
		while(!q.isEmpty())
		{
			System.out.print("layout "+layout+":");
			int len=q.size();
			for(int i=0;i<len;i++)
			{
				Node n=q.poll();
				System.out.print(n.value+" ");
				if(n.left!=null)q.add(n.left);
				if(n.right!=null)q.add(n.right);
			}
			layout++;
			System.out.println();
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
		Node root=PrintBTLayout.createTree();
		PrintBTLayout.traverse(root);
	}

}
