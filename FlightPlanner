import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
public class FlightPlanner {
	//variables
	AirplaneManager airplaneManager = new AirplaneManager();
	AirportManager airportManager = new AirportManager();
	Vector<Airport> airports = airportManager.airports;
	Vector<Airplane> airplanes = airplaneManager.airplanes;
	Vector <Airport> v1 = new Vector<Airport>();
	Scanner inp = new Scanner(System.in);
	Airplane plane;
	public FlightPlanner() {
		//empty constructor
		/*@param: none
		 * @return: none
		 */
	}
	public void flightPlaning() {
		//prompts user for inputs to select starting airport
		//search for the airport
		//if the airport exists continue
		//if not tell the user
		//prompts user for inputs to select ending airport
		//search for the airport
		//if the airport exists continue
		//if not tell the user
		//prompts user for inputs to select an airplane
		//search for the airplane
		//if the airplane exists continue
		//if not tell the user
		//calculate the distance of the flight from airport one to airport two
		//add a flight stop if needed
		//display the information for the flight
		/*@param: none
		 * @return: none
		 */
		try {
		System.out.println("Please input make of your airplane: \n");
		String make = inp.nextLine();
		
		System.out.println("Please input model of your airplane: \n");
		String model = inp.nextLine();
		
		plane = airplanes.elementAt(airplaneManager.searchAirplane(make, model));
		
		//Vector <Airport> v1 = new Vector<Airport>();
		
		System.out.println("Please input name and ICAO of your starting airport: \n");
		String[] inputArrayPort = inp.nextLine().split(", ");
		String Name = inputArrayPort[0];
		String ICAO = inputArrayPort[1];
		v1.add(airports.elementAt(airportManager.searchAirport(Name, ICAO)));
		
		System.out.println("Please input name and ICAO of your final destination airport: \n");
		String[] inputArrayPort2 = inp.nextLine().split(", ");
		String Name2 = inputArrayPort2[0];
		String ICAO2 = inputArrayPort2[1];
		v1.add(airports.elementAt(airportManager.searchAirport(Name2, ICAO2)));
		
		System.out.println("Is " + Name2 + " "+ICAO2+ " your final destination?: \n");
		String finalDes = inp.nextLine();
		
		if (finalDes.equals("No")) {
			System.out.println("Please input name and ICAO of your final destination airport: \n");
			String[] inputArrayPort3 = inp.nextLine().split(", ");
			String Name3 = inputArrayPort3[0];
			String ICAO3 = inputArrayPort3[1];
			v1.add(airports.elementAt(airportManager.searchAirport(Name3, ICAO3)));
		}
		
		for (int m = 1; m<v1.size()-1; m++) {
			boolean doable = fuelEnough(plane, v1.elementAt(m-1).getLat(), v1.elementAt(m-1).getLon(), v1.elementAt(m).getLat(), v1.elementAt(m).getLon());
			if(doable = false) {
				//if (addRefuelingStop() == null) {}
				System.out.println("This flight is not possible due to fuel size. \n");
			}
			
			}
			output(plane);
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{	e.printStackTrace();
        	System.out.println("Invalid entry");
        }
		
		v1.clear();
		
	}
	public void output(Airplane plane) {
		int m;
		double lat1, lat2;
		double long1, long2;
		
		System.out.println("Here is the whole information of the flight planning: \n");
		for (m = 0; m<v1.size(); m++) {
			System.out.println("Name: " +v1.elementAt(m).getName()+", ICAO: "+ v1.elementAt(m).getIcao()+", Latitude: "+
					v1.elementAt(m).getLat()+", Longitude: "+ v1.elementAt(m).getLon()+", Fuel type: All");
		}
		plane.display();
		System.out.printf("Time of flight: %.2f hours\n", flightTime(plane));
		
		
		
	}
	public Airport addStop(Airport a, Airport b) {
		//called when distance between two airports is too far for the airplane chosen to travel
		//use a loop to find an airport between airports a and b
		/*@param: Airport a, Aiport b
		 * @return: Airport
		 */
		return a;
	}
	public double flightTime(Airplane plane) {
		//calculate the estimated flight time between two airports based on planes airspeed
		
		double flight_time = 0;
		double time = 0;
		double lat1, lat2;
		double long1, long2;
		for (int m = 1; m<v1.size(); m++) {
			
			lat1= v1.elementAt(m-1).getLat();
			long1=v1.elementAt(m-1).getLon();
			lat2 = v1.elementAt(m).getLat();
			long2=v1.elementAt(m).getLon();
			double temp = distanceOfLegs (lat1, long1, lat2, long2);
			
			time = (temp/plane.airSpeed);
			flight_time+=time;
			
		}
		//flight_time=flight_time*10;
				
		
		return flight_time*100;
	}
	public boolean fuelEnough(Airplane a, double lat1, double long1, double lat2, double long2) {
		
		double max_distance;
		double distance;
		
		distance = distanceOfLegs(lat1, long1, lat2, long2);
		
		max_distance = getMaxRangeOfAirplane(a, lat1, long1, lat2, long2);
		
		if (max_distance < distance) {
			return false;
		}
		
		else return true;
	}
	
	public double getMaxRangeOfAirplane(Airplane a, double lat1, double long1, double lat2, double long2) {
		double max_distance, capacity, burn_rate;
		double time;
		
		capacity = a.getFuelSize();
		burn_rate = a.getFuelBurn();
		double station_angle = getAngle(lat1, long1, lat2, long2);
		double airspeed = a.getAirSpeed();
		
		double u = Math.cos(station_angle)+Math.sqrt((Math.cos(station_angle)*(Math.cos(station_angle))+airspeed*airspeed));
		return u;
	}
	
	public double distanceOfLegs (double lat1, double long1, double lat2, double long2){
		double distance;
		double R = 6731/1.85;
		
		distance = Math.sqrt(R*((Math.sin(lat2)-Math.sin(lat1)*Math.sin(lat2)-Math.sin(lat1)) 
				+ (Math.cos(lat2)*Math.cos(lat2))+(Math.cos(lat1) *Math.cos(lat1)) 
				- 2*Math.cos(lat1)*Math.cos(lat2)*Math.cos(long2-long1)));
		return distance;
	}
	
	private double getAngle(double lat1, double long1, double lat2, double long2) {
		double angle, x1, x2, y1, y2, z1, z2;
		double temp;
		double R = 6731/1.85;
		
		x1 = R*Math.cos(lat1)*Math.cos(long1);
		y1 = R*Math.cos(lat1)*Math.sin(long1);
		z1 = R*Math.sin(lat1);
		
		x2 = R*Math.cos(lat2)*Math.cos(long2);
		y2 = R*Math.cos(lat2)*Math.sin(long2);
		z2 = R*Math.sin(lat2);
		
		temp = (z2-z1)/Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) + (z2-z1)*(z2-z1));
		
		angle = Math.acos(temp);
		return angle;
	}

}
