package ASSIGNMENT.CODE;
/**
 * A node in the BinaryTree. It contains a reference to a Property object
 * associated with the node and references to the left and right Node objects
 * that are below the node. You do not need to modify this code at all.
 */

public class Node {

	private Property	property = null;	// The Property stored at this node
	private Node	left = null;	// The left node of this node
	private Node	right = null;	// The right node of this node
	
	/**
	 * Default constructor that initialises the node with
	 * a Page associated with this node.
	 * 
	 * @param c	The content of the node
	 */
	public Node(Property a)
	{
		property = a;
	}
	
	/**
	 * Set the left reference of this node to 'n'
	 *  
	 * @param n	A reference to the new left node
	 */
	public void setLeft(Node n)
	{
		left = n;
	}
	
	/**
	 * Set the right reference of this node to 'n'
	 *  
	 * @param n	A reference to the new right node
	 */
	public void setRight(Node n)
	{
		right = n;
	}

	// Get properties of the node
	public Property getProperty() { return property; }
	public String getPropertyName() { return property.getName(); }
	public boolean hasLeft() { return left != null; }
	public boolean hasRight() { return right != null; }
	public Node left() { return left; }
	public Node right() { return right; }
	
	public int compareTo(Node pn) { 
		return getPropertyName().compareTo(pn.getPropertyName()); 
		}
	public String toString() { return getPropertyName(); }
	
}
