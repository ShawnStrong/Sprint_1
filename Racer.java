package home;

public class Racer {
	
	public int racerNum;
	public int totalRacers;
	public int x;
	public int y;
	
	public Racer (int rNum, int tRacers) {
		
		this.racerNum = rNum;
		this.totalRacers = tRacers;
		
		// stores the channel to be turned on
		this.x = totalRacers * 2 - 1;
		this.y = totalRacers * 2;
	}
}
