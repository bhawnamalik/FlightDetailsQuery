package com.flightquery.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Common methods
public class Utilities extends Main{

	//this method get the 3 character string input
	public static String getLocationInput()
	{
		String input = sc.next();
		if(input.length() != 3 )
		{
			System.out.println("Please enter valid three characters for location: ");
			input = getLocationInput();
		}
		return input;
	}

	//this method get the date input
	public static Date getDateInput()
	{
		Date date = null;
		boolean flag = false; 
		do {
			try 
			{
				String strdate = sc.next();
				date = new SimpleDateFormat("dd-MM-yyyy").parse(strdate);
				flag = false;
			}
			catch (ParseException e) {
				System.out.println("Your input is invalid, please enter date in valid format i.e. dd-mm-yyyy");
				flag = true;
			}  
		}
		while (flag);
		return date;
	}

	//this method get the integer input
	public static int getIntegerInput()
	{
		boolean flag = false; int result = 0;
		do {
			try
			{
				System.out.print("Enter your choice :");
				result = Integer.parseInt(sc.next());
				flag = false;
			}
			catch(NumberFormatException nfex)
			{
				System.out.println("Your input is invalid, please enter valid number");
				flag = true;
			}
		}
		while (flag);
		return result;
	}	

	//this method convert string to date
	public static Date stringToDateConversion(String strDate)
	{
		Date date = null;
		try 
		{
			date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		} 
		catch (ParseException e) 
		{
			System.out.println(date + " is not parsable!");
		}
		return date;
	}

	//this method convert string to integer
	public static int stringToIntergerConversion(String strInt)
	{
		int value = 0;
		try 
		{
			value = Integer.parseInt(strInt);
		} 
		catch(NumberFormatException nfex)
		{
			System.out.println("Your input is invalid");
		}
		return value;
	}

	//this method convert string to float
	public static float stringToFloatConversion(String strFloat)
	{
		float value = 0;
		try 
		{
			value = Float.parseFloat(strFloat);
		} 
		catch(NumberFormatException nfex)
		{
			System.out.println("Your input is invalid");
		}
		return value;

	}

	//this method convert the date format dd-MM-yyyy
	public static String getDateInDDMMYYYYFormat(Date date)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = simpleDateFormat.format(date);
		return formattedDate;

	}
}
