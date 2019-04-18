/**
* WEISS edition BinaryNode
* @author Mark Allen Weiss
*/
public class BinaryNode<T>
{
	// =====================
	// Fields
	// =====================
	protected T data;
	protected BinaryNode<T> left;
	protected BinaryNode<T> right;
	
	// =====================
	// Constructors
	// =====================
	
	public BinaryNode() {this(null);} //Constructs an empty node
	
	public BinaryNode(T data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	// =====================
	// Traversals
	// =====================
	
	// Prints the node first, then goes to the left or right node
	// Print, then go left, then go right
	// Print before you see any children
	public void printPreOrder() 
	{
		System.out.println(data);
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}
	
	// Goes to the left node, prints it, and then goes to the right node
	// Go left, print, go right
	public void printInOrder() 
	{
		if (left != null)
			left.printInOrder();
		System.out.println(data);
		if (right != null)
			right.printInOrder();	
	}
	
	// Traverses thru all nodes first, prints each node in reverse starting with last node up to the root
	// Go left, go right, then print
	// Print after you've seen all children
	public void printPostOrder() 
	{
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		System.out.println(data);
	}
	
	/**
		Alternative static way to print:
		Print all nodes starting from x
		(Post-Order)
	*/
	public static void print(BinaryNode x)
	{
		if (x != null)
		{
			print(x.left);
			print(x.right);
			System.out.println(x.data);
		}
	}
	
	// =====================
	// Other Methods
	// =====================
	
	/**
		Return sum of the data of the nodes starting at x
		// Data must be Integer type when creating tree
	*/
	public static int sum(BinaryNode x)
	{
		if (x != null)
		{
			return ((Integer) x.data) + sum(x.left) + sum(x.right);
		}
		return 0;
	}
	
	// Returns the number of nodes in the tree starting at root node t
	public static <T> int size(BinaryNode<T> t)
	{
		if (t == null)
			return 0;
		return 1 + size(t.left) + size(t.right);
	}
	
	// Returns height of the tree starting at node t
	public static <T> int height(BinaryNode<T> t)
	{
		if (t == null)
			return -1;
		return 1 + Math.max(height(t.left), height(t.right));
	}	
}
