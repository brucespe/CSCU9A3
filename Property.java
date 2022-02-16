package ASSIGNMENT.CODE;
/**
 * Please provide your student ID below.

 * 
 * 	Student ID: 2721301
 */

/**
 * Property is the base class for all Property types.
 * 
 */

public class Property implements Comparable<Property> {
	protected String name;			// The name of the property
	protected double size;			// The size (in squared meters) of the property
	protected double price;			// The price of the property
	protected boolean rent;			// The negotiation type - true for rent, false for sell
	protected int interested;		// Number of customers interested in the property
	protected int maxInterested;	// Maximum number of customer interested in the property
	protected int yearsSinceLastSale; //Number of years since last sale of property
	protected boolean onMarket;     //if the property is on the market


	/**
	 * Default Constructor 
	 */
	public Property() {
		name = "?";
		size = 0.0;
		price = 0.0;
		interested = 0;
		maxInterested = 10;
		rent = false;
		yearsSinceLastSale = -1;
		onMarket = false;
	}
	
	/**
	 * Constructs a property based on its name
	 * 
	 * @param nm The name to give to the property
	 */
	public Property(String nm) {
		this();
		name = nm;
	}

	/**
	 * Constructs an property based on its name and size
	 * 
	 * @param nm The name to give to the property
	 * @param sz The size of the property
	 */
	public Property(String nm, double sz) {
		this();
		name = nm;
		size = sz;
	}
	
	/**
	 * Constructs an property based on its name and size
	 * 
	 * @param nm The name to give to the property
	 * @param sz The size of the property
	 * @param yrs The years since last sale of the property
	 */
	public Property(String nm, double sz, int yrs) {
		this();
		name = nm;
		size = sz;
		yearsSinceLastSale = yrs;
	}


	/**
	 * @return The name of property
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the price of the current property
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param prc Price of the current property
	 */
	public void setPrice(double prc) {
		this.price = prc;
	}

	/**
	 * @return the price of the current property
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * @param prc Price of the current property
	 */
	public void setSize(double sz) {
		this.size = sz;
	}
	
	/**
	 * @return the negotiation status of the current property
	 */
	public boolean isRent() {
		return this.rent;
	}
	
	/**
	 * @param r Negotiation status of the current property
	 */
	public void isRent(boolean r) {
		this.rent = r;
	}

	/**
	 * @param inter - add this many interested customer to this property
	 * @return true if the interested customers were added successfully
	 * @return false if the interested customers were added unsuccessfully
	 */
	public boolean addInterested(int inter) {
		
		int interestCheck = interested + inter;	//variable storing potential new total for interested
		if (interestCheck>maxInterested) 	//checks if the people interested exceeds the max amount
		{
			return false;	//returns false, is unable to add new people interested to interested total
		}
		else {	//runs if new total is less than max
			this.interested = (this.interested + inter);	//will add people interested to the total
			return true;	//returns true, is able to add new people interested to interested total
		}
	}
	
	/**
	 * @return the number of interested customer allocated to this property
	 */
	public int getInterested() {
		return this.interested;
	}
	
	/**
	 * @param yrs Years since last sale of current property
	 */
	public void setYearsSinceLastSale(int yrs) {
		this.yearsSinceLastSale = yrs;
	}
	
	/**
	 * @return the number of years since last sale for this property
	 */
	public int getYearsSinceLastSale() {
		return yearsSinceLastSale;
	}
	
	/**
	 * @return if the property is on the market or not
	 */
	public boolean isOnMarket()
	{
		return this.onMarket;
	}
	
	/**
	 * puts property on market by setting onMarket variable to true
	 */
	public void putOnMarket()
	{
		this.onMarket = true;
	}
	
	/**
	 *  takes property off market by setting onMarket to false
	 */
	public void takeOffMarket()
	{
		this.onMarket = false;
	}
	
	/**
	 * Get a description of the property as a String
	 */
	public String toString()
	{
		return "Property - " + name + ": Size " + size + "; Price " + price;
	}
	
	/**
	 * @return true if this Property is the same at "that" Property
	 * (that is, the two property have the same name)
	 */
	@Override
	public boolean equals(Object that) {
		return this.compareTo(((Property)that)) == 0;
	}

	/**
	 * Compare the current Property with the Property 'that' and return a negative
	 * value if the current Property is less than 'that', 0 if it is the same and
	 * a positive value if it is greater.
	 */
	@Override
	public int compareTo(Property that) {
		return name.compareTo(that.name);
	}
	
}
