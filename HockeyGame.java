package hockeyPackageEh;
import java.util.*;
import java.io.*;

public class HockeyGame {
	
	//private instance variables
	
	private String homeTeam, awayTeam;
	private int homeScore, awayScore;
	
	//constructor
	public HockeyGame() {
		
	}
	
	public void getGames()throws IOException{
		Scanner input = new Scanner(new FileReader("hockey.txt"));
		homeTeam = input.next();
		homeScore = input.nextInt();
		awayTeam = input.next();
		awayScore = input.nextInt();
	}

}
