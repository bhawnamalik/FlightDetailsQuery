package com.flightquery.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main{
	//static variables which needs to be stored in class memory
	protected static Scanner sc = new Scanner(System.in);
	static List<Flight> flights = new ArrayList<>();
	static String csvFile = ".//FlightsData.csv";
	//entry point of the Flight Details Query System
	public static void main(String[] args) 
	{
		Thread t = new Thread()
		{
		    public void run() 
		    {
		    	TimerTask task = new FileWatcher(new File(csvFile)) 
				{
					protected void onChange( File file )
					{
						flights = TestOperations.readFileAndStoreDataInList(csvFile);
					}
				};

				Timer timer = new Timer();
				// repeat the check every second
				timer.schedule( task , new Date(), 1000 );
		    }
		};
		t.setDaemon(true);
		t.start();
		
		TestOperations.getInputFromUser();	
	}

}