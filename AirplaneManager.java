import java.io.*;
import java.util.*;
public class AirplaneManager {
	
	Vector<Airplane> airplanes = new Vector<Airplane>();
	Scanner inp = new Scanner(System.in);
	
	//file declared here for further use in different methods
	File airplanescsv = new File("airplanes.csv");
	//constructor reads data from csv file
	public AirplaneManager() {
		//checks if csv file exists and creates file if it does not
		//file is created in project directory
		try {airplanescsv.createNewFile();} catch (IOException e1) {e1.printStackTrace();}
		try(Scanner sc = new Scanner(airplanescsv)){
			sc.useDelimiter(", ");
			while (sc.hasNext()) {
				String make = sc.next();
				make = make.replace("\r\n", "");
				if (make.isEmpty())
					break;
				String model = sc.next();
				String type = sc.next();
				Double fuelSize = Double.parseDouble(sc.next());
				Double fuelBurn = Double.parseDouble(sc.next());
				Double airSpeed = Double.parseDouble(sc.next());
				Airplane a = new Airplane(make, model, type, fuelSize, fuelBurn, airSpeed);
				airplanes.addElement(a);
			}
			sc.close();
		} catch (IOException e) {System.out.println(e.getMessage());}
	}
	
	public void addAirplane() {
		//creates an airport object and prompts user for inputs to assign to the variables associated to the airplane
		/*@param: none
		@return: none
		*/
		System.out.println("Please input make, model, type, fuel tank size, fuel burn rate, and airspeed "
				+ "(Please use comma and space to separate values):\n");
		String[] inputArray = inp.nextLine().split(", ");
		if (inputArray.length != 6) {System.out.println("Missing Value. Please try again.\n"); return;}
		else {
			String make = inputArray[0];
			String model = inputArray[1];
			String type = inputArray[2];
			Double fuelSize = Double.parseDouble(inputArray[3]);
			Double fuelBurn = Double.parseDouble(inputArray[4]);
			Double airSpeed = Double.parseDouble(inputArray[5]);
			Airplane a = new Airplane(make, model, type, fuelSize, fuelBurn, airSpeed);
			if (validateAirplane(a) == true) {
				airplanes.addElement(a); a.display();
				//append to csv file
				try(PrintWriter writer = new PrintWriter(new FileWriter(airplanescsv, true))){
					for(int i = 0; i < 6; i++) {
						writer.append(inputArray[i].toString() + ", ");
					}
					writer.append("\r\n");
					writer.close();
				} catch(IOException e) {System.out.println(e.getMessage());}
			}
			else {System.out.println("Validation Error. Please try again.\n");}
		}
		
		
	}
	public void deleteAirplane() {
		//prompts user for input to sear for an Airplane
		//searches for the airplane
		//removes the airplane from the airplane vector
		/*@param: none
		 * @return: none
		 */
		System.out.println("Please input make and model:\n");
		String[] inputArray = inp.nextLine().split(", ");
		String make = inputArray[0];
		String model = inputArray[1];
		
		try{ 
			airplanes.remove(searchAirplane(make, model));System.out.println("Airplane deleted");
			//overwrite csv file with empty csv file & re write all airplanes from vector
			try (PrintWriter writer = new PrintWriter(airplanescsv)) {
				Airplane[] airplanesToArray = new Airplane[airplanes.size()];
				airplanesToArray = airplanes.toArray(airplanesToArray);
				for (int i = 0; i < airplanesToArray.length; i++) {
					String[] tempArray = new String[6];
					tempArray[0] = airplanesToArray[i].make;
					tempArray[1] = airplanesToArray[i].model;
					tempArray[2] = airplanesToArray[i].type;
					tempArray[3] = String.valueOf(airplanesToArray[i].fuelSize);
					tempArray[4] = String.valueOf(airplanesToArray[i].fuelBurn);
					tempArray[5] = String.valueOf(airplanesToArray[i].airSpeed);
					for (int j = 0; j < 6; j++) {
						writer.append(tempArray[j].toString() + ", ");
					}
					writer.append("\r\n");
				}
				writer.close();
			} catch (IOException e) {System.out.println(e.getMessage());}
		}
		catch(ArrayIndexOutOfBoundsException e) {e.printStackTrace();
        System.out.println("Invalid entry");}
	}
	public void modifyAirplane() {
		//prompts user for inputs to search for an airplane
		//searches for the airplane
		//prompts user for info to update the variables
		/*@param: none
		 *@return: none
		 */
		System.out.println("Please input make and model:\n");
		String[] inputArray = inp.nextLine().split(", ");
		String make = inputArray[0];
		String model = inputArray[1];
		
		try{ 
			airplanes.remove(searchAirplane(make, model));
			System.out.println("Please input make, model, type, fuel tank size, fuel burn rate, and airspeed:\n");
			inputArray = inp.nextLine().split(", ");
			make = inputArray[0];
			model = inputArray[1];
			String type = inputArray[2];
			Double fuelSize = Double.parseDouble(inputArray[3]);
			Double fuelBurn = Double.parseDouble(inputArray[4]);
			Double airSpeed = Double.parseDouble(inputArray[5]);
			Airplane a = new Airplane(make, model, type, fuelSize, fuelBurn, airSpeed);
			airplanes.addElement(a);
			a.display();
			//overwrite csv file with empty csv file & re write all airplanes from vector
					try (PrintWriter writer = new PrintWriter(airplanescsv)) {
						Airplane[] airplanesToArray = new Airplane[airplanes.size()];
						airplanesToArray = airplanes.toArray(airplanesToArray);
						for (int i = 0; i < airplanesToArray.length; i++) {
							String[] tempArray = new String[6];
							tempArray[0] = airplanesToArray[i].make;
							tempArray[1] = airplanesToArray[i].model;
							tempArray[2] = airplanesToArray[i].type;
							tempArray[3] = String.valueOf(airplanesToArray[i].fuelSize);
							tempArray[4] = String.valueOf(airplanesToArray[i].fuelBurn);
							tempArray[5] = String.valueOf(airplanesToArray[i].airSpeed);
							for (int j = 0; j < 6; j++) {
								writer.append(tempArray[j].toString() + ", ");
							}
							writer.append("\r\n");
						}
						writer.close();
					} catch (IOException e) {System.out.println(e.getMessage());}
		}
		catch(ArrayIndexOutOfBoundsException e) {e.printStackTrace();
        System.out.println("Invalid entry");}
		
	}
	public void displayAirplanes() {
		//prompts user for inputs to search for an airplane
		//searches for the airplane
		//displays information about the airplane
		/*@param: none
		 *@return: none
		 */
		/*Airplane[] airplanesArray = airplanes.toArray(new Airplane[airplanes.size()]);
		for(int i = 0; i < airplanesArray.length; i++)
			System.out.println(airplanesArray[i].make + " " + airplanesArray[i].model + " Type: " + airplanesArray[i].type + 
			" Fuel Size: " + airplanesArray[i].fuelSize + " Fuel Burn: " + airplanesArray[i].fuelBurn + " Air Speed: " + airplanesArray[i].airSpeed);*/
	
		for(int i = 0; i < airplanes.size(); i++) {
			airplanes.elementAt(i).display();
		}
	}
	public boolean validateAirplane(Airplane a) {
		//checks each of the variables of airplane a to see if they are meet certain standards
		/*@param: airplane a
		 *@return: boolean
		 */
		boolean validation = false;
		if (a.make.equals(null)|| a.model.equals(null) || a.type.equals(null) || a.fuelSize > 0.0 || a.fuelBurn > 0.0 || a.airSpeed > 0.0) {
			if (a.type.equals("Jet") || a.type.equals("Turbofan")) {
				validation = true;
			}
		}
		return validation;
	}
	public int searchAirplane(String make, String model) {
		//searches the airplane vector using make and model
		//returns the index of the airplane if found
		/*@param: String make, String model
		 *@return: int
		 */
		//Airplane[] airplanesArray = airplanes.toArray(new Airplane[airplanes.size()]);
		//for(int i = 0; i < airplanesArray.length; i++)
			//if(airplanesArray[i].getMake().equals(make) && airplanesArray[i].getModel().equals(model))
				//return i;
		for(int i = 0; i < airplanes.capacity(); i++)
			if(airplanes.elementAt(i).getMake().equals(make) && airplanes.elementAt(i).getModel().equals(model))
				return i;
		return -1;
	}
}
