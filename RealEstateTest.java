package ASSIGNMENT.CODE;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
* Please provide your student ID below.

* 
* 	Student ID: 2721301
*/

/**
 * The RealEstateTest class provides different methods of checking the behaviour
 * of the RealEstateManager class and the objects that it uses. It maintains a
 * reference to a RealEstateManager object called 'manager' and populates it via
 * the loadProperties method. 
 * 
 * If you run this class via a call to main, main will create
 * a RealEstateTest object and call the go method which produces some useful output that
 * you can analyse. There are also some test methods to help you check your code
 * as you go.
 * 
 * RealEstateTest also contains the following incomplete test methods that 
 * you should implement to confirm that your tree walk and binary search is working 
 * as intended. At present this only prints out the results of a tree walk and search
 * - you need to convert these to use a valid assertion test.
 * 
 * 	public void inOrderTest()
 *  public void binarySearchTest()
 *  
 */
public class RealEstateTest {
	RealEstateManager manager = new RealEstateManager();
	
	public static void main(String[] args) {
		RealEstateTest test = new RealEstateTest();
		test.go();
	}

	@Before
	public void loadProperties() {
		manager.clear();
		Property a1 = new Commercial("TheThistlesCentre", 20, 1, 6);
		a1.setPrice(2000);
		a1.isRent(true);
		manager.addProperty(a1);

		Property a2 = new House("StNinians", 120, 4, 2);
		a2.setPrice(80000);
		manager.addProperty(a2);

		Property a3 = new Commercial("KingsPark", 30, 2, 10);
		a3.setPrice(100000);
		manager.addProperty(a3);

		Property a4 = new Flat("AllanvaleRoad", 80, 1, 1);
		a4.setPrice(500);
		a4.isRent(true);
		manager.addProperty(a4);

		Property a5 = new House("Barton", 100, 2, 1);
		a5.setPrice(650);
		a5.isRent(true);
		manager.addProperty(a5);
		
		Property a6 = new Flat("HermitageRoad", 65, 2, 1);
		a6.setPrice(850);
		a6.isRent(true);
		manager.addProperty(a6);

		Property a7 = new Flat("HendersonSt", 75, 3, 1);
		a7.setPrice(105000);
		manager.addProperty(a7);
		
		
		// Uncomment the following lines when you have built the Farm class
		Property a8 = new Farm("McMarne", 15000, true, 1);
		a8.setPrice(150000);
		manager.addProperty(a8);
		Property a9 = new Farm("Farlane", 20000, true, 2);
		a9.setPrice(200000);
		manager.addProperty(a9);
	}
	
	/**
	 * Print the contents of the ArrayList 'list' to standard output.
	 * @param list The list to print
	 */
	public void printArrayList(ArrayList<Property> list) {
		for (Property v:list)
			System.out.println(v.toString());
	}

	/**
	 * 'go' produces a useful set of output that allows you to see the
	 * initial state transport list and tree, the results of doing the
	 * three tree walks, an attempt at finding an object in the tree and 
	 * the results of doing an insertion sort and a binary search. Initially,
	 * only the state of the transport list will be correct. As you add
	 * further functionality, you should see the correct output being
	 * printed via this method. You do not need to modify it but you may
	 * want to add your own checks to confirm your code is working as intended. 
	 */
	public void go() {
		loadProperties();
		System.out.println("--Property List--");
		manager.describePropertyList();
		System.out.println();
		
		System.out.println("--Property Tree--");
		manager.describePropertyTree();	
		System.out.println();
		
		System.out.println("\n--In Order Walk--\n" + manager.inWalk());
		
		System.out.println("\n--Find--");

		Property mf = manager.find("Barton"); // should be found
		if (mf != null) 
			System.out.println("Found: " + mf);
		else
			System.out.println("Could not find Barton");
	
		Property aw = manager.find("Murray"); // should not be found
		if (aw != null) 
			System.out.println("Found: " + aw);
		else
			System.out.println("Could not find Murray");

		
    	System.out.println("\n--Insertion Sort descending price--");
    	ArrayList<Property> sorted;
    	// Reload the property list, otherwise it will still be sorted...
    	loadProperties();
    	sorted = manager.insertionSort(false, "price");
    	printArrayList(sorted);	

		System.out.println("\n--Insertion Sort ascending size--");
    	// Reload the property list, otherwise it will still be sorted...
    	loadProperties();
    	sorted = manager.insertionSort(true, "size");
    	printArrayList(sorted);	
		
		
		System.out.println("\n--Binary Search--");
		Property bs = manager.binarySearch(65); // "HermitageRoad" should be found
		if (bs != null) 
			System.out.println("Found: " + bs);
		else
			System.out.println("Could not find HermitageRoad (size 65)");
	
		Property bsn = manager.binarySearch(148); // should not be found
		if (bsn != null) 
			System.out.println("Found: " + bsn);
		else
			System.out.println("Could not find property with size 148");
		
    	
	}
	

	/**
	 * A test for the in-order walk
	 */
	@Test
	public void inOrderTest() {	
		// loadProperties() is annotated with "@before" so it will already have been called
		
		// Now conduct an assertion test...
		// TODO
		System.out.println("\n--In Order Walk--\n" + manager.inWalk());
		
		String inOrder = manager.inWalk(); //assigns the tree walk to a string
		assertEquals("AllanvaleRoad,Barton,Farlane,HendersonSt,HermitageRoad,KingsPark,McMarne,StNinians,TheThistlesCentre,", inOrder); //checks if output is correct
	}
	

	/**
	 * A test for the binary search
	 */
	@Test
	public void binarySearchTest() {
		

			assertNotNull(manager.binarySearch(120));
			assertNull(manager.binarySearch(3122));
			//assertNotNull(manager.binarySearch(20000));

		System.out.println("\n--Binary Search (found)--\n" + manager.binarySearch(120));
		System.out.println("\n--Binary Search (not found)--\n" + manager.binarySearch(3122));
	}
	
	/**
	 * A test for finding properties in binary tree
	 */
	@Test
	public void findTest() {
		assertNull(manager.find("Murray"));
		assertNotNull(manager.find("Barton"));
	}
	
	
	@Test
	public void checkPropertyInterest() {
		Property a = new Commercial("BakerSt", 60, 2, 7);
		
		assertEquals(a.getInterested(), 0);
		assertTrue(a.addInterested(2));
		assertEquals(a.getInterested(), 2);
		assertTrue(a.addInterested(3));
		assertEquals(a.getInterested(), 5);
		assertTrue(a.addInterested(4));
		assertEquals(a.getInterested(), 9);
		assertFalse(a.addInterested(2));
		assertEquals(a.getInterested(), 9);
		assertTrue(a.addInterested(1));
		assertEquals(a.getInterested(), 10);
		
	}
}
