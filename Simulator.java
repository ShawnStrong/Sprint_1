package home;

import java.io.*;
import java.util.*;

public class Simulator {
	
Scanner console;
File actual;

Simulator() {
		
	this.console = new Scanner(System.in);
	this.actual = null;
}
	
	public void textReader() {
		
		boolean querySuccess = false;
		
		while (!(querySuccess)) {
			// Select either file or input
			System.out.println("\ntype 'file' to read from file or 'input' for manual inputs: " );
			String selection = console.next();
			
			if (selection.equalsIgnoreCase("file")) {
				
				boolean checkRun = true;
				querySuccess = true;
				
				while (checkRun) {
					
					//querySuccess = true;
					System.out.println("\nwhich file would you like to run?(enter 'run1' or 'run2') ");
					String input = console.next();
					
					if (input.equalsIgnoreCase("run1")) {
						
						actual = new File("src/CTS1RUN1.txt");
						checkRun = false;
					}
					
					else if(input.equalsIgnoreCase("run2")) {
						
						actual = new File("src/CTS1RUN2.txt");
						checkRun = false;
					}
					
					else {
						
						System.out.println("\nnot a valid file: enter either 'run1' or 'run2'");
					}
				}
				//a correct file has been selected and will now be read
				try (BufferedReader br = new BufferedReader(new FileReader(actual))){

					String[] split = { "", "" };
					String line = br.readLine();
					
					while (line != null) {
							
						split = line.split("\\s+");
						System.out.println(line);
							
						if (split[1].equalsIgnoreCase("POWER")) {
							
							ChronoTimer.setPower();
						}
							
						else if (split[1].equalsIgnoreCase("EXIT")) {
							
							System.out.println("Exiting program, goodbye \n");
							System.exit(0);
						}
						
						else if (split[1].equalsIgnoreCase("EVENT")) {
							
							if (split[2].equalsIgnoreCase("IND")) {
								
							}
						}
						
						else if (split[1].equalsIgnoreCase("NEWRUN")) {
							
						}
						
						else if (split[1].equalsIgnoreCase("ENDRUN")) {
							
						}
						
						else if (split[1].equalsIgnoreCase("TIME")) {
							
							Time.setTime(split[2]);	
							System.out.println("You set the time at: " + split[2] + "\n");
						}
						
						else if (split[1].equalsIgnoreCase("NUM")) {
							
						}
						
						else if (split[1].equalsIgnoreCase("TOG")) {
							
							ChronoTimer.togChannel(Integer.parseInt(split[2]));
							System.out.println("You just toggled: " + split[2] + "\n");
						}
						
						else if (split[1].equalsIgnoreCase("TRIG")) {
							
							System.out.println("You just triggered: " + split[2] + "\n");
							ChronoTimer.trigChannel(Integer.parseInt(split[2]));
						}
						
						// Text files never call these buttons. 
						
						//else if (split[1].equalsIgnoreCase("RESET")) {Time.reset();}
						//else if (split[1].equalsIgnoreCase("DNF")) {}
						//else if (split[1].equalsIgnoreCase("CANCEL")) {}
						//else if (split[1].equalsIgnoreCase("START")) {}
						//else if (split[1].equalsIgnoreCase("FINISH")) {}
						
						line = br.readLine();
						split = line.split("\\s+");
						
					}//end while
				} //end try
				catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
			else if(selection.equalsIgnoreCase("input")) {
				
				querySuccess = true;
				ChronoTimer.getInput();
			}
			
			else {
				
				System.out.println("not a valid input");
			}	
		}	
	}
}
