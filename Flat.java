package ASSIGNMENT.CODE;
public class Flat extends Property
{
	protected int numBedrooms;
	protected int numBathrooms;
	
	public Flat(String n, double sz, int nbed, int nbath) {
		super(n, sz);
		this.numBedrooms = nbed;
		this.numBathrooms = nbath;
	}
	
	public String toString() {
		return "Flat - " + name + " : Size " + getSize() + "; Bedrooms " + numBedrooms; 
	}
}
