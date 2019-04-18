/**
* Implementation of a binary search tree using BinaryNode
*/
public class BinarySearchTree<T extends Comparable<? super T>>
{
	// ==============================
	// Fields
	// ==============================
	private BinaryNode<T> root;
	
	// ==============================
	// Constructor
	// ==============================
	public BinarySearchTree() {root = null;}
	
	
	// =================================================
	// Publicly Accessible Methods
	// =================================================
	
	public T find(T x)
	{
		BinaryNode<T> result = find(x, this.root);
		if (result == null) 
			return null;
		return result.data;
	}
	
	public void insert(T x){root = insert(x, root);}
	
	public void remove(T x){root = remove(x, root);}
	
	public void removeMin() {root = removeMin(root);}
	
	public T findMin() {return (this.findMin(root)).data;}
	
	public void printTree() {TreePrinter.printNode(root);}

	// My own added method
	public int printSum()
	{
		return BinaryNode.sum(root);
	}
	// =================================================
	// Internal Private Methods
	// =================================================
	
	// Recursive Find()
	private BinaryNode<T> find(T x, BinaryNode<T> node)
	{
		if (node == null)
			return null;
		
		// Go left if x is less than current node
		if (x.compareTo(node.data) < 0 )
			return find(x, node.left);
		
		// Go right if x is greater than current node
		if (x.compareTo(node.data) > 0 )
			return find(x, node.right);
		
		// compareTo() returned 0 ====> Found!
		return node; // return the node found with data, x
	}
	
	// Iterative Find()
	/**
		private BinaryNode<T> find(T x, BinaryNode<T> node)
		{
			while (node != null)
			{
				if (x.compareTo(node.data) < 0 )
					node = node.getLeft();
				else if (x.compareTo(node.data) > 0 )
					node = node.right;
				else
					return node; // compareTo() returned 0 ====> Found!
			}
			return null; // was not found
		}
	*/
	
	// Find Min - Iterative, since its very simple
	private BinaryNode<T> findMin(BinaryNode<T> node)
	{
		if (node != null)
			while (node.left != null) 
				node = node.left;
		return node;
	}
	
	// Remove Min
	private BinaryNode<T> removeMin(BinaryNode<T> node) 
	{
		if (node == null)
			throw new ItemNotFoundException();
		if (node.left != null)
		{	node.left = removeMin(node.left);
			return node; 
		}
		return node.right;
	}
	
	// Insert
	private BinaryNode<T> insert(T x, BinaryNode<T> node)
	{
		if (node == null)
			node = new BinaryNode<T>(x);
		else if (x.compareTo(node.data) < 0)
			node.left = insert(x, node.left);
		else if (x.compareTo(node.data) > 0)
			node.right = insert(x, node.right);
		else
			throw new DuplicateItemException( x.toString() );
		return node; // return the newly inserted node with given data, x
		
	}
	
	// Remove
	private BinaryNode<T> remove(T x, BinaryNode<T> node)
	{
		// Tree is empty/Not found
		if (node == null)
			throw new ItemNotFoundException(x.toString());
		
		// Go left or right to look for it
		if (x.compareTo(node.data) < 0)
			node.left = remove(x, node.left);
		else if (x.compareTo(node.data) > 0)
			node.right = remove(x, node.right);
		
		// Found it at this point (compareTo returned 0)
		
		// Removal CASES:
		// If node has two children
		else if (node.left != null && node.right != null)
		{
			node.data = (findMin(node.right)).data; 
			node.right = removeMin(node.right);
		}

		// At this point, right child could be null, left child could be null, or both children can be null
		
		// If node has one child (left child, right child must be null)
		else if (node.left != null) 
			node = node.left;
		
		// If node has one child (right child, left child must be null) OR both children are null
		else
			node = node.right;
		
		return node;
	}	
}
