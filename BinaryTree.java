package ASSIGNMENT.CODE;
/**
 * Please provide your student ID below..
 * 
 * 
 * 	Student ID: 2721301
 */

/**
 * BinaryTree - An example of a Binary Tree built using Node objects. Some of
 * the functionality for this class is provided for you (and may provide clues
 * as to how to implement assignment methods). Your task is to implement the
 * method bodies for:
 * 
 * protected void preOrder(Node n, StringBuffer sb) protected void inOrder(Node
 * n, StringBuffer sb) protected void postOrder(Node n, StringBuffer sb)
 * protected Property find(String name, Node n)
 * 
 */
public class BinaryTree {

	private Node root; // The root node of the tree
	private int size; // A count of the nodes in the tree

	public BinaryTree() {
		root = null;
		size = 0;
	}

	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return Number of nodes in the tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Empties the tree
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Determines if the tree is empty or not.
	 * 
	 * @return true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Adds a Node containing a reference to the Property a to the tree.
	 * 
	 * @param c   The content of the node that will be added
	 */
	public void addNode(Property a) {
		Node node = new Node(a);

		// If tree is empty, make our new node the root and leave
		if (root == null) {
			root = node;
			size = 1;
		} else {
			// Start the recursive calls to add the descendants of node 'p'
			addNode(node, root);
			size = size + 1;
		}

	}

	/**
	 * Internal recursive method to add a node to the tree.
	 * 
	 * @param c   The content to place in the tree
	 * @param n   The current node to consider, will not be null
	 */
	private void addNode(Node c, Node n) {
		// Is our new node content less than our current node content?
		// If it is, we add it to the left side of the tree so that when
		// we walk it with an in-order traversal, the tree content will
		// come out in alphabetic order. Conversely add it to the right if it
		// is greater.
		if (c.compareTo(n) < 0) {
			if (n.hasLeft())
				addNode(c, n.left());
			else {
				// The current left node is null so we can
				// attach our new node to the left of the current node
				n.setLeft(c);
				return;
			}
		} else {
			if (n.hasRight())
				addNode(c, n.right());
			else {
				// The current right node is null so we can
				// attach our new node to the right of the current node
				n.setRight(c);
				return;
			}
		}
	}

	/**
	 * Public call to start a recursive in-order traversal using the root of the
	 * tree. In-order traversal is often called in-fix traversal.
	 * 
	 * @return A reference to a comma separated String containing the trees contents
	 *         as determined by an in-order traversal.
	 */
	public String inOrderTraversal() {
		StringBuffer buff = new StringBuffer();

		if (root == null)
			return "Empty Tree!";
		else
			inOrder(root, buff);

		return buff.toString();

	}

	/**
	 * Private method used to make a recursive in-order traversal from node 'n' You
	 * should provide the correct recursive implementation for this method.
	 * 
	 * @param n
	 *            The node to perform the inOrder walk from
	 */
	protected void inOrder(Node n, StringBuffer sb) {
		// We 'visit' the node by adding its contents to our String
		
		if (n.hasLeft()) inOrder(n.left(),sb);	//if has left node call this method recursively passing left node
		sb.append(n.getPropertyName() + ",");	//append to string
		if (n.hasRight()) inOrder(n.right(),sb);//if has right node call this recursively again passing right node
		
		// TODO
	}

	/**
	 * Find the reference for a given property by 'name'
	 * 
	 * @param name
	 *            The property name to search for
	 * @return A reference to the property that was found or null if no property found
	 */
	public Property find(String name) {
		return find(name, root);
	}

	/**
	 * Internal protected method used to search the tree from node 'n' looking for a
	 * property with the given 'name'. You should provide the correct recursive
	 * implementation for this method. Some helpful lines of code have been
	 * included...
	 * 
	 * @param name	The name of the property to search for
	 * @param n		The current node in the tree to search from
	 * @return		A reference to the node that was found or null if not found
	 */
	protected Property find(String name, Node n) {
		if (n == null)
			return null;	//return null if node is empty

		if (name.compareTo(n.getPropertyName()) == 0)	//if property is found
		{
			return n.getProperty();	//return property that is found
		}
		else if (name.compareTo(n.getPropertyName()) < 0)	//if property name searching for is alphabetically lower that node being checked 
		{
			return find(name,n.left());	//recursively calls this method passing left of node as parameter
		}
		else if (name.compareTo(n.getPropertyName()) > 0)	//if property name searching for is alphabetically higher that node being checked 
		{
			return find(name,n.right());	//recursively calls this method passing right of node as parameter
		}
		
		return null;	//return null if property not found
	}

	public void printTree() {
		printTree(root, 0);
	}

	/**
	 * Internal method used to make a recursive reverse order walk from node 'n'.
	 * This method is useful to see the current structure of the tree (turned on its
	 * side)
	 * 
	 * @param n   	The node to start the reverse order walk from
	 * @param depth	The current depth of the node in the tree
	 */
	private void printTree(Node n, int depth) {
		if (n.hasRight())
			printTree(n.right(), depth + 1);

		// Show depth of current code by indenting to the right
		for (int d = 0; d < depth; d++)
			System.out.print("  ");

		System.out.println(n.getPropertyName());

		if (n.hasLeft())
			printTree(n.left(), depth + 1);
	}

}
