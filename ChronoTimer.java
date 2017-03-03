package home;

import java.util.Scanner;

public class ChronoTimer {
	static boolean power;
	static Scanner console = new Scanner(System.in);
	
	public ChronoTimer()
	{
		ChronoTimer.power = false; 
	}
	
	public static void main(String args[])
	{
		Simulator Chrono = new Simulator();
		Chrono.textReader();
	}
	
	static void getInput()
	{
		System.out.println("Enter Your command: 'LIST' for list of commands: ");
		String input;
		boolean runConsole = true;
		while(runConsole) 
		{
			input = console.nextLine();
				
			if (input.equalsIgnoreCase("POWER"))
			{
/////// adding power call, terminates if power called ???? change???
				System.exit(0);
			}
				
				
			else if(input.equalsIgnoreCase("EXIT"))
			{
				
				
			}
			else if(input.equalsIgnoreCase("TIME"))
			{
				
				
			}
			else if(input.equalsIgnoreCase("RESET"))
			{
				
			}
			else if(input.equalsIgnoreCase("DNF"))
			{
				
			}
			else if(input.equalsIgnoreCase("CANCEL"))
			{
				
			}
			else if(input.equalsIgnoreCase("TOG"))
			{
				System.out.println("toggled: next command?");
			}
			else if(input.equalsIgnoreCase("TRIG"))
			{
				
			}
			else if(input.equalsIgnoreCase("START"))
			{
				
			}
			else if(input.equalsIgnoreCase("FINISH"))
			{
				
			}
			else if(input.equalsIgnoreCase("LIST"))
			{
				System.out.println("POWER: end program. \n" + "EXIT: \n" +
			"RESET: reset all run times and settings \n" + "TIME: \n" + "DNF: end that racers run, with no finish time\n"
			+ "...................... \n");
			}
			else
			{
				System.out.println("Not a valid command, type 'LIST' to list commands: \n");
			}
			
		
		}//end while
	}
	
	
	static boolean getPower()
	{
		return power;
	}
	static boolean setPower()
	{
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
