package com.flightquery.practice;

import java.util.Date;
//custom data type of flight type
public class Flight 
{
	private String flightNumber;
	private String departureLocation;
	private String arrivalLocation;
	private Date validTill;
	private int flightTime;
	private float flightDuration;
	private float fare;
	private char seatAvailability;
	//Constructor
	public Flight(String flightNumber, String departureLocation, String arrivalLocation, Date validTill, int flightTime, float flightDuration, float fare, char seatAvailability) 
	{ 
		this.flightNumber = flightNumber; 
		this.departureLocation = departureLocation; 
		this.arrivalLocation = arrivalLocation; 
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.fare = fare;
		this.seatAvailability = seatAvailability;
	} 
	//getter and setter
	public String getFlightNumber() 
	{ 
		return flightNumber; 
	} 
	
	public void setFlightNumber(String flightNumber) 
	{ 
		this.flightNumber = flightNumber; 
	} 
	
	public String getDepartureLocation() 
	{ 
		return departureLocation; 
	} 
	
	public void setDepartureLocation(String departureLocation) 
	{ 
		this.departureLocation = departureLocation; 
	} 
	
	public String getArrivalLocation() 
	{ 
		return arrivalLocation; 
	} 
	
	public void setArrivalLocation(String arrivalLocation) 
	{ 
		this.arrivalLocation = arrivalLocation; 
	} 
	
	public int getFlightTime() 
	{ 
		return flightTime; 
	} 

	public void setFlightTime(int flightTime) 
	{ 
		this.flightTime = flightTime; 
	}

	public float getFlightDuration() 
	{ 
		return flightDuration; 
	} 

	public void setflightDuration(float flightDuration) 
	{ 
		this.flightDuration = flightDuration; 
	}

	public Date getValidtill() 
	{ 
		return validTill; 
	} 

	public void setValidTill(Date validTill) 
	{ 
		this.validTill = validTill; 
	}

	public float getFare() 
	{ 
		return fare; 
	} 

	public void setFare(float fare) 
	{ 
		this.fare = fare; 
	}

	public char getSeatAvailability() 
	{ 
		return seatAvailability; 
	} 

	public void setSeatAvailability(char seatAvailability) 
	{ 
		this.seatAvailability = seatAvailability; 
	}
	
	@Override
	public String toString() 
	{ 
		String formattedDate = Utilities.getDateInDDMMYYYYFormat(validTill);
		return "[Flight# " + flightNumber + ", DEP LOC=" + departureLocation + ", ARR LOC=" + arrivalLocation + ", ValidTill=" + formattedDate + ", Time=" + flightTime + ", Duration=" + flightDuration + ", Fare=" + fare + ", Availability=" + seatAvailability + "]";	 
	}
}
