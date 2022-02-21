public class Airport {
	//variables
	String icao;
	String name;
	double lat;
	double lon;
	String comType;
	double comFreq;
	String[] fuelType = {"AVGAS", "JA-a"};
	/*public Airport() {
		//default constructor
		this.icao = "";
		this.name = "";
		this.lat = 0;
		this.lon = 0;
		this.comType = "";
		this.comFreq = 0;
		this.fuelType = {"", ""};
	}*/
	public Airport() {}
	public Airport(String icao, String name, double lat, double lon, String comtype, double comfreq) {
		//constructor
		this.icao = icao;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.comType = comtype;
		this.comFreq = comfreq;
		//this.fuelType = fueltype;
	}
	
	//get and set methods for the variables
	public String getIcao() {
		return icao;
	}
	public void setIcao(String icao) {
		this.icao = icao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public double getComFreq() {
		return comFreq;
	}
	public void setComFreq(double comFreq) {
		this.comFreq = comFreq;
	}
	public String[] getFuelType() {
		return fuelType;
	}
	public void setFuelType(String[] fuelType) {
		this.fuelType = fuelType;
	}
	public void display() {
		//display the information for an airport
		/*String fuel = "";
		for(int x = 0; x < this.fuelType.length; x++)
			fuel += this.fuelType[x] +" ";*/
		System.out.println(this.icao + " " + this.name + ", Latitude: " + this.lat + 
				", Longitude: " + this.lon + ", Communication Type: " + this.comType + 
				", Communication Frequency: " + this.comFreq +", Fuel Types: "+fuelType[0]+" and "+fuelType[1]);
	}
}
