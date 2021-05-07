package com.flightquery.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TestOperations extends Main
{
	//this method will read the CSV file and store the flight details in list
	public static List<Flight> readFileAndStoreDataInList(String csvFile) 
	{
		flights = new ArrayList<>();  
		String delimiter = "\\|";
		try 
		{
	         BufferedReader br = new BufferedReader(new FileReader(csvFile));
	         String line = "";
	       	 br.readLine();
	         while((line = br.readLine()) != null) 
	         {
	        	 String[] attributes = line.split(delimiter); 
	        	 Flight flight = createFlight(attributes);
	        	 flights.add(flight); 
	         }
	         br.close();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace(); 
		} 
		return flights;
	}
	
	//this method will take user inputs and print the results as well
	public static void getInputFromUser()
		{
			String locs[] = getDepartureArrivalLocation();
			String departure = locs[0];
			String arrival = locs[1];
			System.out.println("Enter date in format: dd-mm-yyyy:");
			Date date = Utilities.getDateInput();
			List<Flight> resultFlights = getFlightDetails(departure, arrival, date);
			if (resultFlights.size() == 0)
			{
				String formattedDate = Utilities.getDateInDDMMYYYYFormat(date);
				System.out.println("There is no flight available from " + departure + " to " + arrival + " on "+ formattedDate);
			}
			else
			{
				System.out.println("Fligt details:");
				resultFlights.stream().sorted(Comparator.comparing(Flight::getFare)).collect(Collectors.toList())
					.forEach(System.out::println);
			}
			displayOptions();
		}
			
	//this method will create the flight 
	private static Flight createFlight(String[] metadata) 
	{ 
		String flightNumber = metadata[0];
		String departureLocation = metadata[1], arrivalLocation = metadata[2];
		Date validTill = Utilities.stringToDateConversion(metadata[3]);
		int	flightTime = Utilities.stringToIntergerConversion(metadata[4]);
		float flightDuration = Utilities.stringToFloatConversion(metadata[5]);
		float	fare = Utilities.stringToFloatConversion(metadata[6]);
		char seatAvailability = metadata[7].charAt(0);
		return new Flight(flightNumber, departureLocation, arrivalLocation, validTill, flightTime, flightDuration, fare, seatAvailability);
	}
	
	//this method will take departure and arrival location [different departure and arrival location]
	private static String[] getDepartureArrivalLocation() 
	{
		String departure, arrival; boolean flag = false;
		do {
			System.out.println("Enter 3 character location code for departure location:");
			departure = Utilities.getLocationInput();
			System.out.println("Enter 3 character location code for arrival location:");
			arrival = Utilities.getLocationInput();
			flag = departure.equalsIgnoreCase(arrival);
			if (flag)
				System.out.println("Departure and arrival location is same. Please enter different departure and arrival location");
		}while (flag);
		
		String[] strResult = {departure, arrival};
		return strResult;	
	}
	
	//this method displays the if user wants to search another record or leave
 	private static void displayOptions()
	{
		System.out.println("Press 1 if you want to search again");
		System.out.println("Press 2 if you want to exit");
		int selection = Utilities.getIntegerInput();
		if (selection == 1)
			getInputFromUser();
		else if (selection == 2)
			System.out.println("Thanks for using Flight Details Query System");
		else
			reset();
	}
	
 	//this method ask the user if user wants to reset the selection and again start from the beginning 
	private static void reset() 
	{
		System.out.println("Do you want to try again, if yes then press 1 else press any other numeric key");
		int selection = Utilities.getIntegerInput();
		if (selection == 1)
			displayOptions();
		else
			System.out.println("Thanks for using Flight Details Query System");
	}
	
	//this method will return the list of all the available flights for the user inputs
	private static List<Flight> getFlightDetails(String departure, String arrival, Date date)
	{ 
		flights = readFileAndStoreDataInList(csvFile);
		List<Flight> resultFlights = new ArrayList<>();
		for (Flight element : flights)
		{
			boolean loc = (element.getDepartureLocation().equalsIgnoreCase(departure) && element.getArrivalLocation().equalsIgnoreCase(arrival));
			if (loc) 
			{
			  if((element.getValidtill()).compareTo(date) == 0 && (element.getSeatAvailability() == 'y' || element.getSeatAvailability() == 'Y')) 
			  { 
				  resultFlights.add(element); 
			  } 		 
			}
		 }
		return resultFlights;
	}
}
