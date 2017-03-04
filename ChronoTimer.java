

import java.util.*;
import java.time.*;

public class ChronoTimer {
	// system
	static boolean power;
	static boolean run;
	static boolean event;
	static boolean out;
	static Scanner console = new Scanner(System.in);
	static Channel[] channels;
	// race
	static int totRacers;
	//static Queue<Racer> racers = new LinkedList<Racer>();
	static LinkedList<Racer> racers = new LinkedList<Racer>();
	static LinkedList<Racer> toFinish = new LinkedList<Racer>();
	static LinkedList<Racer> completed = new LinkedList<Racer>();
	// time
	static Clock time;
	static LocalTime time2;
	static double start;

	public ChronoTimer() {

		ChronoTimer.power = false;
		ChronoTimer.run = false;
		ChronoTimer.event = false;
		ChronoTimer.channels = new Channel[4];
	}

	public static void main(String args[]) {

		Simulator Chrono = new Simulator();
		time = Clock.systemUTC();
		start = time.millis();
		Chrono.textReader();
	}

	static void getInput() {

		boolean runConsole = true;

		while (runConsole) {

			System.out.println("POWER to turn on");
			String input;
			input = console.nextLine();
			String[] splitted = input.split("\\s+");

			if (splitted[0].equalsIgnoreCase("POWER")) {
				/////// adding power call, terminates if power called ????
				/////// change???
				if (power == false) {
					power = true;
					System.out.println("Welcome to the Chronotimer");
				} else if (power == true) {
					power = false;
					System.out.println("Shutting off ChronoTimer");
				}
			}

			else if (splitted[0].equalsIgnoreCase("EXIT")) {
				System.exit(0);

			}
			
			else if(splitted[0].equalsIgnoreCase("EVENT") && power)
			{
				
			}

			else if (splitted[0].equalsIgnoreCase("RESET") && power) {
				channels[0].top = false;
				channels[0].bottom = false;
				channels[1].top = false;
				channels[1].bottom = false;
				channels[2].top = false;
				channels[2].bottom = false;
				channels[3].top = false;
				channels[3].bottom = false;
				//reset Racer queue to empty
				racers.clear();
				//reset time
				//TODO
			}
			
			else if (splitted[0].equalsIgnoreCase("NEWRUN") && power && event && !run)
			{
				run = true;
			}
			else if (splitted[0].equalsIgnoreCase("NUM") && power && event && run) {

				totRacers++;
				racers.add(new Racer(Integer.parseInt(splitted[1]), totRacers));
			}
			else if (splitted[0].equalsIgnoreCase("START") && power && event && run && !racers.isEmpty()) {

			}

			else if (splitted[0].equalsIgnoreCase("FINISH") && power && event && run && !racers.isEmpty()) {

			}
			else if (splitted[0].equalsIgnoreCase("TRIG") && power && event && run && !racers.isEmpty()) {
				System.out.println("enter which channel to trigger: ");
				input = console.nextLine();
				// CHECK IF INPUT IS A VALID CHANNEL NUMBER

			}
			else if (splitted[0].equalsIgnoreCase("TOG") && power && event && run) {
				togChannel(Integer.parseInt(splitted[1]));
			}
			else if (splitted[0].equalsIgnoreCase("PRINT") && power && event && run){
				receipt();
			}
			else if (splitted[0].equalsIgnoreCase("ENDRUN")&& power && event && run){
				run = false;
			}
			else if (splitted[0].equalsIgnoreCase("TIME")) {

			}
			

			

			else if (splitted[0].equalsIgnoreCase("DNF")) {
				toFinish.remove(0);
				//Finish time is equal to DNF
				
				//Print DNF on the printing receipt
				
				
			}

			else if (splitted[0].equalsIgnoreCase("CANCEL")) {
				Racer temp = toFinish.getFirst();
				toFinish.removeFirst();
				racers.add(0,temp); 
				//still not sure if this is the correct way to do this
				//TODO reset start and finish time TODO 
			}
			else if (splitted[0].equalsIgnoreCase("LIST")) {

				System.out.println("POWER: end program. \n" + "EXIT: \n" + "RESET: reset all run times and settings \n"
						+ "TIME: \n" + "DNF: end that racers run, with no finish time\n" + "NUM: to create racer\n"
						+ "...................... \n");
			}

			else {
				System.out.println("Not a valid command, type 'LIST' to list commands: \n");
			}
		}
	} // end while

	static void receipt(){
		// Cycles through the completed linkedlist and prints out the racer's number and time
		for(int i = 0; i < completed.size(); i++){
			
			System.out.println("Racer " + completed.get(i).racerNum + "time: ");
			
		}
	}
	static void startTime() {
		start = time.millis();
	}

	static double finishTime() {
		return (time.millis() - start) / 100;
		// System.out.println(LocalTime.now());

	}
	// returns the current value/state of power 
	static boolean getPower() {

		return power;
	}
	// sets the power to be its opposite value
	static boolean setPower() {

		power = !power;	
		
		if (power == true) {
			
			System.out.println("The power is on \n");
		}
		
		System.out.println("The power is off \n");
	}

	static void togChannel(int input){
		int channel = (int) Math.ceil((double) input / 2) - 1;
		if(input % 2 == 1){
			
			if(!channels[channel].bottom){
				channels[channel].bottom = true;
			}
			else{
				channels[channel].bottom = false;
			}
		}else{
			if(!channels[channel].top){
				channels[channel].top = true;
			}
			else{
				channels[channel].top = false;
			}
		}
	}
}
