package inProgress;

public class chronotimer_inprogress {
	
	package home;

import java.time.Clock;
import java.time.LocalTime;
import java.util.*;

	public class ChronoTimer {
		
		static boolean power;
		static Scanner console = new Scanner(System.in);
		boolean chanTog [] = new boolean[9];
		static int totRacers;
		static Queue<Racer> racers = new LinkedList<Racer>();
		//time
		static Clock time;
		static LocalTime time2;
		static double start;
		
		public ChronoTimer() {
			
			ChronoTimer.power = false; 
		}
		
		public static void main (String args[]) {
			
			Simulator Chrono = new Simulator();
			time = Clock.systemUTC();
			start = time.millis();
			Chrono.textReader();
		}
		
		static void getInput() {
			
			boolean runConsole = true;
			
			while(runConsole) {
				
				System.out.println("POWER to turn on");
				String input;
				input = console.nextLine();
				String [] splitted = input.split("\\s+");
					
				if (input.equalsIgnoreCase("POWER")) {
					/////// adding power call, terminates if power called ???? change???
					if(power == false){
					power = true;
					System.out.println("Welcome to the Chronotimer");	
				}
				else if(power == true){
					power = false;
					System.out.println("Shutting off ChronoTimer");
				}			
				}
					
				else if (input.equalsIgnoreCase("EXIT")) {
					System.exit(0);
					
				}
				
				while(power ==true){
					System.out.println("Enter Your command: 'LIST' for list of commands: ");
					input = console.nextLine();
					
				if(input.equalsIgnoreCase("POWER")){
					power = false;
					System.out.println("Shutting off ChronoTimer");
				}
		
				else if (input.equalsIgnoreCase("TIME")) {
					
					
				}
				
				else if (input.equalsIgnoreCase("RESET")) {
					
				}
				
				else if (input.equalsIgnoreCase("DNF")) {
					
				}
				
				else if (input.equalsIgnoreCase("CANCEL")) {
					
					
				}
				
				else if (input.equalsIgnoreCase("TOG")) {
					
					System.out.println("toggled: next command?");
					
					startTime();
					//finishTime() will return double of final race time
				}
				
				else if (input.equalsIgnoreCase("TRIG")) {
					
					
				}
				
				else if (input.equalsIgnoreCase("START")) {
					
				}
				
				else if (input.equalsIgnoreCase("FINISH")) {
					
				}
				
				else if (splitted[0].equalsIgnoreCase("NUM")) {
					
					totRacers++;
					racers.add(new Racer(Integer.parseInt(splitted[1]), totRacers));
				}
				
				else if (input.equalsIgnoreCase("LIST")) {
					
					System.out.println("POWER: end program. \n" + 
							"EXIT: \n" +
							"RESET: reset all run times and settings \n" + "TIME: \n" + 
							"DNF: end that racers run, with no finish time\n" + 
							"NUM: to create racer\n" + 
							"...................... \n");
				}
				
				else {
					System.out.println("Not a valid command, type 'LIST' to list commands: \n");
				}	
			}//end while
			}
		}
		
		static void startTime()
		{
			start = time.millis();
		}
		static double finishTime()
		{
			return (time.millis()-start) / 100;
			//System.out.println(LocalTime.now());
			
		}
		
		static boolean getPower() {
			
			return power;
		}
		
		static boolean setPower() {
			
			if(!power)
			{
				power = true;
			}
			else if(power)
			{
				power = false;
				//end program? restart simulator? 
			}
			else
			{
				return false;
			}
			
			return true;
			
		}

	}

}
