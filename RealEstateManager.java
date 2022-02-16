package ASSIGNMENT.CODE;
/**
 * Please provide your student ID below.
 * 
 * 	Student ID: 2721301
 */

import java.util.ArrayList;

/**
 * RealEstateManager maintains two data structures containing a set of Property objects.
 * The first is an ArrayList called propertyList and the second is a binary tree called
 * propertyTree. Your task is to correctly implement the method bodies for
 * 
 *  protected ArrayList<Property> insertionSort(ArrayList<Property> list)
 *	protected ArrayList<Property> quickSort(ArrayList<Property> list)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local propertyList object as a parameter. You can observe calls to these public
 *  methods in the go methods of RealEstateTest.java.  
 */
public class RealEstateManager
{
	private ArrayList<Property>	propertyList;
	private BinaryTree			btree;
	
	public RealEstateManager()
	{
		propertyList = new ArrayList<Property>();
		btree = new BinaryTree();
	}
	
	public void clear()
	{
		propertyList.clear();
		btree.clear();
	}
	public void addProperty(Property v)
	{
		propertyList.add(v);
		btree.addNode(v);
	}
	
	public void describePropertyList()
	{
		for (Property v : propertyList)
		{
			System.out.println(v.toString());
		}
	}
	
	public void describePropertyTree()
	{	
		btree.printTree();
	}
	
	public String inWalk()
	{
		return btree.inOrderTraversal();
	}

	public Property find(String name)
	{
		return btree.find(name);
	}
	
	/**
	 * This method should use a binary search approach to find for
	 * the property (based on the size) in the ArrayList 'propertyList'.
	 * 
	 * You should not modify this code.
	 * 
	 * @param name Property name to be found
	 * @return	The ArrayList 'property' that has been sorted using  sort
	 */
    public Property binarySearch(double size)
    {	
    	return binarySearch(propertyList, size);
    }
    
	/**
	 * This method should use a binary search approach to find for
	 * the property (based on its size) in the ArrayList 'propertyList'.
	 *
     * @param list An ArrayList of Property objects to search
	 * @param size Property size to be found
 	 * @return p, the property found or not
	 */
    protected Property binarySearch(ArrayList<Property> list, double size)
    {	
    	Property p = null;	//sets p to null, will return null if property not found
    	list = insertionSort(propertyList, true, "size");	//getting the sorted list
    	int low = 0, middle = 0, high = list.size();
    	while (high>= low) {
    		middle = (high + low) / 2;
    		if (list.get(middle).getSize() == size)	//if its found 
    		{
    			p= list.get(middle);	//assign p to property
    			return p;	//return p 
    		}
    		else if (list.get(middle).getSize() < size)	//if its in the lower half
    		{
    			low = middle+1;
    		}
    		else	//if its in the upper half 
    		{
    			high = middle-1;
    		}  		
    	}
    	return p;
    }
	    
	/**
	 * This method should use an insertion sort approach to rearrange
	 * the references in the ArrayList 'propertyList' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * You should not modify this code.
	 * 
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute that will be use during the sorting 
	 * @return	The ArrayList 'property' that has been sorted using insertion sort
	 */
    public ArrayList<Property> insertionSort(boolean asc, String attr)
    {	
    	return insertionSort(propertyList, asc, attr);
    }
    
	/**
	 * This method should use an insertion sort approach to rearrange
	 * the references in the ArrayList 'list' such that they are in 
	 * order according to the attr (attribute) parameter (ascending if asc is true, descending otherwise).
	 * 
     * @param list An ArrayList of Property objects that need sorting
     * @param ascending True if the list should be ascending order, false for descending 
     * @param attr Attribute that will be use during the sorting - either "price" or "size" 
 	 * @return	The ArrayList of Properties that has been sorted using insertion sort
	 */
    protected ArrayList<Property> insertionSort(ArrayList<Property> list, boolean ascending, String attr)
    {

    	ArrayList<Property> sorted = new ArrayList<Property>();
    	int n = list.size();
    	int j;

    	if(attr == "price") //runs if comparing the price
    	{
    		for (int i=1; i <n; i++){
    				sorted.add(0, list.get(i));	//using sorted arraylist to store the pivot
    				j = i-1;
    				if (ascending == true)	//runs if order is ascending
    				{
    					while(j>=0 && (list.get(j).getPrice()) > (sorted.get(0).getPrice())){	//runs while current index of arraylist being checked is greater than stored in pivot
    						list.set(j+1, list.get(j));	//puts whats stored in list index j into j+1
    						list.set(j, sorted.get(0)); //sets list index j to what was used as pivot
    						j = j-1;
    					}
    				}
    				else {
    					while(j>=0 && (list.get(j).getPrice()) < (sorted.get(0).getPrice())){	//while list at index is less than whats being used as pivot
    						list.set(j+1, list.get(j));
    						list.set(j, sorted.get(0));
    						j = j-1;
    					}
    				}
    				list.set(j+1, sorted.get(0));	//sets list index j+1 to what was used as pivot
    			}
    	} 
    	else {	//runs if checking size, not price
    			for (int i=1; i <n; i++){
    				sorted.add(0, list.get(i));
    				j = i-1;
    				
    				if (ascending == true){	//runs if ascending order
    					while(j>=0 && (list.get(j).getSize()) > (sorted.get(0).getSize())){
    						list.set(j+1, list.get(j));
    						list.set(j, sorted.get(0));
    						j = j-1;
    					}
    				}
    				else {	//runs if descending order
    					while(j>=0 && (list.get(j).getSize()) < (sorted.get(0).getSize())){
    						list.set(j+1, list.get(j));
    						list.set(j, sorted.get(0));
    						j = j-1;
    					}
    				}
    				list.set(j+1, sorted.get(0));
    			}
    		}
    	
    	return list;
    }
}
