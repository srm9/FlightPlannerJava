
public class Airplane {
	//variables
	String make;
	String model;
	String type;
	double fuelSize;
	double fuelBurn;
	double airSpeed;
	/*public Airplane() {
		//default constructor
		this.make = "";
		this.model = "";
		this.type = "";
		this.fuelSize = 0;
		this.fuelBurn = 0;
		this.airSpeed = 0;
	}*/
	public Airplane(String make, String model, String type, double fuelsize, double fuelburn, double airspeed) {
		//constructor
		this.make = make;
		this.model = model;
		this.type = type;
		this.fuelSize = fuelsize;
		this.fuelBurn = fuelburn;
		this.airSpeed = airspeed;
	}
	//get and set methods for the variables
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(double fuelSize) {
		this.fuelSize = fuelSize;
	}
	public double getFuelBurn() {
		return fuelBurn;
	}
	public void setFuelBurn(double fuelBurn) {
		this.fuelBurn = fuelBurn;
	}
	public double getAirSpeed() {
		return airSpeed;
	}
	public void setAirSpeed(double airSpeed) {
		this.airSpeed = airSpeed;
	}
	public void display() {
		//display the information for an airplane
		System.out.println(this.make + " " + this.model + ", Type: " + this.type + ", Fuel Size: " + this.fuelSize + 
				", Fuel Burn: " + this.fuelBurn + ", Air Speed: " + this.airSpeed+"\n");
	}
}
