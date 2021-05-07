package com.flightquery.practice;

import java.io.File;
import java.util.TimerTask;

public abstract class FileWatcher extends TimerTask 
{
	private long timeStamp;
	private File file;

	  //Constructor
	public FileWatcher( File file ) {
	  this.file = file;
	  this.timeStamp = file.lastModified();
	}
	 
	//this method will check the file modification 
	public final void run() {
	  long timeStamp = file.lastModified();

	  if( this.timeStamp != timeStamp ) {
	    this.timeStamp = timeStamp;
	    onChange(file);
	  }
	}

	protected abstract void onChange( File file );
	}