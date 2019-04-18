public class CreateBST
{
	public static void main(String[] args)
	{
	
		/*
						------	
						Node 1
						 '30'
						------
						/    \
				 ------        ------
				 Node 2	       Node 3
				  '15'			'85'
				 ------        ------
				 /    \        /    \
		  ------    ------  -----   ---
		  Node 4    Node 5  Node6    ---
		   '1'       '22'	 '54'
		  ------    ------  -----   
		  
		*/
		
		// Create empty tree
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		// Insertions
		bst.insert(30);
		bst.insert(15);
		bst.insert(1);
		bst.insert(22);
		bst.insert(85);
		bst.insert(54);
		bst.insert(100);
		
		// Print Tree
		bst.printTree();
		
		// Find
		Integer num = bst.find(100);
		if (num == null)	
			System.out.println("Not Found!");
		else
			System.out.println(num + " Found!");
		
		
		System.out.println(bst.printSum());
	}
}
