package ASSIGNMENT.CODE;

public class Farm extends Property {

	protected boolean hasFarmhouse;
	protected int numberOfBarns;

	public Farm(String n, double sz, boolean hasF, int nBarns) {	//constructor
		super(n, sz);	//calls parent class constructor and passes parameters
		this.hasFarmhouse = hasF;
		this.numberOfBarns = nBarns;
	}

	public String toString() {	//prints farm attributes to string
		return "Farm - " + name + " : Size " + getSize() + "; Has Farmhouse " + hasFarmhouse + "; Barns " + numberOfBarns;
	}

}
