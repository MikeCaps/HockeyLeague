package hockeyPackageEh;
import java.util.*;
import java.io.*;
public class HockeyTeam {

	/*---------------------------------------------------------------------
	 * This class creates objects for each individual hockey team!        *
	 *             GLOBAL HOCKEY LEAGUE est. 2018                         *
	 *--------------------------------------------------------------------*/
	
	//instance variables
	
	private String city;
	private int gamesPlayed, wins, losses, ties, points, score;

	//constructors
	
	public HockeyTeam(String initCity, 
					  int initGames,
					  int initWins,
					  int initLosses,
					  int initTies,
					  int initPoints) {
		
		city = initCity;
		gamesPlayed = initGames;
		wins = initWins;
		losses = initLosses;
		ties = initTies;
		points = initPoints;
		
	}
	
	public HockeyTeam() {
		city  = "";
		gamesPlayed = 0;
		wins = 0;
		losses = 0;
		ties = 0;
		points = 0;
	}
	
	//methods
	public void readInput(Scanner input) throws IOException {
		city = input.next(); 
		gamesPlayed = input.nextInt();
		wins = input.nextInt();
		losses = input.nextInt();
		ties = input.nextInt();
		points = input.nextInt();
		
	}
	
	
	public void writeOutput() {
		System.out.println(gamesPlayed + "\t" + wins + "\t" 
					+ losses + "\t" + ties + "\t" + points + "\t" + city);
	}
	
	//"getters" and "setters"
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int newPoints) {
		this.points = newPoints;
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}
	
}
