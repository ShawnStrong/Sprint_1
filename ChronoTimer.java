package home;

import java.util.*;
import java.time.*;

public class ChronoTimer {
	//system
	static boolean power;
	static boolean out;
	static Scanner console = new Scanner(System.in);
	static Channel one = new Channel();
	static Channel two = new Channel();
	static Channel three = new Channel();
	static Channel four = new Channel();
	//race
	boolean chanTog[] = new boolean[9];
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
					
					System.out.println("enter which lane to toggle start(1,2,3,4,5,6,7,8): \n");
					input = console.nextLine();
					out = false;
					while(!out)
					{
						if(input.equals("1"))
						{
							one.top = (!one.top);
							
						}
						else if(input.equals("3"))
						{
							two.top = (!two.top);
						}
						else if(input.equals("5"))
						{
							three.top = (!three.top);
						}
						else if(input.equals("7"))
						{
							four.top = (!four.top);
						}
						else
						{
							System.out.println("invalid number \n");
						}
					}
					startTime();
					//finishTime() will return double of final race time
				}
				
				else if (input.equalsIgnoreCase("TRIG")) {
					System.out.println("enter which channel to trigger: ");
					input = console.nextLine();
					//CHECK IF INPUT IS A VALID CHANNEL NUMBER
					
					
				}
				
				else if (input.equalsIgnoreCase("START")) {
					
				}
				
				else if (input.equalsIgnoreCase("FINISH")) {
					
				}
				
				else if (input.equalsIgnoreCase("NUM")) {
					
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



