import java.util.LinkedList;
import java.util.Queue;

/**
 * give a binary tree
 * serialize the tree and unserialize it
 * @author PC
 *
 */
public class SerializeBinaryTree {
	
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
	
	public static String serialize(Node root)
	{
		if(root==null)return "#";
		String res=root.value+"";
		res+=" "+serialize(root.left);
		res+=" "+serialize(root.right);
		return res;
	}
	
	public static Node unserialize(String res)
	{
		String[] values=res.split(" ");
		Queue<String> queue=new LinkedList<String>();
		for(int i=0;i<values.length;i++)queue.add(values[i]);
		
		return unserialize(queue);
	}
	
	public static Node unserialize(Queue<String> queue)
	{
		String value=queue.poll();
		if(value.equals("#"))return null;
		Node root=new Node(Integer.valueOf(value));
		root.left=unserialize(queue);
		root.right=unserialize(queue);
		return root;
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
		Node root=SerializeBinaryTree.createTree();
		String res=SerializeBinaryTree.serialize(root);
		System.out.println(res);
		root=SerializeBinaryTree.unserialize(res);
		res=SerializeBinaryTree.serialize(root);
		System.out.println(res);
	}

}
