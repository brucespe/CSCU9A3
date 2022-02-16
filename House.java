package ASSIGNMENT.CODE;
public class House extends Property
{
	protected int numBedrooms;
	protected int numBathrooms;
	
	public House(String n, double sz, int nbed, int nbath) {
		super(n, sz);
		this.numBedrooms = nbed;
		this.numBathrooms = nbath;
	}
	
	public String toString() {
		return "House - " + name + " : Size " + getSize() + "; Bedrooms " + numBedrooms; 
	}
}
