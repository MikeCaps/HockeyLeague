package hockeyPackageEh;
import java.util.*;
import java.io.*;

/*---------------------------------------------------------------------
 * This class creates the array that stores all teams and their data. *
 *             GLOBAL HOCKEY LEAGUE est. 2018                         *
 *--------------------------------------------------------------------*/

public class HockeyLeague {
	
	//instance variables
	private HockeyTeam [] globalLeague;
	private int leagueSize;
	
	//default constructor
	public HockeyLeague(){
		
	}
	
	//methods
	public void inputData() throws IOException {
		Scanner input = new Scanner(new FileReader("firstround.txt"));
		
		leagueSize = input.nextInt();
		
		globalLeague = new HockeyTeam[leagueSize];
		
		for(int i = 0; i < leagueSize; i++) {
			globalLeague[i] = new HockeyTeam();
			globalLeague[i].readInput(input);
			
		}
		
	}
	
	//prints current league standings
	public void standings() {
		System.out.println("GP\tW\tL\tT\tPts.\tCity");
		System.out.println();
		for(int i = 0; i < leagueSize; i++) {
			globalLeague[i].writeOutput();
		}
	}
	
	//returns the HockeyTeam object that is searched for
	public HockeyTeam search(String key) {
		boolean found = false;
		int i = 0;
		while(found == false && i < leagueSize) {
			if(globalLeague[i].getCity().equals(key))
				found = true;
			else
				i++;
		}
		if(found == true)
			return globalLeague[i];
		else
			return null;
	}
	
	//this method reads in a list of scores, determines winners and losers, and updates the
	//standings accordingly
	public void update()throws IOException{
		String homeTeam = ""; 
		String awayTeam = "";
		int homeScore = 0; 
		int awayScore = 0;
		HockeyTeam winner = new HockeyTeam();
		HockeyTeam loser = new HockeyTeam();
		Scanner input2 = new Scanner(new FileReader("hockey.txt"));
		
		
			for(int j = 0; j < 66; j++) {
				homeTeam = input2.next();
				homeScore = input2.nextInt();
				awayTeam = input2.next();
				awayScore = input2.nextInt();
			
				if(homeScore > awayScore) {
					winner = search(homeTeam);
					loser = search(awayTeam);
					winner.setWins(winner.getWins()+1);
					winner.setPoints(winner.getPoints()+2);
					loser.setLosses(loser.getLosses()+1);
					winner.setGamesPlayed(winner.getGamesPlayed()+1);
					loser.setGamesPlayed(loser.getGamesPlayed()+1);
				}else if(awayScore > homeScore) {
					winner = search(awayTeam);
					loser = search(homeTeam);
					winner.setWins(winner.getWins()+1);
					winner.setPoints(winner.getPoints()+2);
					loser.setLosses(loser.getLosses()+1);
					winner.setGamesPlayed(winner.getGamesPlayed()+1);
					loser.setGamesPlayed(loser.getGamesPlayed()+1);
				}else if (homeScore == awayScore) {
					winner = search(awayTeam);
					loser = search(homeTeam);
					winner.setTies(winner.getTies()+1);
					winner.setPoints(winner.getPoints()+1);
					loser.setTies(loser.getTies()+1);
					loser.setPoints(loser.getPoints()+1);
					winner.setGamesPlayed(winner.getGamesPlayed()+1);
					loser.setGamesPlayed(loser.getGamesPlayed()+1);
				}
				
				//these lines used to check input2 was working properly
				//System.out.println(homeTeam + " " + homeScore);
				//System.out.println(awayTeam + " " + awayScore);
			
			}
	}
	
	//swaps index of two teams in globalLeague array
	public void swap(int first, int second) {
		HockeyTeam temp;
		temp = globalLeague[first];
		globalLeague[first] = globalLeague[second];
		globalLeague[second] = temp;
	}
	
	//sort that was requested, only sorts by points earned via wins and ties
	public void sort() {
		int i, j, min;
		
		for(i = 0; i < leagueSize; i++) {
			min = i;
			
			for(j = 0; j < leagueSize; j++) {
				if(globalLeague[j].getPoints() < globalLeague[min].getPoints()) {
					min = j;
					swap(i, min);
				}
			}
		}
	}
	
	//EXTRA CREDIT
	//more general sort that utilizes .equalsIgnoreCase() to sort by wins, losses, ties, or points
	public void sortBy(String newStat) {
		int i, j, min;
		if(newStat.equalsIgnoreCase("wins")) {
			
			for(i = 0; i < leagueSize; i++) {
				min = i;
				
				for(j = 0; j < leagueSize; j++) {
					if(globalLeague[j].getWins() < globalLeague[min].getWins()) {
						min = j;
						swap(i, min);
					}
				}
			}
			
		}else if(newStat.equalsIgnoreCase("losses")) {
			
			for(i = 0; i < leagueSize; i++) {
				min = i;
				
				for(j = 0; j < leagueSize; j++) {
					if(globalLeague[j].getLosses() < globalLeague[min].getLosses()) {
						min = j;
						swap(i, min);
					}
				}
			}
		}else if(newStat.equalsIgnoreCase("ties")) {
		
			for(i = 0; i < leagueSize; i++) {
				min = i;
				
				for(j = 0; j < leagueSize; j++) {
					if(globalLeague[j].getTies() < globalLeague[min].getTies()) {
						min = j;
						swap(i, min);
					}
				}
			}
		}else if(newStat.equalsIgnoreCase("points")) {
			
			for(i = 0; i < leagueSize; i++) {
				min = i;
				
				for(j = 0; j < leagueSize; j++) {
					if(globalLeague[j].getPoints() < globalLeague[min].getPoints()) {
						min = j;
						swap(i, min);
					}
				}
			}
		}else if(newStat.equalsIgnoreCase("city")) {
			for(i = 0; i < leagueSize; i++) {
				min = i;
				
				for(j = 0; j < leagueSize; j++) {
					if(globalLeague[j].getCity().compareTo(globalLeague[min].getCity()) > 0) {
						min = j;
						swap(i, min);
					}
				}
			}
		}
		
		else {
			System.out.println("Please enter a proper stat, e.g. \"wins\" or \"losses\".");
		}
		
	}
	
	//EXTRA CREDIT
	//sortByCity() uses String.compareTo() to sort standings alphabetically by city
	public void sortByCity() {
		int i, j, min;
		
		for(i = 0; i < leagueSize; i++) {
			min = i;
			
			for(j = 0; j < leagueSize; j++) {
				if(globalLeague[j].getCity().compareTo(globalLeague[min].getCity()) > 0) {
					min = j;
					swap(i, min);
				}
			}
		}
	}
	
	//EXTRA CREDIT
	//prints out 1st, 2nd, and 3rd place teams
	public void leagueLeaders() {
		sortBy("points");
		System.out.println("Current league leaders are: ");
		System.out.println("First Place: " + globalLeague[0].getCity());
		System.out.println("Second Place: " + globalLeague[1].getCity());
		System.out.println("Third Place: " + globalLeague[2].getCity());
	}
			
}//end of class