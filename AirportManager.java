import java.io.*;
import java.util.*;
public class AirportManager {
	
	Vector<Airport> airports = new Vector<Airport>();
	Scanner inp = new Scanner(System.in);
	
	//file declared here for further use in different methods
	File airportscsv = new File("airports.csv");
	
	//constructor reads data from csv file
	public AirportManager() {
		//checks if csv file exists and creates file if it does not
		//file is created in project directory
		try {airportscsv.createNewFile();} catch (IOException e1) {e1.printStackTrace();}
		try(Scanner sc = new Scanner(airportscsv)){
			sc.useDelimiter(", ");
			while (sc.hasNext()) {
				String icao = sc.next();
				icao = icao.replace("\r\n", "");
				if (icao.isEmpty())
					break;
				String name = sc.next();
				double lat = Double.parseDouble(sc.next());
				double lon = Double.parseDouble(sc.next());
				String comType = sc.next();
				double comFreq = Double.parseDouble(sc.next());
				sc.next();
				//String ft = sc.next();
				//String[] fuelType = ft.split(" ");
				Airport a = new Airport(icao, name, lat, lon, comType, comFreq);
				airports.addElement(a);
			}
			sc.close();
		} catch (IOException e) {System.out.println(e.getMessage());}
	}
	
	public void addAirport() {
		//creates an airport object and prompts user for imputs to assign to the variables associated to the airport
		/*@param: none
		@return: none
		*/
		
		System.out.println("Please input icao, name, lattitude, longitude, communication type, and communication frequency:");
		String[] inputArray = inp.nextLine().split(", ");
		if (inputArray.length != 6) {System.out.println("Missing Value. Please try again.\n"); return;}
		else {
			String icao = inputArray[0];
			String name = inputArray[1];
			double lat = Double.parseDouble(inputArray[2]);
			double lon = Double.parseDouble(inputArray[3]);
			String comType = inputArray[4];
			double comFreq = Double.parseDouble(inputArray[5]);
			/*System.out.println("Please input the fuel types:");
			String ft = inp.nextLine();
			String[] fuelType = ft.split(" ");*/
			Airport a = new Airport(icao, name, lat, lon, comType, comFreq);
			if (validateAirport(a) == true) {
				airports.addElement(a); a.display();
				//append to csv file
				try(PrintWriter writer = new PrintWriter(new FileWriter(airportscsv, true))){
					for(int i = 0; i < 6; i++) {
						writer.append(inputArray[i].toString() + ", ");
					}
					//writer.append(ft + ", ");
					writer.append("\r\n");
					writer.close();
				} catch(IOException e) {System.out.println(e.getMessage());}
				}
			else {System.out.println("Validation Error. Please try again.");}
		}
	}
	public void deleteAirport() {
		//promps user for imput to sear for an Airport
		//searches for the airport
		//removes the airport from the airport vector
		/*@param: none
		 * @return: none
		 */
		System.out.println("Please input the icao and name:");
		String[] inputArray = inp.nextLine().split(", ");
		String icao = inputArray[0];
		String name = inputArray[1];
		try {airports.remove(searchAirport(name, icao));System.out.println("Airport deleted");
		//overwrite csv file with empty csv file & re write all airports from vector
				try (PrintWriter writer = new PrintWriter(airportscsv)) {
					Airport[] airportsToArray = new Airport[airports.size()];
					airportsToArray = airports.toArray(airportsToArray);
					for (int i = 0; i < airportsToArray.length; i++) {
						String[] tempArray = new String[6];
						tempArray[0] = airportsToArray[i].icao;
						tempArray[1] = airportsToArray[i].name;
						tempArray[2] = String.valueOf(airportsToArray[i].lat);
						tempArray[3] = String.valueOf(airportsToArray[i].lon);
						tempArray[4] = airportsToArray[i].comType;
						tempArray[5] = String.valueOf(airportsToArray[i].comFreq);
						String ft;
						if(airportsToArray[i].fuelType.length == 2)
							ft = airportsToArray[i].fuelType[0] + " " + airportsToArray[i].fuelType[1];
						else
							ft = airportsToArray[i].fuelType[0];
						for(int j = 0; j < 6; j++) {
							writer.append(tempArray[j].toString() + ", ");
						}
						writer.append(ft + ", ");
						writer.append("\r\n");
					}
					writer.close();
				} catch (IOException e) {System.out.println(e.getMessage());}
		}catch(ArrayIndexOutOfBoundsException e) {e.printStackTrace();
        System.out.println("Invalid entry");}
	}
	public void modifyAirport() {
		//prompts user for inputs to search for an airport
		//searches for the airport
		//prompts user for info to update the variables
		/*@param: none
		 *@return: none
		 */
		System.out.println("Please input the icao and name:");
		String[] inputArray = inp.nextLine().split(", ");
		String icao = inputArray[0];
		String name = inputArray[1];
		
		try{ 
			airports.remove(searchAirport(name, icao));
			System.out.println("Please input icao, name, lattitude, longitude, communication type, and communication frequency:");
			inputArray = inp.nextLine().split(", ");
			icao = inputArray[0];
			name = inputArray[1];
			double lat = Double.parseDouble(inputArray[2]);
			double lon = Double.parseDouble(inputArray[3]);
			String comType = inputArray[4];
			double comFreq = Double.parseDouble(inputArray[5]);
			//System.out.println("Please input the fuel types:");
			//String[] fuelType = inp.nextLine().split(" ");
			Airport a = new Airport(icao, name, lat, lon, comType, comFreq);
			airports.addElement(a);
			a.display();
			//overwrite csv file with empty csv file & re write all airports from vector
			try (PrintWriter writer = new PrintWriter(airportscsv)) {
				Airport[] airportsToArray = new Airport[airports.size()];
				airportsToArray = airports.toArray(airportsToArray);
				for (int i = 0; i < airportsToArray.length; i++) {
					String[] tempArray = new String[6];
					tempArray[0] = airportsToArray[i].icao;
					tempArray[1] = airportsToArray[i].name;
					tempArray[2] = String.valueOf(airportsToArray[i].lat);
					tempArray[3] = String.valueOf(airportsToArray[i].lon);
					tempArray[4] = airportsToArray[i].comType;
					tempArray[5] = String.valueOf(airportsToArray[i].comFreq);
					/*String ft;
					if(airportsToArray[i].fuelType.length == 2)
						ft = airportsToArray[i].fuelType[0] + " " + airportsToArray[i].fuelType[1];
					else
						ft = airportsToArray[i].fuelType[0];*/
					for(int j = 0; j < 6; j++) {
						writer.append(tempArray[j].toString() + ", ");
					}
					//writer.append(ft + ", ");
					writer.append("\r\n");
				}
				writer.close();
			} catch (IOException e) {System.out.println(e.getMessage());}
		}
		catch(ArrayIndexOutOfBoundsException e) {e.printStackTrace();
        System.out.println("Invalid entry");}
		
	}
	public void displayAirports() {
		
		for(int i = 0; i<airports.size(); i++)
			airports.elementAt(i).display();
	}
	
	public boolean validateAirport(Airport a) {
		//checks each of the variables of airport a to see if they are meet certain standards
		/*@param: airport a
		 *@return: boolean
		 */
		boolean validation = false;
		if (a.icao.equals(null) || a.name.equals(null) || (a.lat >= 0 && a.lat<= 180) || (a.lon >= 0 && a.lon<= 180) || a.comType.equals(null) || a.comFreq > 0.0) {
			if (a.icao.length() == 4) {
				validation = true;
			}
		}
		
		return validation;
	}
	public int searchAirport(String name, String icao) {
		//searches the airport vector using name and icao
		//returns the index of the airport if found
		/*@param: String name, String icao
		 *@return: int
		 */
		for(int i = 0; i < airports.capacity(); i++)
			if(airports.elementAt(i).getIcao().equals(icao) && airports.elementAt(i).getName().equals(name))
				return i;
		return -1;
	}
}
