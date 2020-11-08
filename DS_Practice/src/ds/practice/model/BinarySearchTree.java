package ds.practice.model;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private int nodeCount=0;
	
	private Node root = null;
	
	private class Node
	{
		T data;
		Node left, right;
		
		public Node(Node left, Node right, T elem) 
		{
			this.data = elem;
			this.left = left;
			this.right = right;
		}
	}
	
	public boolean isEmpty() 
	{
		return size() ==0;
	}
	
	private int size()
	{
		return nodeCount;
	}
	
	public boolean add(T elem) 
	{
		if(contains(elem))
			return false;
		else 
		{
			root = add(root,elem);
			nodeCount++;
			return true;
		}
	}
	
	private Node add(Node node, T elem) 
	{
		if(node == null)
			node = new Node(null,null,elem);
		else 
		{
			if(elem.compareTo(node.data)<0)
				node.left = add(node.left,elem);
			else
				node.right= add(node.right,elem);
		}
		return node;
	}
	
	public boolean contains(T elem) 
	{
		return contains(root, elem);
	}
	
	private boolean contains(Node node, T elem) 
	{
		if(node == null)
			return false;
		else 
		{
			int cmp = elem.compareTo(node.data);
			//Dig into the left subtree
			if(cmp < 0)
				return contains(node.left, elem);
			//Dig into right subtree
			else if (cmp >0)
				return contains(node.right, elem);
			//Found the node
			else return true;
		}
	}
	
	public boolean remove(T elem) 
	{
		if(contains(elem)) 
		{
			root = remove(root,elem);
			nodeCount --;
			return true;
		}
		return false;
	}
	
	private Node remove(Node node, T elem) 
	{
		if(node == null) return null;
		
		int cmp = elem.compareTo(node.data);
		
		if(cmp < 0)
			node.left = remove(node.left,elem);
		else if(cmp>0)
			node.right= remove(node.right,elem);
		else 
		{
			if(node.left == null) 
			{
				Node rightChild = node.right;
				node.data = null;
				node = null;
				return rightChild;
			}
			else if(node.right == null) 
			{
				Node leftChild = node.left;
				node.data = null;
				node =  null;
				return leftChild;
			}
			else 
			{
				Node temp = findMin(node.right);
				node.data = temp.data;
				node.right = remove(node.right,temp.data);
				
//				Node temp = findMax(node.left);
//				node.data = temp.data;
//				node.left = remove(node.left,temp.data);
			}
		}
		
		return node;
	}
	
	private Node findMin(Node node) 
	{
		while(node.left != null) node = node.left;
		return node;
	}
	
	private Node findMax(Node node) 
	{
		while(node.right != null) node = node.right;
		return node;
	}

}
