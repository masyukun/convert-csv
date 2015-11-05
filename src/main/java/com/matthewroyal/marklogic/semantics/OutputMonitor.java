package com.matthewroyal.marklogic.semantics;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class OutputMonitor {

	Timer timer;
	Date startTime;
	OutputFormat output;
	  
	private static final Integer DEFAULT_TIMER_LENGTH_S = 5;
	private static Boolean STOP_TIMER = false;
	
	public OutputMonitor(OutputFormat output) {
		setTimer(output, DEFAULT_TIMER_LENGTH_S);
	}
	
	public OutputMonitor(OutputFormat output, int seconds) {
		setTimer(output, seconds);
	}

	public static void stopTimer() {
		STOP_TIMER = true;
	}
	
	
	public void cancelTimer() {
		// Stop reminding
		timer.cancel();

		// Runtime estimate
		long millis = (new Date()).getTime() - startTime.getTime();
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;
	
		System.out.printf("Job completed in %02d:%02d:%02d.%d", hour, minute, second, millis);
	}
	 
	 private void setTimer(OutputFormat output, int seconds) {
		timer = new Timer();
	    timer.schedule(new PrintJobStatusTask(), 100, seconds * 1000);
	    this.output = output;
	    startTime = new Date();
	}
	  
	 class PrintJobStatusTask extends TimerTask {
	   public void run() {
		  if (STOP_TIMER) 
			  cancelTimer();
		  else
			  output.printJobStatus();
	   }
	 }


}
