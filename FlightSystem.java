import java.io.FileNotFoundException;
import java.util.*;
public class FlightSystem {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Main method
		//prompts user for input to call other methods in other classes
		Scanner inp = new Scanner(System.in);
		AirplaneManager airplaneManager = new AirplaneManager();
		AirportManager airportManager = new AirportManager();
		FlightPlanner flightPlanner = new FlightPlanner();
		boolean go = true;
		while(go == true) {
			System.out.println("What would you like to do?(Input the number of your choice)\n1. Manage the airports"
				+ "\n2. Manage the airplanes\n3. Create a flight plan\n4. Quit");
			int choice = inp.nextInt();
			switch(choice) {
				case 1:
					System.out.println("What would you like to do?(Input the number of your choice)\n1. Add an airport"	
				+ "\n2. Delete an airport\n3. Modify an airport\n4. Display the Airports\n5. Quit");
					int x1 = inp.nextInt();
					if(x1 == 1)
						airportManager.addAirport();
					else if(x1 == 2)
						airportManager.deleteAirport();
					else if(x1 == 3)
						airportManager.modifyAirport();
					else if(x1 == 4)
						airportManager.displayAirports();
						//airportManager.read();
					else
						break;
					break;
				case 2:
					System.out.println("What would you like to do?(Input the number of your choice)\n1. Add an airplane"
							+ "\n2. Delete an airplane\n3. Modify an airplane\n4. Display the Airplanes\n5. Quit");
					int x2 = inp.nextInt();
					if(x2 == 1)
						airplaneManager.addAirplane();
					else if(x2 == 2)
						airplaneManager.deleteAirplane();
					else if(x2 == 3)
						airplaneManager.modifyAirplane();
					else if(x2 == 4)
						airplaneManager.displayAirplanes();
					else
						break;
					break;
				case 3:
					System.out.println("What would you like to do?(Input the number of your choice)\n1. Create Flight");
					int x3 = inp.nextInt();
					if(x3 ==1)
						flightPlanner.flightPlaning();
					break;
				case 4:
					go = false;
					System.out.println("Thank you for using our system");
					break;
			}
		}
		inp.close();
	}
}
